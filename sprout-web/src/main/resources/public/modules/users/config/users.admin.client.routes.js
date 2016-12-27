'use strict';

// Setting up route
angular.module('users').config(['$stateProvider',
	function($stateProvider) {
		// Users state routing
		$stateProvider.
		state('listUsers', {
			url: '/users/admin',
			templateUrl: 'modules/users/views/admin/list-users.client.view.html'
		}).
		state('createUser', {
			url: '/users/admin/create',
			templateUrl: 'modules/users/views/admin/create-user.client.view.html'
		}).
		state('viewUser', {
			url: '/users/admin/:userId',
			templateUrl: 'modules/users/views/admin/view-user.client.view.html'
		}).
		state('editUser', {
			url: '/users/admin/:userId/edit',
			templateUrl: 'modules/users/views/admin/edit-user.client.view.html'
		});
	}
]);