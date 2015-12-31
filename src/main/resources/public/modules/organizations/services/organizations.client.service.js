'use strict';

//Module service used to communicate with REST endpoints
angular.module('organizations').factory('Organizations', ['$resource',
	function($resource) {
		return $resource('rest/organizations/:organizationId', { treeId: '@id'
		}, {
			update: {
				method: 'PUT'
			}
		});
	}
]);