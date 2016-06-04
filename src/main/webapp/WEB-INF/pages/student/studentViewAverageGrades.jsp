<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
	<script src="<c:url value=" /resources/js/student/viewAverageGrades.js" />"></script>
<table id="view-student-grades" class="table table-responsive table-bordered table-hover table-condensed">
															<thead>
																<tr>
																<c:forEach items="${tasks}" var="task">
																	<th>${task.title}</th>
																	</c:forEach>
																	<th>End Grade</th>
																</tr>
																<tr>
																<c:forEach  items="${averageGrades}" var="averageGrade">
																	<td>${averageGrade}</td>
																	</c:forEach>
																</tr>
															</thead>
															<tbody>
															</tbody>
														</table>