'use strict';


angular.module('search').controller('SearchController', ['$scope', '$state', '$stateParams', 'Authentication', 'Trees', 
	function($scope, $state, $stateParams, Authentication, Trees) {
		// This provides Authentication context.
		$scope.authentication = Authentication;
		$scope.query = $stateParams.query;
		
		if($scope.query){
			Trees.search({query: $scope.query}).$promise.then(
					function(searchResult){
						$scope.trees = searchResult.content;
					});
		}
		
		$scope.search = function(){
			if($scope.query){
				$state.go('search', {query: $scope.query});
			}
		}
	}
]);