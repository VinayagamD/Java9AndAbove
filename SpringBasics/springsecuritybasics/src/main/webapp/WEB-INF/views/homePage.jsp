<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/16/2020
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spring Login Success</title>
</head>
<body>
    <h1>Welcome to spring security demo</h1>
    <h4> You Have learn about spring form login</h4>
    <c:url value="/logout" var="logoutUrl" />
    <form id="logout" action="${logoutUrl}" method="post" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>
</body>
</html>
