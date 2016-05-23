<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>choose subject</p>
<ul class="nav nav-pills">
	<c:forEach items="${subjects}" var="subject">
		<li><a class="subject-selection" href="/professor/createGroup/viewGroups">${subject.title}
		</a></li>
	</c:forEach>
</ul>