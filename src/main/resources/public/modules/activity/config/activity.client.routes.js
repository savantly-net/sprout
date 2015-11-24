'use strict';

//Setting up route
angular.module('trees').config(['$stateProvider',
	function($stateProvider) {
		// Trees state routing
		$stateProvider.
		state('listActivity', {
			url: '/activity',
			templateUrl: 'modules/activity/views/list-activity.client.view.html'
		}).
		state('viewActivity', {
			url: '/activity/:activityId',
			templateUrl: 'modules/activity/views/view-activity.client.view.html'
		});
	}
]);