<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicant List</title>
<style>
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

	<table border="1">
		<tr>
			<th>Subjects</th>
			<th>Choose</th>
		</tr>
		<c:forEach items="${studentSubjects}" var="subjectInfo">
			<tr>
				<td>${subjectInfo.title}</td>
				<td>${subjectInfo.id}</td>

			</tr>

		</c:forEach>


	</table>

	<table border="1">
		<tr>
			<th>Tasks</th>
			<th>Choose</th>
		</tr>
		<c:forEach items="${studentTasks}" var="taskInfo">
			<tr>
				<td>${taskInfo.title}</td>
				<td>${taskInfo.id}</td>

			</tr>

		</c:forEach>


	</table>

</body>
</html>