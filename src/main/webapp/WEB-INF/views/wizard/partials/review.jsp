<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="container">
    Navn: {{customer.realFistName}} {{customer.realLastName}}<br/>
    Adresse: {{customer.street}} {{customer.zipCode}}, {{customers.area}}<br/>
    E-post: <input ng-model="customer.email"/><br/>
    Kontonummer: <input ng-model="customer.accountNumber"/><br/>
    <a class="btn" ng-click="doAction()">Ferdig</a>
</div>


