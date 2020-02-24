<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Departments-Page</title>
</head>
<body>

<h3> Departments List</h3>
<div>
<table>
    <tr>
    <th>Department Name</th>
    <th>Manager</th>
    </tr>
    <c:forEach var="dept" items="${departments}">
    	<tr>
    			<td>${dept.deptName} </td>
    			<td> ${dept.manager}</td>
    	</tr>
    </c:forEach>
</table>
</div>

</body>
</html>