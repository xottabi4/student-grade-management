$(document).ready(function() {
    var selectedFacultyTitle;
    var selectedCourseTitle;
    var selectedSubjectTitle;
    var groupID;


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
        var url = "/professor/createGroup/viewGroups";
        $.post(url, {
            selectedFaculty: selectedFacultyTitle,
            selectedSubject: selectedSubjectTitle,
            selectedCourse: selectedCourseTitle
        }, function(result) {
            $("#group-chooser").html(result);
        });
        return false;
    });
    $("#group-chooser").on('click', 'li', function(e) {
        e.preventDefault();
        var $this = $(this);
        groupID = parseInt($this.attr('id'));
        $(".group-selection").parents('li,ul').removeClass('active');
        $this.addClass('active');
        classname = $('.group-selection').attr('value');
        return false;
    });


    $("#submit-data").on('click', function(e) {
        e.preventDefault();
        var groupTitle = $('#group-title-input>input').val().trim();
        var url = "/professor/updateGroup";
        $.post(url, {
            groupID: groupID,
            newGroupTitle: groupTitle
        }, function(result) {
            alert(result.message);
            location.reload();
        });

        $.post(url, {
            groupTitle: groupTitle,
            selectedFaculty: selectedFacultyTitle,
            selectedCourse: parseInt(selectedCourseTitle),
            selectedSubject: selectedSubjectTitle
        }, function(result) {
            alert(result.message);
            location.reload();
        });
        return false;
    });
});
