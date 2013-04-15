<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>

<html ng-app="Tasksystem">
<head>
    <title>Tasksystem</title>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular-resource.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/angular/ui/ui-bootstrap-0.2.0.min.js"></script>
    <script type="text/javascript" src="http://documentcloud.github.com/underscore/underscore-min.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/application/app.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<h1>This is index.jsp</h1>

<div id="container">

    <div ng-view></div>

</div>

</body>

</html>
