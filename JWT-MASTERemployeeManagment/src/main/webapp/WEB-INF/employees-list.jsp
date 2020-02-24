<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List-of-Employees</title>
</head>
<body>
<br>

<h3>List of Employees and their Departments</h3>

<div>
<table>
    <tr>
    <th>Employee No   </th>
    <th>Full Name</th>
    <th> Department</th>
    </tr>
    <c:forEach var="emp" items="${employeesList}">
    	<tr>
    			<td>${emp.emp_no}    </td>
    			<td>    ${emp.firstName}  ${emp.lastName}</td>
    			<td>${emp.deptName} </td>
      	</tr>
    </c:forEach>
</table>
</div>



</body>
</html>