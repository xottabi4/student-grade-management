<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

	<a href="${pageContext.request.contextPath}/login">Home</a> | &nbsp;

	<a href="${pageContext.request.contextPath}/professor">Professor</a> |
	&nbsp; <a href="${pageContext.request.contextPath}/student">Student</a>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
  
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>

	</c:if>

</div>