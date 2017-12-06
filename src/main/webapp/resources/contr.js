var empApp = angular.module('empApp', []);
empApp.controller('empCtrl', function ($scope, $http) {
    $scope.pullEmployees = function() {
        $http.get('/rest/employees').success(function(data) {
            $scope.employees = data;
        });
    };
    $scope.pullEmployee = function(empno) {
        $scope.empno = empno;
        $http.get('/rest/employee/'+$scope.empno).success(function(data) {
            $scope.employees = data;
        });
    };
    $scope.remove = function(empno) {
        $scope.empno = empno;
        $http.delete('/rest/remove/'+$scope.empno)
            .success($scope.pullEmployees());
    };
});