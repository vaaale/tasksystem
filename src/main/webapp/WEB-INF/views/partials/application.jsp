<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="container">

    <div class="hero-unit">

        <h3>Søknadsdsskjema</h3>

        <form ng-submit="updateApplication()">
            <div class="row">
                <div class="span4"><b>AppId: {{app.id}}<br/></b></div>
            </div>
            <div class="row">
                <div class="span2">Name:<br/></div>
                <div class="span4">{{app.name}}</div>
            </div>
            <div class="row">
                <div class="span2">Email:<br/></div>
                <div class="span4">{{app.email}}</div>
            </div>
            <div class="row">
                <div class="span2">Desc:</div>
            </div>
            <div class="row">
                <div class="span4">
                    <textarea class="input-xxlarge" rows="10" ng-model="app.description"></textarea><br/>
                </div>
            </div>
            <div class="row">
                <div class="span2">
                    Partibok:
                </div>
            </div>
            <div class="row">
                <div class="span2">
                    <select ng-model="app.memberships" ng-options="obj.value as obj.name for obj in partybooks"></select><br>
                </div>
            </div>

            <button type="submit" class="btn btn-primary"><i class="icon-upload icon-white"></i> Lagre</button>
        </form>
    </div>

</div>

