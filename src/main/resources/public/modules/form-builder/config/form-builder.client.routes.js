'use strict';

//Setting up route
angular.module('form-builder').config(['$stateProvider',
	function($stateProvider) {
		// Form-Builder state routing
		$stateProvider.
		state('listForms', {
			url: '/forms',
			templateUrl: 'modules/form-builder/views/list-forms.client.view.html'
		}).
		state('createForm', {
			url: '/forms/create',
			templateUrl: 'modules/form-builder/views/create-form.client.view.html'
		}).
		state('viewForm', {
			url: '/forms/:formId',
			templateUrl: 'modules/form-builder/views/view-form.client.view.html'
		}).
		state('editForm', {
			url: '/forms/:formId/edit',
			templateUrl: 'modules/form-builder/views/edit-form.client.view.html'
		}).
		state('embeddedForm', {
			url: '/forms/:formId/embedded',
			templateUrl: 'modules/form-builder/views/embedded-form.client.view.html'
		});
	}
]);