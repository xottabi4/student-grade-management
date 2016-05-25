$(document).ready(
		function() {

			var selectedFacultyTitle;
			var selectedCourseTitle;
			var selectedSubjectTitle;

			$("#faculty-selection>li").on('click', function(e) {
				e.preventDefault();
				$("#course-chooser").empty();
				$("#subject-chooser").empty();
				$("#group-chooser").empty();
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
				e.preventDefault();
				var $this = $(this);
				$(".subject-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				selectedSubjectTitle = $this.text();
				var url = "/professor/createGroup/viewGrades";
				$.post(url, {
					selectedFaculty : selectedFacultyTitle,
					selectedSubject : selectedSubjectTitle,
					selectedCourse : selectedCourseTitle
				}, function(result) {
					$("#group-chooser").html(result);
				});
				return false;
			});

			$("#group-chooser").on('click', function(e) {
				e.preventDefault();
				var $this = $(this);
				$(".group-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				var url = "/professor/createGroup/viewTasks";
				$.post(url, function(result) {
					$("#task-chooser").html(result);
				});
				return false;
			});

			$("#task-chooser").on('click', 'li', function(e) {
				e.preventDefault();
				var $this = $(this);
				$(".task-selection").parents('li,ul').removeClass('active');
				$this.addClass('active');
				// selectedSubjectTitle = $this.text();
				// var url = "/professor/createGroup/viewTasks";
				// $.post(url, function(result) {
				// $("#group-chooser").html(result);
				// });
				return false;
			});

			// Funkcija lai editetu tabulu
			$(function() {
				$("td").dblclick(
						function() {
							var OriginalContent = $(this).text();
							$(this).addClass("cellEditing");
							$(this).html(
									"<input type='text' value='"
											+ OriginalContent + "' />");
							$(this).children().first().focus();
							$(this).children().first().keypress(
									function(e) {
										if (e.which == 13) {
											var newContent = $(this).val();
											$(this).parent().text(newContent);
											$(this).parent().removeClass(
													"cellEditing");
										}
									});
							$(this).children().first().blur(function() {
								$(this).parent().text(OriginalContent);
								$(this).parent().removeClass("cellEditing");
							});
						});
			});
		});
