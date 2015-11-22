'use strict';

// Create Form controller
angular.module('form-builder').controller(
		'ViewFormController',
		[ '$scope', '$stateParams', 'Authentication', 'FormBuilder',
				function($scope, $stateParams, Authentication, FormBuilder) {
					$scope.authentication = Authentication;
					$scope.form = {};
					
					// Find existing form for id
					$scope.findOne = function() {
						FormBuilder.api.get({
							formId: $stateParams.formId
						}).$promise.then(function(form){
							$scope.form = form;
						});
					};
					
					// Find all forms
					$scope.find = function() {
						$scope.forms = FormBuilder.api.query();
					};
					
				} ]);
