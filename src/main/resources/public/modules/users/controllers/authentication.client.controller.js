'use strict';

angular.module('users').controller('AuthenticationController', ['$rootScope', '$scope', '$state', '$http', '$location', 'Authentication',
	function($rootScope, $scope, $state, $http, $location, Authentication) {
		$scope.authentication = Authentication;

		// If user is signed in then redirect back home
		if ($scope.authentication.user && $scope.authentication.user.authenticated) $location.path('/');
		
		$scope.credentials = {};

		$scope.signup = function() {
			$http.post('rest/users/signup', $scope.credentials).success(function(response) {
				// If successful we assign the response to the global user model
				$scope.authentication.authenticate(response);

				// And redirect to the index page
				$location.path('/');
			}).error(function(response) {
				$scope.error = response.message;
			});
		};

		$scope.signin = function() {
			$http({
				method: 'POST',
			    url: 'authenticate',
			    data: $.param($scope.credentials),
			    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function(response) {
				// If successful we assign the response to the global user model
				$scope.authentication.authenticate(response);
				var targetState = $rootScope.returnToState || 'home';
				var targetStateParams = $rootScope.returnToStateParams;
				$state.go(targetState, targetStateParams);
			}).error(function(response) {
				$scope.error = response.message;
			});
		};
	}
]);