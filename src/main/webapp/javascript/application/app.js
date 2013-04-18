/******************************
 * SETUP
 ****************************v*/

//initiating TaskSystem-app
var TaskSystem = angular.module('TaskSystem', ['ngResource', 'ui.bootstrap'], function ($routeProvider) {
    $routeProvider
        .when('/', { controller:ListCtrl, templateUrl:'partials/list.html'})
        .when('/application/:id', {controller:ApplicationCtrl, templateUrl:'partials/application.html'})
        .otherwise({ redirectTo:'/'});
});

//initiating Wizard-app
var CustomerWizard = angular.module('CustomerWizard', ['ngResource'], function ($routeProvider) {
    $routeProvider
        .when('/', { controller:WizardCtrl, templateUrl:'wizard/partials/search.html'})
        .when('/step1/:query', {controller:SearchCtrl, templateUrl:'wizard/partials/select.html'})
        .when('/step2/:id', {controller:ReviewCtrl, templateUrl:'wizard/partials/review.html'})
        .otherwise({ redirectTo:'/'});
});

//Bootstrapping apps
angular.element(document).ready(function () {
    console.log("doc ready, bootstrapping Index-app and Wizard-app");
    angular.bootstrap(document.getElementById('tasksystem'), ['TaskSystem']);
    angular.bootstrap(document.getElementById('wizard'), ['CustomerWizard']);
});


/******************************
 * CONTROLLERS
 ****************************v*/

//Tasklist page controller
var ListCtrl = function ($scope, $http, $dialog) {
    $http({method:'GET', url:'/tasksystem/api/application'}).
        success(function (data, status, headers, config) {
            $scope.applications = data;

        }).
        error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

    $scope.opts = {
        backdrop:true,
        keyboard:true,
        backdropClick:true,
        templateUrl:'wizard/partials/search.html',
        controller:'ListCtrl'
    };

    $scope.openDialog = function () {
        /*
        var d = $dialog.dialog($scope.opts);
        d.open()
            .then(function (result) {
                if (result) {
                    alert('dialog closed with result: ' + result);
                }
            });
            */

        jQuery("#wizard").dialog().openDialog();
    };
};


//Application page controller
var ApplicationCtrl = function ($scope, $http, $location, $routeParams) {
    var appId = $routeParams.id;

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
        $http.post('/tasksystem/api/application/' + appId, myData);
    };

    $http({method:'GET', url:'/tasksystem/api/application/' + appId }).
        success(function (data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available
            $scope.app = data;

        }).
        error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

    $scope.partybooks = [
        {name:'Det norske Arbeiderpartiet (AP)', value:'AP'},
        {name:'Høyre (H :-)', value:'H'},
        {name:'Sosial Marxistisk Venstreparti (SV)', value:'SV'},
        {name:'Mot alt partiet (R)', value:'RØDT'},
        {name:'Hipsterpartiet (V)', value:'V'},
        {name:'Mot-alt-som-Rødt-er-for-partiet (FRP)', value:'FRP'},
        {name:'Nasjonalistisk venstreparti (SP)', value:'SP'},
        {name:'Det religiøse minoritetsparti (KRF)', value:'KRF'}
    ];


};


//WIZ-Search page controller
var SearchCtrl = function ($scope, $http, $location, $routeParams, CustomerQuery) {
    console.log("searching for " + $routeParams.query);
    $http({method:'GET', url:'/tasksystem/api/customer/' + $routeParams.query}).
        success(function (data, status, headers, config) {
            console.log('status: ' + status);
            if (status == 204) {
                $scope.customers = [
                    {realLastName:'no data'}
                ];
            } else {
                console.log('status: ' + status);
                $scope.customers = data;
                CustomerQuery.setQuery($routeParams.query);
                CustomerQuery.setCustomers(data);
            }
        }).
        error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

};

//WIZ-Review page controller
var ReviewCtrl = function ($scope, $http, $location, $routeParams, CustomerQuery) {
    console.log("Reviewing customer with ID=" + $routeParams.id);
    console.dir(CustomerQuery.getCustomers()[$routeParams.id]);

    $scope.customer = CustomerQuery.getCustomers()[$routeParams.id];

    $scope.doAction = function () {
        console.log('The customer');
        console.dir($scope.customer);

        var applicant = {
            name:$scope.customer.realFistName + ' ' + $scope.customer.realLastName,
            email:$scope.customer.email,
            accountNumber:$scope.customer.accountNumber
        };
        console.log('Saving applicant');
        console.dir(applicant);

        $http.put('/tasksystem/api/application', applicant);

    }
};

//WIZ-index page controller
var WizardCtrl = function ($scope, $http, $location, $routeParams, CustomerQuery) {

};


/******************************
 * FACTORY's
 ****************************v*/
//Customer query factory
CustomerWizard.factory('CustomerQuery', function ($rootScope) {
    var model = {
        query:'',
        customers:[]
    };

    return {
        setQuery:function (query) {
            model.query = query;
        },
        setCustomers:function (customers) {
            model.customers = customers;
        },
        getQuery:function () {
            return model.query;
        },
        getCustomers:function () {
            return model.customers;
        }
    };
});




