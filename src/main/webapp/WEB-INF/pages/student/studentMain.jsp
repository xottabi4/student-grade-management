<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>SGM student home</title>

<link href="<c:url value="/resources/css/pageLayout.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<script src="<c:url value="/resources/js/mainPageScrips.js" />"></script>

<body>
	<jsp:include page="/WEB-INF/pages/student/studentNavBar.jsp" />
	<div class="container-fluid text-center">
		<div class="row content">
			<jsp:include page="/WEB-INF/pages/leftPane.jsp" />
			<div class="col-sm-8 text-left">
				<div id="main-content">
		<div id="left-column">
			<div id="logo">
			<img src="http://imgur.com/aomB4KX.jpg" width="140" height="30" />
			</div>
			<div class="box">
			<div id="main-image"><img src="http://imgur.com/1IcCAFm.jpg" width="120" height="140" /></div>
        		<h2>Michael Scott</h2>
        		<p><i>Student</i></p>
        		<p>Here are some of my interests: </p>
				<ul style="margin-top:10px; line-height:20px; ">
					<li>Information</li>
					<li>Information</li>
					<li>Information</li>
					<li>Information</li>
					<li>Information</li>
				</ul>
			</div>
			</div>
				<div id="right-column">
			<div class="sidebar">
				<h3>About me.</h3>
				<p>
				You've done basic HTML and CSS formatting, 
				and just finished up the Intro to CSS Positioning
				 lesson. Now you're going to apply
				  it to build a website layout for yourself.
				</p>
				
				<div class="contact-information">
				<h3>Contact Information</h3>
					<ul>
						<li>Talr.: +371 63628303</li>
						<li>E-mail:	info@venta.lv</li>
					</ul>
				</div>
			</div>
		</div>
			</div>
			</div>
			<jsp:include page="/WEB-INF/pages/rightPane.jsp" />
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>