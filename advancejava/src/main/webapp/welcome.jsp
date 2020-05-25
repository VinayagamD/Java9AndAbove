<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
	%>
	
	Hello, <%out.println(user); %>
	
	<table border = 1>
<%
    for ( int i = 0; i < 10; i++ ) {
        %>
        <tr>
        <td>Number</td>
        <td><%= i+1 %></td>
        </tr>
        <%
    }
%>


<p> Student Name ${param.user}</p>
</table>
	
</body>
</html>