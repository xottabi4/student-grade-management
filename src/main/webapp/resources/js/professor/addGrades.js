$(document).ready(
    function() {
        var selectedFacultyTitle;
        var selectedCourseTitle;
        var selectedSubjectTitle;
        var selectedTaskTitle;
        var selectedGroupTitle;
        var className;

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
            $("#task-chooser").empty();
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
                $(".group-selection_id").hide();
            });
            return false;
        });
        //
        
        $("#group-chooser").on('click','li', function(e) {
            e.preventDefault();
            $("#grade-chooser").empty();
            var $this = $(this);
            //alert($gID);
            $(".group-selection_id").hide();
            $(".group-selection").parents('li,ul').removeClass('active');
            $this.addClass('active');
            selectedGroupTitle = $this.text();
            classname = $('.group-selection').attr('class');
            				var url = "/professor/createGroup/viewTasks";
            					 $.post(url,
            				function(result) {
            				 $("#task-chooser").html(result);
            					$(".task-selection-id").hide();
            				 });
            return false;
        });
        
        
        $("#task-chooser").on('click', 'li', function(e) {
            e.preventDefault();
            var $this = $(this);
            $(".task-selection-id").hide();
            $(".task-selection").parents('li,ul').removeClass('active');
            $this.addClass('active');
            selectedTaskTitle = $this.text();
            var url = "/professor/createGroup/viewGrades";
            $.post(url, 
            		{
                selectedTask: selectedTaskTitle.trim(),
                selectedGroup: selectedGroupTitle.trim()
            },
            function(result) {
                $("#grade-chooser").html(result);
                //This table is searching after name column
                var table = $('#view-student-grades').DataTable();
            }
            );
            return false;
        });

        
       

        // Funkcija lai editetu tabulu
        $(function() {
            $("td").dblclick(
                function() {
                    var OriginalContent = $(this).text();
                    $(this).addClass("cellEditing");
                    $(this).html(
                        "<input type='text' value='" + OriginalContent + "' />");
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
