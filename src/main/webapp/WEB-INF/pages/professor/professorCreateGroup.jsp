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

							<link href="<c:url value=" /resources/css/pageLayout.css" />" rel="stylesheet">
								<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
									<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css">
										<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
										<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

										<script src="<c:url value=" /resources/js/mainPageScrips.js" />"></script>
										<script src="<c:url value=" /resources/js/professor/createGroup.js" />"></script>
									</head>

									<body>
										<jsp:include page="/WEB-INF/pages/professor/professorNavBar.jsp"/>
										<div class="container-fluid text-center">
											<div class="row content">
												<jsp:include page="/WEB-INF/pages/leftPane.jsp"/>
												<div class="col-sm-8 text-left">
													<h1>Welcome</h1>
													<p>choose faculty</p>
													<ul id="faculty-selection" class="nav nav-pills">
														<c:forEach items="${facultys}" var="faculty">
															<li>
																<a class="faculty-selection" href="#">${faculty.title}</a>
															</li>
														</c:forEach>
													</ul>

													<div id="course-chooser"></div>

													<div id="subject-chooser"></div>

													<div id="group-chooser"></div>

													<hr>
														<div id="student-chooser"></div>

														<table class="table table-responsive table-striped table-bordered table-hover table-condensed">
															<thead>
																<tr>
																	<th>#</th>
																	<th>Firstname</th>
																	<th>Lastname</th>
																</tr>
															</thead>
															<tbody>
																	<tr>
																		<td>matrikula</td>
																		<td>name</td>
																		<td>surname</td>
																	</tr>
															</tbody>
														</table>

													</div>
													<jsp:include page="/WEB-INF/pages/rightPane.jsp"/>
												</div>
											</div>
											<jsp:include page="/WEB-INF/pages/footer.jsp"/>
										</body>
									</html>
