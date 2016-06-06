'use strict';

//Trees service used to communicate Trees REST endpoints
angular.module('trees').factory('Trees', ['$resource', '$http', 
	function($resource, $http) {
		return $resource('rest/trees/:treeId', { treeId: '@_id'
		}, {
			update: {
				method: 'PUT'
			},
			search: {
				method: 'GET',
				url: 'rest/trees/search/:query'
			}
		});
	}
]);