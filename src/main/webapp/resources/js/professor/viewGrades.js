$(document).ready(
		function() {
			var selectedFacultyTitle;
			var selectedCourseTitle;
			var selectedSubjectTitle;
			var selectedTaskTitle;
			var selectedGroupTitle;
			var taskID;
			var groupID;
			var data_array = [];
			var rowData;
			var grade_data_array = [];
			var gradesID;
			var gradeID;
			var id;
			var studentdID;
			var table = $('#view-student-grades').DataTable();
			var table2 = $('#view-student-average-grades').DataTable();
			var table3 =  $('#update-student-grades').DataTable();
			$('#divTable').hide();
			
			$("#faculty-selection>li").on('click', function(e) {
				e.preventDefault();
				$("#course-chooser").empty();
				$("#subject-chooser").empty();
				$("#group-chooser").empty();
				$("#task-chooser").empty();
				$('#set-student-grades').dataTable().fnClearTable();
				var $this = $(this);
				selectedFacultyTitle = $this.text();
				$(".faculty-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				var url = "/professor/createGroup/viewCourses";
				$("#course-chooser").load(url);
				return false;
			});
			$("#course-chooser").on('click', 'li', function(e) {
				$("#subject-chooser").empty();
				$("#group-chooser").empty();
				$("#task-chooser").empty();
				$('#set-student-grades').dataTable().fnClearTable();
				e.preventDefault();
				var $this = $(this);
				selectedCourseTitle = $this.text();
				$(".course-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				var url = "/professor/createGroup/viewSubjects";
				$.post(url, {
					selectedFaculty : selectedFacultyTitle
				}, function(result) {
					$("#subject-chooser").html(result);
				});
				return false;
			});
			$("#subject-chooser").on('click', 'li', function(e) {
				$("#task-chooser").empty();
				$("#group-chooser").empty();
				$('#set-student-grades').dataTable().fnClearTable();
				e.preventDefault();
				var $this = $(this);
				$(".subject-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				selectedSubjectTitle = $this.text();
				var url = "/professor/createGroup/viewGroups";
				$.post(url, {
					selectedFaculty : selectedFacultyTitle,
					selectedSubject : selectedSubjectTitle,
					selectedCourse : selectedCourseTitle
				}, function(result) {
					$("#group-chooser").html(result);
					// $(".group-selection_id").hide();
				});
				return false;
			});
			//

			$("#group-chooser").on('click', 'li', function(e) {
				e.preventDefault();
				$("#task-chooser").empty();
				$('#set-student-grades').dataTable().fnClearTable();
				var $this = $(this);
				groupID = parseInt($this.attr('id'));
				$(".group-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				selectedGroupTitle = $this.text();
				classname = $('.group-selection').attr('value');
				var url = "/professor/createGroup/viewTasks";
				$.post(url, function(result) {
					$("#task-chooser").html(result);
					// $(".task-selection-id").hide();
				});
				return false;
			});

			$("#task-chooser").on('click', 'li', function(e) {
				e.preventDefault();
				var $this = $(this);
				$('#view-student-grades').dataTable().fnClearTable();
				taskID = parseInt($this.attr("id"));
				$(".task-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				selectedTaskTitle = $this.text();
				var url = "/professor/viewGrades/getGrades";
				$.get(url, {
					selectedTaskID : taskID,
					selectedGroupID : groupID
				}, function(result) {
					// alert(result);
					$("#grade-chooser").html(result);

					// $(result).each(function(i, object) {
					// var studentGrades = result[i];
					// data_array.push(studentGrades.student.matrikula);
					// table.row.add([
					// studentGrades.student.matrikula,
					// studentGrades.student.name,
					// studentGrades.student.surname,
					// studentGrades.description,
					// studentGrades.grade,
					// studentGrades.date
					// ]).draw(false)
					// .nodes()
					// .to$();
					// })

				});

				var url = "/professor/viewGrades/getAllGrades";
				$.get(url, {
					selectedTaskID : taskID,
					selectedGroupID : groupID
				}, function(result) {
					$(result).each(function(i, object) {
						var studentGrades = result[i];
						if(studentdID!=studentGrades.student.matrikula){
						studentdID=studentGrades.student.matrikula;
						data_array.push(studentGrades.student.matrikula);}
					})

				});

				return false;
			});

			$("#average-grade-data").on(
					'click',
					function(e) {
						if (taskID == null || groupID == null
								|| data_array[0] == null) {
							//alert("No students selected!");
						} else {
							$('#divTable').show();
							$('#view-student-average-grades').dataTable()
									.fnClearTable();
							e.preventDefault();
							var url = "/professor/viewGrades/averageGrade";
							var j=0;
							$.get(url, {
								selectedTaskID : taskID,
								selectedGroupID : groupID
							}, function(result) {
								$(result).each(
										function(i, object) {
											var studentGrades = result[i];
											var averageGrade = data_array[i];
											table2.row.add(
													[ averageGrade,
															studentGrades ])
													.draw(false).nodes().to$();
										})
							});
							return false;
						}
					});

			$(".deleteBtn").click(function() {
				table.row( $(this).parents('tr'))
				 .remove()
			     .draw();
				var gradesID = parseInt(this.id);
				var url = "/professor/deleteStudentGrades";
				$.post(url, {
					selectedGradesID : gradesID,
				}, function(result) {
					alert(result.message);
					table.clear();
				});
				return false;
			});

			  
			
			$(".updateBtn").click(function() {

				gradeID = parseInt(this.id);
				alert(gradeID);
				var url =  "/professor/viewGrades/updateGrades";
				$.get(url, {
					selectedGradesID : gradeID,
				}, function(result) {
					$("#update-chooser").html(result);
					
				});
				return false;
			});

		
			   $(".submitBtn").click(function() {

					  var gradesID = parseInt(this.id);
						alert(gradesID);
						
						var description= $('#studentGradeDescriptionUpdate>input').val().trim();
						if(description == ""|| description == null){description = table3.cell('#GradeDescriptionUpdate').data();}
						var titleOfStudent= $('#studentGradeTitle>input').val().trim();
						if(titleOfStudent == ""|| titleOfStudent == null){titleOfStudent = table3.cell('#GradeTitle').data();}
						var gradeOfStudent= $('#studentGradeUpdate>input').val().trim();
						if(gradeOfStudent == ""|| gradeOfStudent == null || parseInt(gradeOfStudent)>10||parseInt(gradeOfStudent)<0||Math.round(gradeOfStudent) != gradeOfStudent){
							
							alert('Grade inputed wrong!')
							gradeOfStudent = table3.cell('#GradeUpdate').data();}

						alert(description);
						alert(titleOfStudent);
						alert(gradeOfStudent);
						
						var url =  "/professor/viewGrades/updateCurrentGrades";
						$.post(url, {
							selectedGradesID : gradesID,
							changedTitle : titleOfStudent,
							changedDescription : description,
							changedGrade : gradeOfStudent
						}, function(result) {
							table3.clear();
							table3.draw();
							$('#updateTable').hide();
							 table
						        .row( this )
						        .data()
						        .draw();
							alert(result);
						});
					
						return false;
					});	
				
				
			});
			
			 
					
				
					