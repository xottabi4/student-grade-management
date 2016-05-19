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
	<form action="/student/subjects">
		<input type="submit" value="All subjects">
	</form>
	
	
	<h1>Reading Checkbox Data</h1>
<ul>
<li><p><b>Maths Flag:</b>
   <%= request.getParameter("${info.id}")%>
</p></li>

</ul>
	
</body>
</html>