<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/09/2020
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic JSP page</title>
</head>
<%
    int count = 0;
%>
<body>
<%--This is a comment--%>
Page Count <% out.println(++count);%>
<form action="/displayviews/welcome" method="post">
    <label for="name">Name:</label>
    <input id="name" name="name" type="text">
    <button type="submit">Send</button>
</form>
<%!

    String getMessage(){
        return  "Hello Message";
    }
%>
<%
    out.println(getMessage());
%>
<ul>

<%
    for (int i = 0; i < 10; i++) {
%>
   <li>
       <%
           out.println(i);
       %>
   </li>
<%
    }
%>
</ul>
</body>
</html>
