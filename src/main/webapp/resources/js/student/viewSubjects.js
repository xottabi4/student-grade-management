$(document).ready(	
    function() {
        var selectedFacultyTitle;
   
        
        var table2 = $('#view-student-professors').DataTable();
        $('#divTable').hide();

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
            	selectedFacultyID: facultyID,
            }, function(result) {
                $(result).each(function(i, object) {
                    var studentGroup = result[i];
                    table2.row.add([
                                   studentGroup.user.name,
                                   studentGroup.user.surname,
                                   studentGroup.subject.title,
                                   studentGroup.title,
                                   studentGroup.course,
                                   
                        ]).draw(false)
                        .nodes()
                        .to$();
                })
                
            });

            return false;
        }); 
    });