'use strict';

angular.module('form-builder').directive('fieldEditDirective', [function () {
    return {
        controller: function($scope){

            // add new option to the field
            $scope.addOption = function (){
            	var field = $scope.field;
                if(!field.field_options)
                    field.field_options = new Array();

                var lastOptionID = 0;

                if(field.field_options[field.field_options.length-1])
                    lastOptionID = field.field_options[field.field_options.length-1].option_id;

                // new option's id
                var option_id = lastOptionID + 1;

                var newOption = {
                    "option_id" : option_id,
                    "option_title" : "Option " + option_id,
                    "option_value" : option_id
                };

                // put new option into field_options array
                field.field_options.push(newOption);
            };

            // delete particular option
            $scope.deleteOption = function (field, option){
                for(var i = 0; i < field.field_options.length; i++){
                    if(field.field_options[i].option_id == option.option_id){
                        field.field_options.splice(i, 1);
                        break;
                    }
                }
            };

            // decides whether field options block will be shown (true for dropdown and radio fields)
            $scope.showAddOptions = function (field){
                if(field.field_type == "radio" || field.field_type == "dropdown")
                    return true;
                else
                    return false;
            };
        },
        templateUrl: 'modules/form-builder/views/directive-templates/field/field-edit.html',
        restrict: 'E',
        scope: {
            field:'=field'
        }
    };
  }]);
