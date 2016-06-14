'use strict';

angular.module('users').controller('ProfileController', ['$scope', '$stateParams', '$location', 'Authentication', 'Users', 'Trees', 
	function($scope, $stateParams, $location, Authentication, Users, Trees) {
		$scope.authentication = Authentication;

		// Find existing item
		$scope.findOne = function() {
			Users.getProfile({
				userId: $stateParams.userId
			}).$promise.then(function(user){
				$scope.user = user;
			});
			Trees.queryByUsername({
				username: $stateParams.userId
			}).$promise.then(function(trees){
				console.log(trees);
				$scope.trees = trees;
			})
			
		};
	}
]);