'use strict';

// Create Form controller
angular.module('form-builder').controller(
		'ViewFormController',
		[ '$scope', '$stateParams', 'Authentication', 'FormBuilder', 'Activity',  
				function($scope, $stateParams, Authentication, FormBuilder, Activity) {
					$scope.authentication = Authentication;
					$scope.form = {};
					$scope.stateParams = $stateParams;
					
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
					
					$scope.submitForm = function(form){
						form.form_fields.map(function(form_field){
							Activity.session.formAnswers.push({
								key: form_field.field_title,
								value: form_field.field_value
							});
						});
						var activity = new Activity.api({
							formAnswers: Activity.session.formAnswers,
							form: form
						});
						activity.$save(function(response) {
							// Clear user activity data
							Activity.session.formAnswers = [];	
						}, function(errorResponse) {
							$scope.error = errorResponse.data.message;
						});
					};
					
				} ]);
