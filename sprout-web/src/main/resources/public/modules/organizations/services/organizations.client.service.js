'use strict';

//Module service used to communicate with REST endpoints
angular.module('organizations').factory('Organizations', ['$resource',
	function($resource) {
		return $resource('rest/organizations/:organizationId', { organizationId: '@id'
		}, {
			update: {
				method: 'PUT'
			},
			addMember:{
				method: 'POST',
				url: 'rest/organizations/addMember'
			}
		});
	}
]);