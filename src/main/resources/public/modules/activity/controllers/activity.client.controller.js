'use strict';


// Trees controller
angular.module('activity').controller('ActivityController', ['$scope', '$stateParams', '$location', 'Authentication', 'Activity',
	function($scope, $stateParams, $location, Authentication, Activity) {
		$scope.authentication = Authentication;

		// Find a list of Activity
		$scope.find = function() {
			$scope.activities = Activity.api.query();
		};

		// Find existing Activity
		$scope.findOne = function() {
			Activity.api.get({
				activityId: $stateParams.activityId
			}).$promise.then(function(activity){
				$scope.activity = activity;
			});
		};
		
		$scope.remove = function(activity) {
			if (activity) {
				activity.$remove();

				for (var i in $scope.activities) {
					if ($scope.activities [i] === activity) {
						$scope.activities.splice(i, 1);
					}
				}
				$location.path('/activity');
			} else {
				$scope.activity.$remove(function() {
					$location.path('/activity');
				});
			}
		};
	}
]);