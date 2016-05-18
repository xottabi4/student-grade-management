<%@page session="false"%>
<html>
<head>
<title>Access Denied</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/_menu.jsp" />

	<h3 style="color: red;">${message}</h3>
</body>
</html>