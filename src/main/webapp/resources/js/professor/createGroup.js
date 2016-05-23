$(document).ready(function() {
    var selectedFacultyTitle;
    var selectedCourseTitle;
    var selectedSubjectTitle;

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
        $("#group-chooser").empty();
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
        });
        return false;
    });
    //TODO Make field for group title, make table with id(matrikula), name ,surname
    //  that you can edit+ when its filled add row, add create button after pressing
    // it post method to controller with all inputed data and redirect to home
    $("#group-chooser").on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        $(".group-selection").parents('li,ul').removeClass('active');
        $this.addClass('active');
        var url = "/professor/createGroup/viewStudents";
        //		$.post(url, {
        //			selectedFaculty : selectedFacultyTitle
        //			selectedSubject : selectedSubjectTitle
        //			selectedCourse : selectedCourseTitle
        //		}, function(result) {
        //			$("#student-chooser").html(result);
        //		});
        return false;
    });
});
/*




});
*/


/*
// $('.menu li').click(function() {
// $('.navbar li.active').removeClass('active');
// var $this = $(this);
// if (!$this.hasClass('active')) {
// $this.addClass('active');
// }
// e.preventDefault();
// });
//
// $(function() {
// var pgurl = window.location.href.substr(window.location.href
// .lastIndexOf("/")+1);
// $("#nav ul li a").each(function(){
// if($(this).attr("href") == pgurl || $(this).attr("href") == '' )
// $(this).addClass("active");
// })
// });

// $("a").on('click', function(e) {
// // prevent the default action, in this case the following of a link
// e.preventDefault();
// // capture the href attribute of the a element
// var url = $(this).attr('href');
// // perform a get request using ajax to the captured href value
// $("#content").load(url);
// alert(url);
// if (url === '/student/') {
// $(document).prop('title', 'SGM student home');
// } else {
// $(document).prop('title', 'SGM student grades');
// }
// });

// $("#logo").click(function() {
// $("#content").load("/");
// $('.navbar li.active').removeClass('active');
// #home.addClass('active');
// $(document).prop('title', 'SGM student home');
// });
// $("#home").click(function() {
// $("#content").load("/");
// $(document).prop('title', 'SGM student home');
// });
// $("#grades").click(function() {
// $("#content").load("/student/grades");
// $(document).prop('title', 'SGM student grades');
// document.location.hash = "/123/";
// });
// $("#subjects").click(function() {
// $("#content").load("/student/subjects");
// $(document).prop('title', 'SGM student subjects');
// document.location.hash = "/555/";
// });

// var url = window.location;
// // Will only work if string in href matches with location
// $(‘ul.nav a[href=”‘ + url + ‘”]’).parent().addClass(‘active’);
// // Will also work for relative and absolute hrefs
// $(‘ul.nav a’).filter(function () {
// return this.href == url;
// }).parent().addClass(‘active’);
// });
*/
