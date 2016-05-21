<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>SGM student grades</title>

<link href="<c:url value="/resources/css/pageLayout.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="<c:url value="/resources/js/mainPageScrips.js" />"></script>

<style type="text/css">
table {
	margin-top: 10px;
	border: solid black 1px;
}

table  td {
	padding: 5px;
}

.message {
	font-size: 90%;
	color: blue;
	font-style: italic;
	margin-top: 30px;
}
</style>

</head>

<body>
	<jsp:include page="/WEB-INF/pages/student/studentNavBar.jsp" />
	<div class="container-fluid text-center">
		<div class="row content">
			<jsp:include page="/WEB-INF/pages/leftPane.jsp" />
			<div class="col-sm-8 text-left">
				<table border="1">
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Description</th>
						<th>Grade</th>
					</tr>
					<c:forEach items="${studentGrades}" var="info">
						<tr>
							<td>${info.title}</td>
							<td>${info.date}</td>
							<td>${info.description}</td>
							<td>${info.grade}</td>
						</tr>

					</c:forEach>
				</table>
			</div>
			<jsp:include page="/WEB-INF/pages/rightPane.jsp" />
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>