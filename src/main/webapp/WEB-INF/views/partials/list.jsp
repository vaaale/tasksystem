<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<div class="container">

    <div class="hero-unit">

        <h3>Søkere</h3>

        <table class="table table-striped table-hover table-condensed">
            <thead>
            <tr>
                <td>Navn</td>
                <td>Status</td>
            </tr>
            </thead>
            <tbody ng-repeat="app in applications">
            <tr>
                <td>
                    {{app.name}}
                </td>
                <td>
                    <a ng-href="/tasksystem/#/application/{{app.id}}">{{app.state}}</a>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2" style="padding-left:0; padding-top:10px;margin: 0">
                    <a class="btn" ng-href="/tasksystem/wizard/wizard.html">Ny søknad</a>
                    <a class="btn btn-primary" ng-click="openDialog()">Dialog</a>
                </td>
            </tr>
            </tfoot>
        </table>

    </div>

</div>

