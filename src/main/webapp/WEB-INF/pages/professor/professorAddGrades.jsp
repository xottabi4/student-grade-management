<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1">
					<meta name="description" content="">
						<meta name="author" content="">
							<title>SGM professor add grades</title>

							<link href="<c:url value=" /resources/css/pageLayout.css" />" rel="stylesheet">
								<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/u/bs/jqc-1.12.3,dt-1.10.12/datatables.min.css"/>
								<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
									<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css">
										<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
										<script type="text/javascript" src="https://cdn.datatables.net/u/bs/jqc-1.12.3,dt-1.10.12/datatables.min.js"></script>
										<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
										<script src="<c:url value=" /resources/js/mainPageScrips.js" />"></script>
										<script src="<c:url value=" /resources/js/professor/addGrades.js" />"></script>
										<%-- <script type="text/javascript" src="script.js"></script> --%>
									</head>

									<body>
										<jsp:include page="/WEB-INF/pages/professor/professorNavBar.jsp"/>
										<div id="wrapper" class="container-fluid text-center">
											<div class="row content">
												<jsp:include page="/WEB-INF/pages/leftPane.jsp"/>
												<div class="col-sm-8 text-left">
													<h1>Welcome</h1>
													<hr>
														<h4 class="bg-info" style="color:#336666;">Choose faculty</h4>
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

														<div id="task-chooser"></div>

														<hr>
															<div class="row">
																<div class="col-sm-4 ">

																	<div id="theme-title-input" class="input-theme" style="margin-top: 10px;">
																		<span class="input-theme-addon" id="basic-addon1">Theme title:
																		</span>
																		<input type="text" class="form-control" aria-describedby="basic-addon1"></div>
																	</div>

																</div>
																<hr>
																	<table id="set-student-grades" class="table table-responsive table-bordered table-hover table-condensed">
																		<thead>
																			<tr>
																				<th>Matricula</th>
																				<th>Name</th>
																				<th>Surname</th>
																				<th>Description</th>
																				<th>Grade</th>

																			</tr>
																		</thead>
																		<tbody></tbody>
																	</table>
																	<div class="col-sm-6 center-block">
																		<a href="#" id="submit-data" class="btn btn-primary btn-md btn-info pull-right " role="button">Submit</a>
																	</div>
																</div>
																<jsp:include page="/WEB-INF/pages/rightPane.jsp"/>
															</div>
														</div>
														<jsp:include page="/WEB-INF/pages/footer.jsp"/>
													</body>
												</html>
