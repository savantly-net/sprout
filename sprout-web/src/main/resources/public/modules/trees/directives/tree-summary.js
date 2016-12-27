'use strict';

angular.module('trees').directive('treeSummaryDirective', [function () {
    return {
        templateUrl: 'modules/trees/views/directive-templates/tree-summary.html',
        restrict: 'E',
        scope: {
            tree:'=tree'
        }
    };
  }]);
