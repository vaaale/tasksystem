<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<h1>This is list.jsp</h1>

<div class="container">

    <div class="row-fluid akhbar">
        <div class="span4">Søker</div>
        <div class="span2">Status</div>
    </div>

    <div class="row-fluid akhbar" ng-repeat="app in applications">
        <div class="span4">{{app.name}}</div>
        <div class="span2"><a ng-href="/tasksystem/#/application/{{app.id}}">{{app.state}}</a></div>
    </div>

    <div class="row">
        <a class="btn" ng-href="/tasksystem/wizard/wizard.html">Ny søknad</a>
        <a class="btn btn-primary" ng-click="openDialog()">Dialog</a>
    </div>


</div>
