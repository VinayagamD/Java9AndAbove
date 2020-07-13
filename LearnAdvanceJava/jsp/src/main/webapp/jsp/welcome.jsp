<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/09/2020
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<p>
    <%
        out.println(request.getParameter("name"));
    %>
</p>
<p>
</p>
</body>
</html>
