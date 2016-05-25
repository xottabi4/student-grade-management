<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>choose group</p>
<ul class="nav nav-pills">
	<c:forEach items="${tasks}" var="task">
		<li>
			<a id="task-selection" href="#">${task.title}</a>
		</li>
	</c:forEach>
</ul>
