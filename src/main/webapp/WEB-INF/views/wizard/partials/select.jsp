<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="container">

    <div class="hero-unit">

        <table class="table table-striped table-hover table-condensed">
            <thead>
            <tr>
                <td>Id</td>
                <td>Navn</td>
                <td>Adresse</td>
                <td>&nbsp;</td>
            </tr>
            </thead>
            <tbody ng-repeat="customer in customers">
            <tr>
                <td>
                    {{customer.id}}
                </td>

                <td>
                    {{customer.realFistName}} {{customer.realLastName}}
                </td>

                <td>
                    {{customer.street}} {{customer.zipCode}}, {{customers.area}}
                </td>

                <td>
                    <a class="btn btn-primary" ng-href="#/step2/{{customer.id}}"><i class="icon-ok icon-white"></i> Velg</a>
                </td>

            </tr>
            </tbody>
        </table>

    </div>

</div>

