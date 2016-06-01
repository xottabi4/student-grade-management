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

    var table = $('#add-students').DataTable();

    $("#add-row").on('click', function(e) {
        e.preventDefault();
        table.row.add([
            '<td><input type="text" class="form-control matrikula" value="" name="text"/></td>',
            '<td><input type="text" class="form-control name" value="" name="text"/></td>',
            '<td><input type="text" class="form-control surname" value="" name="text"/></td>'
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
            } else if ($(this).hasClass('name')) {
                item['name'] = $(this).val();
            } else if ($(this).hasClass('surname')) {
                item['surname'] = $(this).val();
                data_array.push(item);
            }
        });
        var groupTitle = $('#group-title-input>input').val().trim();
        var serialized = JSON.stringify({
            students: data_array,
            groupTitle: groupTitle,
            facultyTitle: selectedFacultyTitle,
            courseTitle: parseInt(selectedCourseTitle),
            subjectTitle: selectedSubjectTitle
        });

        // alert("table has \n" + serialized);
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
