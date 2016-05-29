<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head> 


		<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1">
					<meta name="description" content="">
						<meta name="author" content="">
							<title>SGM professor create group</title>

							<link href="<c:url value=" /resources/css/pageLayout.css" />" rel="stylesheet">
								<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/u/bs/jqc-1.12.3,dt-1.10.12/datatables.min.css"/>
								<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
									<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css">
										<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
										<script type="text/javascript" src="https://cdn.datatables.net/u/bs/jqc-1.12.3,dt-1.10.12/datatables.min.js"></script>
										<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
										<script src="<c:url value=" /resources/js/mainPageScrips.js" />"></script>
										<script src="<c:url value=" /resources/js/professor/addGrades.js" />"></script>


</head>

<table id="view-student-grades" class="table table-responsive table-bordered table-hover table-condensed">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
             <th>Grade</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${grades}" var="grade">
            <tr>
                <td>${grade.student.id}</td>
                  <td>${grade.student.name}</td>
                   <td>${grade.student.surname}</td>
                <td>${grade.grade}</td>
                
            </tr>
        </c:forEach> 
    </tbody>
</table>
