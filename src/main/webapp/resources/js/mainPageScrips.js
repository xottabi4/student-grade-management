$(document).ready(function() {
	$('a[href="' + this.location.pathname + '"]').parents('li,ul').addClass('active');
});
	
	
	
	
//	$('.menu li').click(function() {
//		$('.navbar li.active').removeClass('active');
//		var $this = $(this);
//		if (!$this.hasClass('active')) {
//			$this.addClass('active');
//		}
//		e.preventDefault();
//	});
//	
//    $(function() {
//        var pgurl = window.location.href.substr(window.location.href
//   .lastIndexOf("/")+1);
//        $("#nav ul li a").each(function(){
//             if($(this).attr("href") == pgurl || $(this).attr("href") == '' )
//             $(this).addClass("active");
//        })
//   });
	
//	$("a").on('click', function(e) {
//		// prevent the default action, in this case the following of a link
//		e.preventDefault();
//		// capture the href attribute of the a element
//		var url = $(this).attr('href');
//		// perform a get request using ajax to the captured href value
//		$("#content").load(url);
//		alert(url);
//		if (url === '/student/') {
//			$(document).prop('title', 'SGM student home');
//		} else {
//			$(document).prop('title', 'SGM student grades');
//		}
//	});

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
