<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/09/2020
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/mytag.tld" %>
<%@ taglib prefix="tagfile" tagdir="/WEB-INF/tags/" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<p>
    <%
        out.println(request.getParameter("name"));
    %>
   ${param.get("name")}

    <jsp:useBean id="personBean"  class="com.vinaylogics.learnadvancejava.jsp.dto.Person" scope="session">

    </jsp:useBean>
    <%=personBean%>

    <mytag:count_matches inputString="sonal" lookupString="sonal"/>
    <mytag:count_matches inputString="sonal" lookupString="sarkar"/>

    <tagfile:customtags />

</p>
<p>
</p>
</body>
</html>
