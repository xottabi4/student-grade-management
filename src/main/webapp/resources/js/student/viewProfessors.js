$(document).ready(function() {
	var selectedFacultyTitle;
	var table = $('#view-professors').DataTable();
	$("#faculty-selection>li").on('click', function(e) {
		e.preventDefault();
		$('#view-student-professors').dataTable().fnClearTable();
		var $this = $(this);
		selectedFacultyTitle = $this.text();
		facultyID = parseInt($this.attr("id"));
		$(".faculty-selection").parents('li,ul').removeClass('active');
		$this.addClass('active');
		var url = "/student/viewGroup/getProfessors";
		$.get(url, {
			selectedFacultyID : facultyID
		}, function(result) {
			$("#professor-chooser").html(result);
		});
		return false;
	});
});