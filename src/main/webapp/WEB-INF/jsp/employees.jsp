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
            <p>Pracownicy</p>
        </div>
    </div>
</section>
<section class="container" ng-app="empApp" >
    <div ng-controller="empCtrl" ng-init="pullEmployees()">
        <table class="table table-hover">
            <tr>
                <th>Nazwisko</th>
                <th>Imię</th>
                <th>Email</th>
                <th>Stanowisko</th>
                <th>Akcja</th>
            </tr>
            <tr ng-repeat="emp in employees">
                <td>{{emp.surname}}</td>
                <td>{{emp.name}}</td>
                <td>{{emp.email}}</td>
                <td>{{emp.position}}</td>
                <td><a href="#" class="label label-danger" ng-click="remove(emp.employeeID)">
                    <span class="glyphicon glyphicon-remove" /></span> Usuń
                </a></td>
            </tr>
        </table>
    </div>
</section>
</body>
</html>