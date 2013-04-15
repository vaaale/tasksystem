<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="container">
    <h1>Søk kunde</h1>

    Søk:<input ng-model="wizard.query"/><br>
    <a class="btn" ng-href="#/step1/{{wizard.query}}">Søk</a>

</div>

