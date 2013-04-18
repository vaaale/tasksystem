<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>


<html>
<head>
    <title>TITS</title>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/angular/angular-resource.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/angular/ui/ui-bootstrap-0.2.0.min.js"></script>
    <script type="text/javascript" src="/tasksystem/javascript/application/app.js"></script>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/themes/base/jquery-ui.css" type="text/css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>


    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
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

<div id="tasksystem" class="container">
    <div ng-view></div>
</div>

<div id="footer">
    <div class="container">
        <p>&copy; Akhbar Ltd 2013</p>
    </div>
</div>

<div id="alex">
    <h1>Dette er ALEX!</h1>
</div>

<div id="wizard" style="border: 1px solid red; display: none">
    <h1>wizard-div</h1>

    <div class="container">
        <div ng-view></div>
    </div>
</div>

</body>
</html>
