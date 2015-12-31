'use strict';


// Trees controller
angular.module('users').controller('UserAdminController', ['$scope', '$stateParams', '$location', 'Authentication', 'Users',
	function($scope, $stateParams, $location, Authentication, Users) {
		$scope.authentication = Authentication;

		// Create new object
		$scope.create = function() {
			// Create new object
			var user = new Users ({
				username: this.username,
				emailAddress: this.emailAddress,
				password: this.password
			});

			// Redirect after save
			user.$save(function(response) {
				// Clear form fields
				$scope.username = '';
				$scope.password = '';
				$location.path('users/admin/' + response.id + '/edit');
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		// Remove existing Item
		$scope.remove = function(user) {
			if ( user ) {
				user.$remove();

				for (var i in $scope.users) {
					if ($scope.users [i] === user) {
						$scope.users.splice(i, 1);
					}
				}
			} else {
				$scope.user.$remove(function() {
					$location.path('users');
				});
			}
		};

		// Update existing item
		$scope.update = function() {
			var user = $scope.user;
			user.$update(function() {
				$location.path('users/' + user.id);
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		// Find a list of items
		$scope.find = function() {
			$scope.users = Users.query();
		};

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