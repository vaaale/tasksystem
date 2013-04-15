var CustomerWizard = angular.module("Wizard", ["ngResource"]).
    config(function ($routeProvider) {
        $routeProvider.
            when('/', { controller:WizardCtrl, templateUrl:'partials/search.html'}).
            when('/step1/:query', {controller:SearchCtrl, templateUrl:'partials/select.html'}).
            when('/step2/:id', {controller:ReviewCtrl, templateUrl:'partials/review.html'}).
            otherwise({ redirectTo:'/'})
    });


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

var SearchCtrl = function ($scope, $http, $location, $routeParams, CustomerQuery) {
    console.log("searching for " + $routeParams.query);
    $http({method:'GET', url:'/tasksystem/api/customer/' + $routeParams.query}).
        success(function (data, status, headers, config) {
            if (status == 204) {
                $scope.customers = [{realLastName:'no data'}];
            } else {
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

var WizardCtrl = function ($scope, $http, $location, $routeParams, CustomerQuery) {
};

