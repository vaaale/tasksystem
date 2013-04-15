<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row akhbar" ng-repeat="customer in customers">
        <div class="span2">{{customer.id}}</div>
        <div class="span2">{{customer.realFistName}} {{customer.realLastName}}</div>
        <div class="span2">{{customer.street}} {{customer.zipCode}}, {{customers.area}}</div>
        <a class="btn" ng-href="#/step2/{{customer.id}}">Velg</a>
    </div>

</div>

