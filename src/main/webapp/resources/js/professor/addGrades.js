$(document).ready(
    function() {
        var selectedFacultyTitle;
        var selectedCourseTitle;
        var selectedSubjectTitle;
        var selectedTaskTitle;
        var selectedGroupTitle;
        var taskID;
        var groupID;
        var table = $('#set-student-grades').DataTable();
        var students = {};
        var gradeProblem = false;

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
                selectedFaculty: selectedFacultyTitle
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
                selectedFaculty: selectedFacultyTitle,
                selectedSubject: selectedSubjectTitle,
                selectedCourse: selectedCourseTitle
            }, function(result) {
                $("#group-chooser").html(result);
                // $(".group-selection_id").hide();
            });
            return false;
        });
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
            $.post(url,
                function(result) {
                    $("#task-chooser").html(result);
                    // $(".task-selection-id").hide();
                });
            return false;
        });
        $("#task-chooser").on('click', 'li', function(e) {
            e.preventDefault();
            var $this = $(this);
            $('#set-student-grades').dataTable().fnClearTable();
            taskID = parseInt($this.attr("id"));
            $(".task-selection").parents('li,ul').removeClass('active');
            $this.addClass('active');
            selectedTaskTitle = $this.text();
            var url = "/professor/addGrades/setGrades";
            $.get(url, {
                // selectedTaskID: taskID,
                selectedGroupID: groupID
            }, function(result) {
                $(result).each(function(i, object) {
                    var studentGrades = result[i];
                    students[i] = studentGrades.student.matrikula;
                    table.row.add([
                            studentGrades.student.matrikula,
                            studentGrades.student.name,
                            studentGrades.student.surname,
                            '<td><input type="text" class="form-control description" value="" name="text"/></td>',
                            '<td><input type="text" class="form-control grade" value="" name="text"/></td>'
                        ]).draw(false)
                        .nodes()
                        .to$();
                })
            });
            return false;
        });
        $("#submit-data").on('click', function(e) {
            e.preventDefault();
            var data = table.$('input');
            var data_array = [];
            var item = {};
            var student = {};
            var i = 0;
            var group = {};
            var task = {};
            gradeProblem = false;
            var themeTitle = $('#theme-title-input>input').val().trim();
            $.each(data, function(index, element) {
                if ($(this).hasClass('description')) {
                    item = {};
                    student = {};
                    group = {};
                    task = {};
                    group['groupID'] = groupID;
                    task['taskID'] = taskID;
                    student['matrikula'] = students[i];
                    item['task'] = task;
                    item['studentGroup'] = group;
                    item['student'] = student;
                    item['description'] = $(this).val();
                    item['title'] = themeTitle;
                    i = i + 1;
                } else if ($(this).hasClass('grade')) {
                    if (Math.round($(this).val()) != $(this).val()) {
                        alert("Grade format wrong!");
                        gradeProblem = true;
                    } else if ($(this).val() == "") {
                        alert("Grades not inputed!");
                        gradeProblem = true;
                    } else if ((parseInt($(this).val())) > 10 || (parseInt($(this).val())) < 0) {
                        alert("Wrong grades inputed!");
                        gradeProblem = true;
                    } else {

                        item['grade'] = $(this).val();
                        //isNumber($(this).val());
                        data_array.push(item);
                    }
                }
            });
            var serialized = JSON.stringify({
                groupGrades: data_array,
            });
            // alert("table has \n" + serialized);
            if (themeTitle == "" || themeTitle == null) {
                alert("You forgot to write the Theme!");
            } else if (gradeProblem == true) {

            } else {
                $.ajax({
                    url: "/professor/setStudentGrades",
                    type: 'POST',
                    data: serialized,
                    dataType: "html",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function(data) {
                        alert(data);
                        location.reload();
                        return false;
                    }
                });
            }


            return false;
        });
    });
