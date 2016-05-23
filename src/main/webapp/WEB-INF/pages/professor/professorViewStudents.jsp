<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-responsive table-striped table-bordered table-hover table-condensed">
    <thead>
        <tr>
            <th>#</th>
            <th>Firstname</th>
            <th>Lastname</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.surname}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
