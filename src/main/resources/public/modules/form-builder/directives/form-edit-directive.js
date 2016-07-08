'use strict';

angular.module('form-builder').directive('formEditDirective', ['FormBuilder', 'MediaSize', '$uibModal', '$log', '$location', 'GuidGen', 
  function (FormBuilder, MediaSize, $uibModal, $log, $location, GuidGen) {
    return {
        controller: function($scope){
        	
        	$scope.formHelpTemplate = "formHelp.html";
        	
            $scope.saveHandler = function(){
    	    	if($scope.form.form_id){
    	    		update();
    	    	} else {
    	    		save();
    	    	}
            };

            $scope.resetHandler = function(){
                $scope.form.form_fields.splice(0, $scope.form.form_fields.length);
                if($scope.onReset){
                	$scope.onReset();
                }
            };
            
    	    var save = function(){
    	    	var formToSave = new FormBuilder.api($scope.form);
    	    	formToSave.$save(function(response) {
    	    		if($scope.onSave){
                        $scope.onSave(response);
                    }
    				$location.path('forms/' + response.form_id);
    			}, function(errorResponse) {
    				if($scope.onSave){
                        $scope.onSave(errorResponse);
                    }
    				$scope.error = errorResponse.data.message;
    			});
    	    };
    	    
    	    var update = function(){
    	    	var formToSave = new FormBuilder.api($scope.form);
    	    	formToSave.$update(function(response) {
    	    		if($scope.onSave){
                        $scope.onSave(response);
                    }
    				$location.path('forms/' + response.form_id);
    			}, function(errorResponse) {
    				if($scope.onSave){
                        $scope.onSave(errorResponse);
                    }
    				$scope.error = errorResponse.data.message;
    			});
    	    };
    	    
    	    $scope.remove = function(){
    	    	var formObject = new FormBuilder.api($scope.form);
    	    	
    	    	var modalInstance = $uibModal.open({
                    templateUrl: 'modules/core/views/templates/confirm.view.html',
                    controller: function($scope, $uibModalInstance){
                    	$scope.body = 'Permanently delete this form?';
						$scope.ok = function () {
							$uibModalInstance.close();
						};
						
						$scope.cancel = function () {
							$uibModalInstance.dismiss();
						};
					},
                    size: 'sm'
                  });

				modalInstance.result.then(function confirmed(field) {
					formObject.$remove(function(result){
						$location.path('forms');
					}, function failed(errorResponse){
						$scope.error = errorResponse.data.message;
					});
				});
    	    };
            
            // preview form mode
            $scope.previewMode = false;

            // new form
            $scope.form = {};
            $scope.form.form_id = null;
            $scope.form.form_name = 'My Form';
            $scope.form.form_fields = [];

            // previewForm - for preview purposes, form will be copied into this
            // otherwise, actual form might get manipulated in preview mode
            $scope.previewForm = {};
            

            // add new field drop-down:
            $scope.addField = {};
            $scope.addField.types = FormBuilder.fields;
            $scope.addField.new = $scope.addField.types[0].name;

            // accordion settings
            $scope.accordion = {}
            $scope.accordion.oneAtATime = true;
            

            // create new field button click
            $scope.addNewField = function(fieldType){
            	
                var newField = {
                    "field_id" : GuidGen.generate(),
                    "field_title" : "New " + fieldType + " field",
                    "field_type" : fieldType,
                    "field_value" : "",
                    "field_required" : true,
        			"field_disabled" : false
                };

                var modalInstance = $uibModal.open({
                  templateUrl: 'modules/form-builder/views/directive-templates/field/field-edit-modal.html',
                  controller: function($scope, $uibModalInstance){
			                	  $scope.field = newField;
			
			                	  $scope.ok = function () {
			                	    $uibModalInstance.close($scope.field);
			                	  };
			
			                	  $scope.cancel = function () {
			                	    $uibModalInstance.dismiss('cancel');
			                	  };
			                  },
                  size: 'lg'
                });

                modalInstance.result.then(function confirmed(field) {
                	// put newField into fields array
    				$scope.form.form_fields.push(field);
                }, function cancelled(){
                	$log.info('Add new form field cancelled at: ' + new Date());
                })
              };
              
              // edit field button click
              $scope.editField = function(field){

                  var modalInstance = $uibModal.open({
                    templateUrl: 'modules/form-builder/views/directive-templates/field/field-edit-modal.html',
                    controller: function($scope, $uibModalInstance){
  			                	  $scope.field = field;
  			
  			                	  $scope.ok = function () {
  			                	    $uibModalInstance.close($scope.field);
  			                	  };
  			
  			                	  $scope.cancel = function () {
  			                	    $uibModalInstance.dismiss('cancel');
  			                	  };
  			                  },
                    size: 'lg'
                  });
                };

            // deletes particular field on button click
            $scope.deleteField = function (field_id){
            	var formInstance = $scope.form;
            	var modalInstance = $uibModal.open({
                    templateUrl: 'modules/core/views/templates/confirm.view.html',
                    controller: function($scope, $uibModalInstance){
  			                	  $scope.title = 'Confirm';
  			                	  $scope.body = '<p>Delete this field?</p>';
  			                	  $scope.ok = function () {
  			                		  for(var i = 0; i < formInstance.form_fields.length; i++){
	  			                          if(formInstance.form_fields[i].field_id == field_id){
	  			                        	formInstance.form_fields.splice(i, 1);
	  			                              break;
	  			                          }
  			                		  }
  			                	    $uibModalInstance.close();
  			                	  };
  			
  			                	  $scope.cancel = function () {
  			                	    $uibModalInstance.dismiss();
  			                	  };
  			                  },
                    size: 'xs'
                  });
                
            };

            // preview form
            $scope.previewOn = function(){
                if($scope.form.form_fields == null || $scope.form.form_fields.length == 0) {
                    var title = 'Error';
                    var msg = 'No fields added yet, please add fields to the form before preview.';
                    var btns = [{result:'ok', label: 'OK', cssClass: 'btn-primary'}];

                    notify({
        				message: msg,
        				duration: '5000',
        				position: 'right',
        				classes: ['error']
        			});
                    
                }
                else {
                    $scope.previewMode = !$scope.previewMode;
                    $scope.form.submitted = false;
                    angular.copy($scope.form, $scope.previewForm);
                }
            };

            // hide preview form, go back to create mode
            $scope.previewOff = function(){
                $scope.previewMode = !$scope.previewMode;
                $scope.form.submitted = false;
            };

        },
        templateUrl: 'modules/form-builder/views/directive-templates/form/form-edit.html',
        restrict: 'E',
        scope: {
            form:'=form',
            onSave: '&onSubmit',
            onReset: '&onCancel'
        }
    };
  }]);
