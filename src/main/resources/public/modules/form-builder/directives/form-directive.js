'use strict';

angular.module('form-builder').directive('formDirective', [function () {
    return {
        controller: function($scope){
            $scope.submit = function(){
                alert('Form submitted..');
                $scope.form.submitted = true;
            }

            $scope.cancel = function(){
                alert('Form canceled..');
            }
        },
        templateUrl: 'modules/form-builder/views/directive-templates/form/form.html',
        restrict: 'E',
        scope: {
            form:'='
        }
    };
  }]);
