<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/11/2020
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h1>Add Employee</h1>
<hr>
<form:form method="post" action="${pageContext.request.contextPath}/employees/save" modelAttribute="employee">
    <form:label path="name">Name</form:label>
    <form:input path="name"/>
    <form:label path="salary">Salary</form:label>
    <form:input path="salary"/>
    <form:button name="submit">Save</form:button>
</form:form>
</body>
</html>
