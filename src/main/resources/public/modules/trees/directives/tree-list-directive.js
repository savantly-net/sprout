'use strict';

angular.module('trees').directive('treeListDirective', [function () {
    return {
        templateUrl: 'modules/trees/views/directive-templates/tree.list.html',
        restrict: 'E',
        scope: {
            trees:'=trees'
        }
    };
  }]);
