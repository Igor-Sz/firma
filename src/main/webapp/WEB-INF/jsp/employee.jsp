<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/contr.js"></script>
    <title>Pracownicy</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Firma</h1>
            <p>Pracownik</p>
        </div>
    </div>
</section>
<section class="container" ng-app="empApp" >
    <div ng-controller="empCtrl" ng-init="pullEmployees()">
        <table class="table table-hover">
            <form:form modelAttribute="newEmp" class="form-horizontal">
                <fieldset><div class="form-group">
                <label class="control-label col-lg-2">Filtr</label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="name" />Imie
                    <form:radiobutton path="condition" value="surname" />Nazwisko
                    <form:radiobutton path="condition" value="email"/>Email
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2">
                   Wartość
                </label>
                <div class="col-lg-10">
                    <form:input id="value" path="value" type="text" class="form:input-large"/>
                </div>
            </div>
                </fieldset>
            </form:form>

            <tr>
                <th>Nazwisko</th>
                <th>Imię</th>
                <th>Email</th>
                <th>Stanowisko</th>
                <th>Akcja</th>
            </tr>
            <tr ng-repeat="employee">
                <td>{{employee.surname}}</td>
                <td>{{employee.name}}</td>
                <td>{{employee.email}}</td>
                <td>{{employee.position}}</td>
                <td><a href="#" class="label label-danger" ng-click="remove(emp.employeeID)">
                    <span class="glyphicon glyphicon-remove" /></span> Usuń
                </a></td>
            </tr>
        </table>
    </div>
</section>
</body>
</html>