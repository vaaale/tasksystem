var TaskSystem = angular.module("Tasksystem", []);

function TodoCtrl($scope) {
    $scope.todos = [
        {text:"Learn angular", done:false},
        {text:"Make tasksystem remote enabled", done:false}
    ];

    $scope.getTotalTodos = function() {
        return $scope.todos.length;
    };

    $scope.addTodo = function() {
        $scope.todos.push({text:$scope.formTodo.text, done:false})
        $scope.formTodo.text = '';
    };

    $scope.clearCompleted = function() {
        $scope.todos = _.filter($scope.todos, function(todo) {
            return !todo.done;
        })
    }
}