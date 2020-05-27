<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" isELIgnored="false"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/mytag.tld" %>
<%@ taglib prefix="tagfile" tagdir="/WEB-INF/tags" %>
    

<%@ include file="header.jsp" %>
<%!
int count = 0;
boolean hello = false;

String getMessage() {
	return "Hello From getMessage()";
}
void getException() throws Exception{
	throw new Exception("Test Exception");
}

%>
<%
String name = "saini";
%>

	<h1>Welcome File</h1>
	<%-- This is comment --%>
	Page Count <%= ++count %>
	<% out.println(getMessage()); %>
	<form action="welcome.jsp" method="POST">
		Name <input type="text" name="user" >
    <input type="submit" value="Submit">
		
	</form>
	
	<%

    if ( hello ) {
        %>
        <p>Hello, world</p>
        <%
    } else {
        %>
        <p>Goodbye, world</p>
        <%
    }
%>
<p> <%= (2+5) %></p>

  <%
   try{
      int i = 100;
      i = i / 0;
      out.println("The answer is " + i);
   }
   catch (Exception e){
      out.println("An exception occurred: " + e.getMessage());
   }
  %>
 <%--  <jsp:forward page="welcome.jsp"></jsp:forward> --%>
 <jsp:useBean id="student" class="com.javatraining.advancejava.dto.Student" scope="page">
 	<jsp:setProperty name="student" property="name"  value="Saini" />
 	<jsp:setProperty name="student" property="school" value="Besant"/>
 </jsp:useBean> >
 
 <p><jsp:getProperty property="name" name="student"/></p>
 <p><jsp:getProperty property="school" name="student"/></p>
 <mytag:countmatches inputString="test1" lookupString="test1"></mytag:countmatches>
 <mytag:countmatches inputString="test1" lookupString="test123"></mytag:countmatches>
 <tagfile:customtags></tagfile:customtags>
	
<%@ include file="footer.jsp" %>