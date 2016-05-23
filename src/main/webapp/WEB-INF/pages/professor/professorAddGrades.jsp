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
								<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
									<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css">
										<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
										<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

										<script src="<c:url value=" /resources/js/mainPageScrips.js" />"></script>
										<script src="<c:url value=" /resources/js/professor/addGrades.js" />"></script>
										<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
										<script type="text/javascript" src="script.js"></script>

									</head>

									<body>
										<jsp:include page="/WEB-INF/pages/professor/professorNavBar.jsp"/>
										<div class="container-fluid text-center">
											<div class="row content">
												<jsp:include page="/WEB-INF/pages/leftPane.jsp"/>
												<div class="col-sm-8 text-left">
													<h1>Welcome</h1>
													<hr>
														<table class="editableTable table-responsive table-striped table-bordered table-hover table-condensed">
															<thead>
																<tr>
																	<th>#</th>
																	<th>Firstname</th>
																	<th>Lastname</th>
																	<th>Age</th>
																	<th>City</th>
																	<th>Country</th>
																	<th>Grades</th>
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
																	<td></td>
																</tr>
																<tr>
																	<td>1</td>
																	<td>Anna</td>
																	<td>Pitt</td>
																	<td>35</td>
																	<td>New York</td>
																	<td>USA</td>
																	<td></td>
																</tr>
																<tr>
																	<td>1</td>
																	<td>Anna</td>
																	<td>Pitt</td>
																	<td>35</td>
																	<td>New York</td>
																	<td>USA</td>
																	<td></td>
																</tr>
																<tr>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
												<jsp:include page="/WEB-INF/pages/rightPane.jsp"/>
											</div>
											<jsp:include page="/WEB-INF/pages/footer.jsp"/>
										</body>
									</html>
