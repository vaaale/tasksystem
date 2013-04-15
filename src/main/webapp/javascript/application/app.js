var TaskSystem = angular.module("Tasksystem", ["ngResource"]).
    config(function ($routeProvider) {
        $routeProvider.
            when('/', { controller:ListCtrl, templateUrl:'partials/list.html'}).
            when('/application/:id', {controller:ApplicationCtrl, templateUrl:'partials/application.html'}).
            otherwise({ redirectTo:'/'})
    });


var ListCtrl = function ($scope, $http) {
    $http({method:'GET', url:'/tasksystem/api/application'}).
        success(function (data, status, headers, config) {
            $scope.applications = data;

        }).
        error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });


};



var ApplicationCtrl = function ($scope, $http, $location, $routeParams) {
    var appId = $routeParams.id;

    console.log('AppId: ' + appId);

    var compileData = function () {
        return {
            id:$scope.app.id,
            name:$scope.app.name,
            email:$scope.app.email,
            accountNumber:'',
            description:$scope.app.description,
            memberships:$scope.app.memberships
        };
    };

    $scope.updateApplication = function () {
        var myData = compileData();
        console.log('MyData');
        console.dir(myData);

        console.log('Submitting application: ' + $scope.app.name);

        $http.post('/tasksystem/api/application/' + appId, myData);
    };

    $http({method:'GET', url:'/tasksystem/api/application/' + appId }).
        success(function (data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available
            console.log('The selected application: ');
            console.dir(data);
            $scope.app = data;

        }).
        error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

};
