<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>

<html ng-app="Wizard">
<head>
    <title>Kundesøk</title>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular-resource.js"></script>
    <script type="text/javascript" src="http://documentcloud.github.com/underscore/underscore-min.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/wizard/app.js"></script>

    <link rel="stylesheet" href="/tasksystem/css/bootstrap.css">
    <link rel="stylesheet" href="/tasksystem/css/style.css">

</head>
<body>
<h1>Dette er en kundesøkewizard</h1>

<div id="container">

    <div ng-view></div>

</div>

</body>

</html>
