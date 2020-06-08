<%--
  Created by IntelliJ IDEA.
  User: vinay
  Date: 06/05/2020
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../layouts/headers.jsp"></jsp:include>

<div ng-controller="users-controller" ng-init="init_add_students()">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form>
                    <div class="form-group">
                        <label for="name">Example file input</label>
                        <input type="text" class="form-control-file" id="name" ng-model="model.student.name">
                    </div>
                    <div class="form-group">
                        <label for="gender">Example file input</label>
                        <select class="form-control form-control-lg"
                                ng-options="gender.value for gender in model.genders track by gender.key"
                                id="gender" ng-model="model.selected">

                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary" ng-click="saveStudent($event)">Save</button>
                </form>
            </div>
        </div>
    </div>

</div>

<jsp:include page="../layouts/footers.jsp"></jsp:include>
