<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 06/05/2020
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../layouts/headers.jsp"></jsp:include>

<div ng-controller="users-controller" ng-init="init_student(<%=request.getParameter("id")%>)">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="jumbotron">
                    <h1 class="display-4">{{model.student.name}}!</h1>
                    <p class="lead">{{model.student.role}}</p>
                    <hr class="my-4">
                    <p>{{model.student.userId}}</p>
                    <p>{{model.student.id}}</p>
                    <p>{{model.student.createdAt}}</p>
                    <p>{{model.student.gender}}</p>

                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../layouts/footers.jsp"></jsp:include>
