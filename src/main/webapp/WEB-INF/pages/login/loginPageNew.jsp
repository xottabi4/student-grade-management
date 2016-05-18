<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Signin Template for Bootstrap</title>
<link rel='stylesheet'
	href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<c:if test="${param.error == 'true'}">
			<div style="color: red; margin: 10px 0px;">

				Login Failed!!!<br /> Reason :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

			</div>
		</c:if>
		<form class="form-signin"
			action="${pageContext.request.contextPath}/j_spring_security_check"
			method='POST'>
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputUsername" class="sr-only">Username</label> <input
				name='username' type="username" id="inputUsername"
				class="form-control" placeholder="Username" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label> <input
				name='password' type="password" id="inputPassword"
				class="form-control" placeholder="Password" required>
			<!-- <div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>


</body>
</html>
