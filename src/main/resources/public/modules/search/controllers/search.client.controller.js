'use strict';


angular.module('search').controller('SearchController', ['$scope', 'Authentication', 'Trees', 
	function($scope, Authentication, Trees) {
		// This provides Authentication context.
		$scope.authentication = Authentication;
		
		$scope.search = function(){
			if($scope.query){
				Trees.search({query: $scope.query}).$promise.then(
						function(searchResult){
							$scope.trees = searchResult.content;
						});
			}
		}
	}
]);