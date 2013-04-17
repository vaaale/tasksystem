<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="modal-header">
    <h1>Søk person</h1>
</div>

<div class="modal-body">
    <input ng-model="wizard.query" placeholder="Finn person">
    <a class="btn btn-primary" ng-href="#/step1/{{wizard.query}}"><i class="icon-search icon-white"></i> Søk</a>
</div>

<div class="modal-footer"></div>