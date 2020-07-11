<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/09/2020
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<table>
    <thead>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
    </thead>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td><c:out value="${employee.id}"/></td>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.salary}"/></td>
        </tr>
    </c:forEach>
    <tbody>
    <tr>
        <td></td>
    </tr>
    </tbody>

</table>

</body>
</html>
