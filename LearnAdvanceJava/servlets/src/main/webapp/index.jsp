<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/07/2020
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
    <form action="<%=application.getContextPath()%>/annotations" method="post" >
      <input type="text" name="name" placeholder="entername">
      <input type="password" name="password" placeholder="enterpassword">
      <button type="submit">Submit</button>
    </form>

  <form action="<%=application.getContextPath()%>/rewrite" method="get">
    <input type="name" name="uname" placeholder="Enter user name">
    <button type="submit">Submit</button>
  </form>
  </body>
</html>
