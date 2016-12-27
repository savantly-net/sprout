'use strict';

angular.module('core').controller('HeaderController', ['$scope', '$http', '$window', 'Authentication', 'Menus',
	function($scope, $http, $window, Authentication, Menus) {
		$scope.authentication = Authentication;
		$scope.isCollapsed = false;
		$scope.menu = Menus.getMenu('topbar');

		$scope.toggleCollapsibleMenu = function() {
			$scope.isCollapsed = !$scope.isCollapsed;
		};

		// Collapsing the menu after navigation
		$scope.$on('$stateChangeSuccess', function() {
			$scope.isCollapsed = false;
		});
		
		$scope.logout = function(){
			$http({
				  method: 'POST',
				  url: '/logout'
				}).then(function successCallback(response) {
				    console.log(response);
				    $window.location.reload();
				  }, function errorCallback(response) {
					  console.log(response);
				  });
		};
	}
]);