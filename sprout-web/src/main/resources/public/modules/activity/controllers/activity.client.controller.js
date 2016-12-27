'use strict';


// Trees controller
angular.module('activity').controller('ActivityController', ['$scope', '$stateParams', '$location', 'Authentication', 'Activity',
	function($scope, $stateParams, $location, Authentication, Activity) {
		$scope.authentication = Authentication;
		$scope.pageQuery = {
				options: {
					pageIndex: 1,
					size: 5
				}
		};

		// Find a list of Activity
		$scope.find = function() {
			Activity.api.page({
					page: $scope.pageQuery.options.pageIndex-1,
					size: $scope.pageQuery.options.size }, function(response){
				$scope.pageQuery.response = response;
				$scope.pageQuery.totalPages = response.totalPages;
				$scope.activities = response.content;
			});
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