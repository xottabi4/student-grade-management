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
				<h1>Welome</h1>
				<hr>
				<p>A TR row node, TD/TH cell node or an integer. If given as a TR node 
				then the data source for the whole row will be returned. If given as a
				 TD/TH cell node then iCol will be automatically calculated and the data
				  for the cell returned. If given as an integer, then this is treated as
				   the aoData internal data index for the row (see fnGetPosition) and the
				    data for that row used.A TR row node, TD/TH cell node or an integer. If given as a TR node 
				then the data source for the whole row will be returned. If given as a
				 TD/TH cell node then iCol will be automatically calculated and the data
				  for the cell returned. If given as an integer, then this is treated as
				   the aoData internal data index for the row (see fnGetPosition) and the
				    data for that row used.A TR row node, TD/TH cell node or an integer. If given as a TR node 
				then the data source for the whole row will be returned. If given as a
				 TD/TH cell node then iCol will be automatically calculated and the data
				  for the cell returned. If given as an integer, then this is treated as
				   the aoData internal data index for the row (see fnGetPosition) and
				    </p>
				
				</div>
			</div>
			<jsp:include page="/WEB-INF/pages/rightPane.jsp" />
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>