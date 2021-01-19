<%@ page import="com.vinaylogics.learnadvancejava.jsp.dto.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 07/09/2020
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/mytag.tld" %>
<%@ taglib prefix="tagfile" tagdir="/WEB-INF/tags/" %>
<html>
<head>
    <title>Basic JSP page</title>
</head>
<%
    int count = 0;
    Person person = new Person();
    person.setFirstName("Sonal");
    person.setLastName("Sarkar");
%>
<body>
<%@ include file="layout/first_include.jsp"%>
<%--<jsp:include page="/first_include"/>--%>
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

    void getException() throws Exception {
        throw  new Exception("Purpose full Exception");
    }
%>
<% try { %>
<%
    out.println(getMessage()+"<br/>");
    out.println(person.getFirstName()+"<br/>");
    out.println(person.getLastName()+"<br/>");
    getException();
%>
<p>Here Exception Handling</p>
<%
} catch (Exception e){
    e.printStackTrace();
}
%>
<ul>

<%
    for (int i = 0; i < 10; i++) {
%>
   <li>
       <%
           out.println(i);
       %>
       <%=i%>
   </li>
<%
    }
%>
</ul>

<p>
    <%=person%>
</p>
<p>
    <%=(2*5)%>
</p>
<c:forEach var="data" begin="0" end="10">
    <c:out value="${data}"/>
    <br/>
</c:forEach>
<c:if test="${10 % 2 == 0}">
    <c:out value="Even Number"/>
</c:if>
<c:catch var="catchException">
    <%getException();%>
</c:catch>
<c:if test="${catchException != null}">
    <c:out value="${catchException.message}"/>
</c:if>
<jsp:useBean id="personBean"  class="com.vinaylogics.learnadvancejava.jsp.dto.Person" scope="session">

</jsp:useBean>

<jsp:setProperty name="personBean" property="firstName" value="TestFirst"/>
<jsp:setProperty name="personBean" property="lastName" value="TestLast"/>

<p><jsp:getProperty name="personBean" property="firstName"/></p>
<p><jsp:getProperty name="personBean" property="lastName"/></p>

<p>${cookie}</p>
<p>${2 * 2}</p>
<p>${personBean}</p>
<%--<jsp:forward page="/forward"/>--%>
<mytag:count_matches inputString="test1" lookupString="test1"/>
<mytag:count_matches inputString="test1" lookupString="test123"/>

<tagfile:customtags />

<%@ include file="layout/second_include.jsp"%>

</body>
</html>
