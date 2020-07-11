<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/10/2020
  Time: 03:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Employee Detail</title>
</head>
<body>
<h1><c:out value="${employee.name}"/></h1>
<hr>
<p><c:out value="${employee.salary}"/></p>
<p><c:out value="${employee.id}"/></p>
</body>
</html>
