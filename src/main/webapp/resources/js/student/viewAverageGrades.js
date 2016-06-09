$(document).ready(function() {
	var selectedFacultyTitle;
	var selectedCourseTitle;
	var selectedSubjectTitle;
	var selectedTaskTitle;
	var selectedGroupTitle;
	var taskID;
	var groupID;
	var data_array = [];

	var table2 = $('#view-student-grades').DataTable();
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
		var url = "/student/viewGroup/viewCourses";
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
		var url = "/student/viewGroup/viewSubjects";
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
		var url = "/student/viewGroup/viewGroups";
		$.post(url, {
			selectedFaculty : selectedFacultyTitle,
			selectedSubject : selectedSubjectTitle,
			selectedCourse : selectedCourseTitle
		}, function(result) {
			$("#group-chooser").html(result);
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
		if (groupID == null) {
			alert("No students selected!");
		} else {
			$('#divTable').show();
			e.preventDefault();
			var url = "/student/viewGroup/viewAverageGrades";
			$.get(url, {
				selectedGroupID : groupID
			}, function(result) {
				$("#task-chooser").html(result);
			});
			return false;
		}
	});

});
