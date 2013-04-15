<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="container">

    <div class="hero-unit">

        <h3>Personsøk</h3>

            <input ng-model="wizard.query" placeholder="Finn person"> <a class="btn btn-primary" ng-href="#/step1/{{wizard.query}}"><i class="icon-search icon-white"></i> Søk</a>

    </div>

</div>


