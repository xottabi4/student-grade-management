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

</body>
</html>