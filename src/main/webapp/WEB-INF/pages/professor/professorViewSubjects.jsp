<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
<h4 class="bg-info" style ="color:#336666;">Choose subject</h4>
<ul class="nav nav-pills">
	<c:forEach items="${subjects}" var="subject">
		<li>
			<a class="subject-selection" href="#">${subject.title}</a>
		</li>
	</c:forEach>
</ul>
