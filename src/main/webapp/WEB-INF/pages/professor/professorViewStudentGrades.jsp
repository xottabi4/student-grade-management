<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
	<script src="<c:url value=" /resources/js/professor/viewGrades.js" />"></script>
	<table id="view-student-grades" class="table table-responsive table-bordered table-hover table-condensed">
		<thead>
			<tr>
				<th>Matricula</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Title</th>
				<th>Description</th>
				<th>Grade</th>
				<th>Date</th>
				<th>Edit records</th>
				<th>Delete records</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${studentGrades}" var="studentGrade">
				<tr>
					<td>
						${studentGrade.student.id}</td>
					<td>${studentGrade.student.name}</td>
					<td>${studentGrade.student.surname}</td>
					<td>${studentGrade.title}</td>
					<td>${studentGrade.description}</td>
					<td>${studentGrade.grade}</td>
					<td>${studentGrade.date}</td>
					<td>
						<a id="${studentGrade.id}" class="updateBtn" style="text-decoration:none; color:white; background-color:#3366FF; padding:7px; border-radius: 28px;" role="button">Update</a>
					</td>
					<td>
						<a href="#" id="${studentGrade.id}" class="deleteBtn" style="text-decoration:none; color:white; background-color:#3366FF; padding:7px; border-radius: 28px;" role="button">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
