<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>choose group</p>
<ul class="nav nav-pills">
	<c:forEach items="${groups}" var="group">
		<li>
			<a class="group-selection_id" href="#">${group.id} </a>
			<a class="group-selection" href="#"> ${group.title}</a>
			
		</li>
	</c:forEach>
</ul>
