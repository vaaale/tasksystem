<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h1>This is application.jsp</h1>

    <div class="container">
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
            <input class="btn-primary" type="submit" value="Lagre">
        </form>
    </div>

</div>

