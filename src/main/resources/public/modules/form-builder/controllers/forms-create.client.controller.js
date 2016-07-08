'use strict';

// Create Form controller
angular.module('form-builder').controller('CreateFormController', ['$scope', '$stateParams', '$location', 'Authentication', 'GuidGen', 'notify', 'FormBuilder', 
	function($scope, $stateParams, $location, Authentication, GuidGen, notify, FormBuilder) {
		$scope.authentication = Authentication;

	    $scope.findOne = function(){
	    	FormBuilder.api.get({
				formId: $stateParams.formId
			}).$promise.then(function(form){
				$scope.form = form;
			});
	    };
}]);
