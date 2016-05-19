<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>SGM home</title>

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

<body>
	<jsp:include page="/WEB-INF/pages/professor/professorNavBar.jsp" />
	<div class="container-fluid text-center">
		<div class="row content">
			<jsp:include page="/WEB-INF/pages/leftPane.jsp" />
			<div class="col-sm-8 text-left">
				<h1>Welcome</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat
					cupidatat non proident, sunt in culpa qui officia deserunt mollit
					anim id est laborum consectetur adipiscing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
					minim veniam, quis nostrud exercitation ullamco laboris nisi ut
					aliquip ex ea commodo consequat.</p>
				<hr>
			</div>
			<jsp:include page="/WEB-INF/pages/rightPane.jsp" />
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>