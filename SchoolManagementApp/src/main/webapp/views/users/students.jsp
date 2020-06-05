<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 06/04/2020
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<jsp:include page="../layouts/headers.jsp"></jsp:include>

<div ng-controller="users-controller" ng-init="init_students()">

    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Role</th>
                        <th scope="col">Gender</th>
                    </tr>
                    </thead>
                    <tbody >
                    <tr ng-repeat="student in model.students">
                        <th scope="row">{{student.id}}</th>
                        <td>{{student.name}}</td>
                        <td>{{student.role}}</td>
                        <td>{{student.gender}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>

<jsp:include page="../layouts/footers.jsp"></jsp:include>