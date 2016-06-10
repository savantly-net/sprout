'use strict';

angular.module('users').controller('ProfileController', ['$scope', '$stateParams', '$location', 'Authentication', 'Users',
	function($scope, $stateParams, $location, Authentication, Users) {
		$scope.authentication = Authentication;

		// Find existing item
		$scope.findOne = function() {
			Users.get({
				userId: $stateParams.userId
			}).$promise.then(function(user){
				$scope.user = user;
			});
		};
	}
]);