'use strict';


// Trees controller
angular.module('organizations').controller('OrganizationsController', ['$scope', '$stateParams', '$location', 'Authentication', 'Organizations', 'notify',
	function($scope, $stateParams, $location, Authentication, Organizations, notify) {
		$scope.authentication = Authentication;

		// Create new organization
		$scope.create = function() {
			// Create new Tree object
			var organization = new Organizations ({
				name: this.name
			});

			// Redirect after save
			organization.$save(function(response) {
				$location.path('organizations/' + response.id + '/edit');
				// Clear form fields
				$scope.name = '';
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		// Remove existing Item
		$scope.remove = function(organization) {
			if ( organization ) {
				organization.$remove();

				for (var i in $scope.organizations) {
					if ($scope.organizations [i] === organization) {
						$scope.organizations.splice(i, 1);
					}
				}
			} else {
				$scope.organization.$remove(function() {
					$location.path('organizations');
				});
			}
		};

		// Update existing item
		$scope.update = function() {
			var organization = $scope.organization;
			organization.$update(function() {
				$location.path('organizations/' + organization.id);
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		// Find a list of items
		$scope.find = function() {
			$scope.organizations = Organizations.query();
		};

		// Find existing item
		$scope.findOne = function() {
			Organizations.get({
				organizationId: $stateParams.organizationId
			}).$promise.then(function(organization){
				$scope.organization = organization;
			});
		};
		
		$scope.addMember = function(){
			Organizations.addMember({
				emailAddress: $scope.newMemberEmailAddress,
				organizationId: $stateParams.organizationId,
				permission: 'ADMIN'
			}).$promise.then(function(result){
				$scope.organization = result.value;
				$scope.newMemberEmailAddress = null;
				notify({
					message: result.message,
					duration: '5000',
					position: 'right',
					classes: ['success']
				});
			}, function failure(err){
				notify({
					message: result,
					duration: '5000',
					position: 'right',
					classes: ['danger']
				});
			});
		}
	}
]);