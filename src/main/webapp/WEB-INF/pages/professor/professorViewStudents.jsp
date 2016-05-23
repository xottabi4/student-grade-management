<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>SGM professor create group</title>

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
</head>

<body>
	<jsp:include page="/WEB-INF/pages/professor/professorNavBar.jsp" />
	<div class="container-fluid text-center">
		<div class="row content">
			<jsp:include page="/WEB-INF/pages/leftPane.jsp" />
			<div class="col-sm-8 text-left">
				<h1>Welcome</h1>
				<p>choose faculty</p>
				<ul class="nav nav-pills">
					<c:forEach items="${facultys}" var="faculty">
						<li class="active"><a href="#">${faculty.title} </a></li>
					</c:forEach>
				</ul>
				<p>choose course</p>
				<ul class="nav nav-pills">
					<li class="active"><a href="#">1 </a></li>
					<li ><a href="#">2 </a></li>
					<li ><a href="#">3</a></li>
					<li ><a href="#">4 </a></li>
				</ul>
				<p>choose group</p>
				<ul class="nav nav-pills">
					<c:forEach items="${groups}" var="group">
						<li class="active"><a href="#">${group.title} </a></li>
					</c:forEach>
				</ul>
				<hr>
				<div class="col-md-6 text-left">
					<table
						class="table table-responsive table-striped table-bordered table-hover table-condensed">
						<thead>
							<tr>
								<th>#</th>
								<th>Firstname</th>
								<th>Lastname</th>
								<th>Age</th>
								<th>City</th>
								<th>Country</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Anna</td>
								<td>Pitt</td>
								<td>35</td>
								<td>New York</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>1</td>
								<td>Anna</td>
								<td>Pitt</td>
								<td>35</td>
								<td>New York</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>1</td>
								<td>Anna</td>
								<td>Pitt</td>
								<td>35</td>
								<td>New York</td>
								<td>USA</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-6 text-left">
					<table
						class="table table-responsive table-striped table-bordered table-hover table-condensed">
						<thead>
							<tr>
								<th>#</th>
								<th>Firstname</th>
								<th>Lastname</th>
								<th>Age</th>
								<th>City</th>
								<th>Country</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Anna</td>
								<td>Pitt</td>
								<td>35</td>
								<td>New York</td>
								<td>USA</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<jsp:include page="/WEB-INF/pages/rightPane.jsp" />
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>