<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>

<html ng-app="Wizard">

<head>
    <title>TITS</title>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular.js"></script>
        <script type="text/javascript" src="/tasksystem/javascript/angular/angular-resource.js"></script>
        <script type="text/javascript" src="http://documentcloud.github.com/underscore/underscore-min.js"></script>
        <script type="text/javascript" src="/tasksystem/javascript/wizard/app.js"></script>

        <link rel="stylesheet" href="/tasksystem/css/bootstrap.css">
        <link rel="stylesheet" href="/tasksystem/css/style.css">

    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
    </style>

</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a href="/tasksystem/index.html" class="brand">The Incredible Task System|TITS</a>

            <div class="nav-collapse collapse">
                <form class="navbar-form pull-right">
                    <input class="span2" type="text" placeholder="Email">
                    <input class="span2" type="password" placeholder="Password">
                    <button type="submit" class="btn">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="wrap">
    <div id="container">
        <div ng-view></div>
    </div>
</div>

<div id="footer">
    <div class="container">
        <p>&copy; Akhbar Ltd 2013</p>
    </div>
</div>

<script type="text/javascript" src="/tasksystem/javascript/angular/ui/ui-bootstrap-0.2.0.min.js"></script>
<script type="text/javascript" src="http://documentcloud.github.com/underscore/underscore-min.js"></script>
<script type="text/javascript" src="/tasksystem/javascript/application/app.js"></script>

</body>
</html>
