$(document).ready(function() {
    // var selectedFacultyTitle;
    // var selectedCourseTitle;
    // var selectedSubjectTitle;
    //TODO jquery multiple onclik functions
    $(".faculty-selection").on('click',  function() {
        var $this = $(this);
        // selectedFacultyTitle= $this.text();
        $(".faculty-selection").parents('li,ul').removeClass('active');
        $this.parents('li,ul').addClass('active');
        var url = "/professor/createGroup/viewCourses";
        $("#course-chooser").load(url);
        // e.stopImmediatePropagation();
        return false;
    });
    $(".course-selection").on('click',function() {
        // alert(selectedFacultyTitle);
        var $this = $(this);
        alert($this);
        $(".course-selection").parents('li,ul').removeClass('active');
        $this.parents('li,ul').addClass('active');
        var url = "/professor/createGroup/viewSubjects";
        // 		var selectedFacultyTitle ="IT";
        // //			$(".faculty-selection").find(".active").text();
        // //		alert(selectedFacultyTitle);
        // 		$.post(url, {
        // 			selectedFaculty : selectedFacultyTitle
        // 		}, function(result) {
        // 			$("#subject-chooser").html(result);
        // 		});
        return false;
    });
});
/*

	$(".subject-selection").on('click', function(e) {
		e.preventDefault();
		var $this = $(this);
		$(".subject-selection").parents('li,ul').removeClass('active');
		$this.parents('li,ul').addClass('active');
		var url = $(this).attr('href');
		var selectedFacultyTitle = $( ".faculty-selection option:selected" ).text();
		var selectedCourseTitle = $( "..course-selection option:selected" ).text();
		var selectedSubjectTitle = $(this).text();
		$.post(url, {
			selectedFaculty : selectedFacultyTitle
			selectedSubject : selectedSubjectTitle
			selectedCourse : selectedCourseTitle
		}, function(result) {
			$("#group-chooser").html(result);
		});
		return false;
	});
	$(".group-selection").on('click', function(e) {
		e.preventDefault();
		var $this = $(this);
		$(".group-selection").parents('li,ul').removeClass('active');
		$this.parents('li,ul').addClass('active');
//		$.post(url, {
//			selectedFaculty : selectedFacultyTitle
//			selectedSubject : selectedSubjectTitle
//			selectedCourse : selectedCourseTitle
//		}, function(result) {
//			$("#group-chooser").html(result);
//		});
		return false;
	});

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
