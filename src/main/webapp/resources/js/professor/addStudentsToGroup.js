$(document).ready(function() {
    var selectedFacultyTitle;
    var selectedCourseTitle;
    var selectedSubjectTitle;
    var selectedGroupID;

    $("#faculty-selection>li").on('click', function(e) {
        e.preventDefault();
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
    $("#group-chooser").on('click', 'li', function(e) {
        e.preventDefault();
        $('#set-student-grades').dataTable().fnClearTable();
        var $this = $(this);
        $(".group-selection").parents('li,ul').removeClass('active');
        $this.addClass('active');
        selectedGroupID = parseInt($this.attr('id'));
        return false;
    });

    var table = $('#add-students').DataTable();

    $("#add-row").on('click', function(e) {
        e.preventDefault();
        table.row.add([
            '<td><input type="text" class="form-control matrikula" value="" name="text"/></td>',
        ]).draw();
        return false;
    });

    $("#submit-data").on('click', function(e) {
        e.preventDefault();
        var data = table.$('input');
        var data_array = [];
        var item = {};
        $.each(data, function(index, element) {
            if ($(this).hasClass('matrikula')) {
                item = {};
                item['matrikula'] = $(this).val();
            }
            data_array.push(item);
        });

        var serialized = JSON.stringify({
            students: data_array,
            groupID: selectedGroupID,
        });
        // alert("table has \n" + serialized);
        $.ajax({
            url: "/professor/addStudentsToGroup",
            type: 'POST',
            data: serialized,
            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(response) {
                if (response.status == true) {
                    alert(response.message);
                    location.reload();
                } else {
                    alert(response.message);
                }
                return false;
            }
        });
        return false;
    });
});
