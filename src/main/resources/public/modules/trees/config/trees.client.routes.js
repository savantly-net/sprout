'use strict';

//Setting up route
angular.module('trees').config(['$stateProvider',
	function($stateProvider) {
		// Trees state routing
		$stateProvider.
		state('listTrees', {
			url: '/trees',
			templateUrl: 'modules/trees/views/list-trees.client.view.html'
		}).
		state('createTree', {
			url: '/trees/create',
			templateUrl: 'modules/trees/views/create-tree.client.view.html'
		}).
		state('viewTree', {
			url: '/trees/:bookitoId',
			templateUrl: 'modules/trees/views/view-tree.client.view.html'
		}).
		// View a specific page
		state('readTree', {
			url: '/trees/:treeId/branch/:branchId',
			templateUrl: 'modules/trees/views/render-tree.client.view.html'
		}).
		state('editTree', {
			url: '/trees/:treeId/edit',
			templateUrl: 'modules/trees/views/edit-tree.client.view.html'
		});
	}
]);