<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>choose group</p>
<ul class="nav nav-pills">
	<c:forEach items="${groups}" var="group">
		<li>
			<a id="group-selection" href="#">${group.title}</a>
		</li>
	</c:forEach>
</ul>
