<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div>
    <h1>This is application.jsp</h1>

    <form ng-submit="updateApplication()">
        <h2>AppId: {{app.id}}</h2>
        Name :{{app.name}}<br/>
        Email:{{app.email}}<br/>
        Desc :<textarea class="input-xxlarge" rows="10" ng-model="app.description"></textarea><br/>
        Memb :<input ng-model="app.memberships"/><br/>
        <input class="btn-primary" type="submit" value="add">
    </form>

</div>

