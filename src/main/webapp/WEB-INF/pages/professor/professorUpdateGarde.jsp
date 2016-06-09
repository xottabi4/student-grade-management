<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
	<script src="<c:url value=" /resources/js/professor/viewGrades.js" />"></script>
	<hr>

		<div id="updateTable">
			<table id="update-student-grades" class="table table-responsive table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<th>Matricula</th>
						<th>Name</th>
						<th>Surname</th>
						<th>Title</th>
						<th>Description</th>
						<th>Grade</th>
						<th>Date</th>
						<th>Submit Changes</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${grade}" var="studentGrade">
						<tr>
							<td>
								${studentGrade.student.id}</td>
							<td>${studentGrade.student.name}</td>
							<td>${studentGrade.student.surname}</td>
							<td id="GradeTitle">${studentGrade.title}</td>
							<td id="GradeDescriptionUpdate">${studentGrade.description}</td>
							<td id="GradeUpdate">${studentGrade.grade}</td>
							<td>${studentGrade.date}</td>
							<td>
								<a id="${studentGrade.id}" class="submitBtn" style="text-decoration:none; color:white; background-color:#3366FF; padding:7px; border-radius: 28px;" role="button">Submit</a>
							</td>

						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td id="studentGradeTitle">
							<input type="text" class="form-control" aria-describedby="basic-addon1"></td>
							<td id="studentGradeDescriptionUpdate">
								<input type="text" class="form-control" aria-describedby="basic-addon1"></td>
								<td id="studentGradeUpdate">
									<input type="text" class="form-control" aria-describedby="basic-addon1"></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
