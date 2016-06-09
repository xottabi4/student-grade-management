$(document).ready(function() {
    var selectedFacultyTitle;
    var selectedCourseTitle;
    var selectedSubjectTitle;
    var selectedGroupID;
    $("#faculty-selection>li").on('click', function(e) {
        e.preventDefault();
        table.clear();
        table.draw();
        $("#course-chooser").empty();
        $("#subject-chooser").empty();
        $("#group-chooser").empty();
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
        table.clear();
        table.draw();
        $("#subject-chooser").empty();
        $("#group-chooser").empty();
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
        table.clear();
        table.draw();
        $("#group-chooser").empty();
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

    var table = $('#view-students').DataTable();

    $("#group-chooser").on('click', 'li', function(e) {
        e.preventDefault();
        table.clear();
        table.draw();
        var $this = $(this);
        $(".group-selection").parents('li,ul').removeClass('active');
        $this.addClass('active');
        selectedGroupID = parseInt($this.attr('id'));
        url = "/professor/viewStudentsInGroup";
        $.post(url, {
            selectedGroupID: selectedGroupID
        }, function(result) {
            $(result).each(function(i, object) {
                var student = result[i];
                table.row.add([
                        student.matrikula,
                        student.name,
                        student.surname,
                        "<td><a href='#' id=" + student.matrikula + " role='button' class='btn btn-danger btn-xs remove-student'>Remove</a></td>"
                    ]).draw(false)
                    .nodes()
                    .to$();
            })
        });
        return false;
    });
    $('#view-students').on('click','.remove-student', function(e) {
        e.preventDefault();
        var url = "/professor/removeStudentsFromGroup";
        var $this = $(this);
        var selectedStudentID = parseInt($this.attr('id'));
        // alert(selectedStudentID);
        $.post(url, {
            selectedGroupID: selectedGroupID,
            selectedStudentID: selectedStudentID
        }, function(result) {
            table.row($this.parents('tr')).remove().draw();
            alert(result.message);
        });
        return false;
    });
});
