'use strict';

// activity service used to communicate with REST endpoints
angular.module('activity').factory('Activity',[ '$resource', 
    function($resource) {
			return {
				api: $resource('rest/activity/:activityId', {activityId : '@id'}, {update: {method : 'PUT'}}),
				session: {
					questionAnswers: [], 
					formAnswers: []
				}
			}
	}]);