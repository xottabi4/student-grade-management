$(document).ready(function() {
    var selectedFacultyTitle;
    var selectedCourseTitle;
    var selectedSubjectTitle;

    $("#faculty-selection>li").on('click', function(e) {
        e.preventDefault();
        $("#course-chooser").empty();
        $("#subject-chooser").empty();
        var $this = $(this);
        selectedFacultyTitle = $this.text().trim();
        $(".faculty-selection").parents('li,ul').removeClass('active');
        $this.addClass('active');
        var url = "/professor/createGroup/viewCourses";
        $("#course-chooser").load(url);
        return false;
    });
    $("#course-chooser").on('click', 'li', function(e) {
        e.preventDefault();
        $("#subject-chooser").empty();
        var $this = $(this);
        selectedCourseTitle = $this.text().trim();
        $(".course-selection").parents('li,ul').removeClass('active');
        $this.addClass('active');
        var url = "/professor/createGroup/viewSubjects";
        $.post(url, {
            selectedFaculty: selectedFacultyTitle
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
        selectedSubjectTitle = $this.text().trim();
        return false;
    });

    $("#submit-data").on('click', function(e) {
        e.preventDefault();
        var groupTitle = $('#group-title-input>input').val().trim();
        var serialized = JSON.stringify({
            groupTitle: groupTitle,
            facultyTitle: selectedFacultyTitle,
            courseTitle: parseInt(selectedCourseTitle),
            subjectTitle: selectedSubjectTitle
        });
        $.ajax({
            url: "/professor/createGroup",
            type: 'POST',
            data: serialized,
            dataType: "html",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data) {
                alert(data);
                return false;
            }
        });
        return false;
    });
});
