<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/_menu.jsp" />

	<h1>Message : ${message}</h1>
	<br>
	<h2>Welcome : ${username}</h2>
	<br>
	<form action="/student/grades">
		<input type="submit" value="Check My Grades">
	</form>
</body>
</html>