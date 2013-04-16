<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="modal-header">
    <h1>Søk person</h1>
</div>
<div class="modal-body">
    <input ng-model="wizard.query" placeholder="Finn person">
    <a class="btn btn-primary" ng-href="#/step1/{{wizard.query}}"><i class="icon-search icon-white"></i> Søk</a>

    <%--          <p>Enter a value to pass to <code>close</code> as the result: <input ng-model="result" /></p>--%>
</div>
<div class="modal-footer">
    <button ng-click="dialog.close(result);" class="btn btn-primary">Close</button>
</div>