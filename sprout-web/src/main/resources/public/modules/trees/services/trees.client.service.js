'use strict';

//Trees service used to communicate Trees REST endpoints
angular.module('trees').factory('Trees', ['$resource', '$http', 
	function($resource, $http) {
		return $resource('rest/trees/:treeId', { treeId: '@_id', username: '@username'
		}, {
			update: {
				method: 'PUT'
			},
			search: {
				method: 'GET',
				url: 'rest/trees/search/:query'
			},
			queryByUsername: {
				method: 'GET',
				isArray: true,
				url: 'rest/trees/summary/by/username/:username'
			}
		});
	}
]);