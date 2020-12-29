<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 12/25/2020
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello Message</title>
</head>
<body>

<h1>Message From Controller</h1>
<hr>
<p><c:out value="${hello.message}"/></p>

</body>
</html>
