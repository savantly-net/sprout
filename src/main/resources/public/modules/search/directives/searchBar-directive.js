angular.module('search').directive('searchBarDirective', [function () {
    return {
        templateUrl: 'modules/search/views/directive-templates/searchBar.view.html',
        restrict: 'E',
        scope: {
            search:'=search',
            query:'=query'
        }
    };
  }]);
