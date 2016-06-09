<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
<h4 class="bg-info" style="color: #336666;">Choose group</h4>
<ul class="nav nav-pills">
	<c:forEach items="${groups}" var="group">
		<li id="${group.id}"><a class="group-selection" href="#">${group.title}</a>
		</li>
	</c:forEach>
</ul>
