<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
<h4 class="bg-info" style ="color:#336666;">Choose task</h4>
<ul class="nav nav-pills">
	<c:forEach items="${tasks}" var="task">
		<li id="${task.id}">
			<a class="task-selection" href="#">${task.title}</a>
		</li>
	</c:forEach>
</ul>
