<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>choose task</p>
<ul class="nav nav-pills">
	<c:forEach items="${tasks}" var="task">
		<li id="${task.id}">
			<a class="task-selection" href="#">${task.title}</a>
		</li>
	</c:forEach>
</ul>
