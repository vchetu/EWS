var app = angular.module('emcEWS', ['ui.bootstrap', 'ngRoute', 'ngCookies', 'ngResource', 'ngSanitize']);

app.run(function($rootScope) {
    /*
        Receive emitted message and broadcast it.
        Event names must be distinct or browser will blow up!
    */
    $rootScope.$on('handleAddEmployee', function(event, args) {
        $rootScope.$broadcast('handleAddEmployeeEWS', args);
    });
	
	$rootScope.$on('handleUpdateEmployee', function(event, args) {
        $rootScope.$broadcast('handleUpdateEmployeeEWS', args);
    });
});

app.controller('EWScontroller', function($scope, $http) {
			
			var url = 'http://10.63.38.81:8080/EmployeeWorkSpace/rest/employee/';

			$scope.newEmployee = {};
			
			$scope.getEmployees = function(){
				$http.get(url)
				.success(function(data) {
						$scope.employees = data;
				})
				.error(function(data) {
					alert("Error loading employees");
				});
			};
			
			$scope.$on('handleAddEmployeeEWS', function(event, args) {
				$scope.newEmployee = args.newEmployee;
				$scope.addEmployee();
			});
			
			$scope.$on('handleUpdateEmployeeEWS', function(event, args) {
				$scope.newEmployee = args.editEmployee;
				$scope.updateEmployee();
			});
			
			$scope.addEmployee = function(){
				$http.post(url, $scope.newEmployee)
				.success(function(data) {
					$scope.newEmployee = {};
					$scope.getEmployees();
				})
				.error(function(data) {
					alert("Error in adding employee");
				})
			};
			
			$scope.deleteEmployee = function(employee){
				$http.delete(url + employee.employeeID)
				.success(function(data) {
					$scope.newEmployee = {};
					$scope.getEmployees();
					$scope.employee = {};
					$scope.isDisabled = true;
				})
				.error(function(data) {
					alert("Error in deleting employee");
				})
			};
			
			$scope.updateEmployee = function(){
				$http.put(url, $scope.newEmployee)
				.success(function(data) {
					$scope.newEmployee = {};
					$scope.getEmployees();
					$scope.employee = {};
					$scope.isDisabled = true;
				})
				.error(function(data) {
					alert("Error in updating employee");
				})
				
			};
			
			$scope.getEmployees();
			
});

app.controller('modalController', function($scope, $http, $modal) {
	$scope.isDisabled = true;
	$scope.addEmployeeDialog = function () {
				$scope.newEmployee = {};
				var modalInstance = $modal.open({
				templateUrl: 'myModalContent.html',
				controller: 'ModalInstanceCtrl',
				resolve: {
							newEmployee: function () {
							return $scope.newEmployee;
						}
				}
				
				})
	};
	
	$scope.setSelected = function(employee) {
		$scope.isDisabled = false;
		$scope.employee = employee;
	};
	
	
	$scope.updateEmployeeDialog = function(employee) {
		$scope.editEmployee = {};
		$scope.editEmployee.name = employee.name;
		$scope.editEmployee.employeeID = employee.employeeID;
				var modalInstance = $modal.open({
				templateUrl: 'updateEmployeeModal.html',
				controller: 'updateCtrl',
				resolve: {
							editEmployee: function () {
							return $scope.editEmployee;
						}
				}
				
				})
	};
			
});

app.controller('updateCtrl', function ($scope, $modalInstance, editEmployee) {

  $scope.editEmployee = editEmployee;

  $scope.ok = function () {
	$scope.$emit('handleUpdateEmployee', {editEmployee:$scope.editEmployee});
    $modalInstance.close($scope.editEmployee);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});

app.controller('ModalInstanceCtrl', function ($scope, $modalInstance, newEmployee) {

  $scope.newEmployee = newEmployee;

  $scope.ok = function () {
	$scope.$emit('handleAddEmployee', {newEmployee:$scope.newEmployee});
    $modalInstance.close($scope.newEmployee);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});
