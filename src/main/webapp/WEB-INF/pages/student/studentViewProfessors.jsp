<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>
<script src="<c:url value=" /resources/js/student/viewProfessors.js" />"></script>
<table id="view-professors"
	class="table table-responsive table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<th>Professor name</th>
			<th>Professor surname</th>
			<th>Subject</th>
			<th>Student Group</th>
		</tr>
		
	</thead>
	<tbody>
	<c:forEach items="${studentGroups}" var="studentGroup">
			<tr>

				<td> ${studentGroup.user.name}</td>
				<td>${ studentGroup.user.surname}</td>
				<td>${studentGroup.subject.title}</td>
				<td>${studentGroup.title}</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>