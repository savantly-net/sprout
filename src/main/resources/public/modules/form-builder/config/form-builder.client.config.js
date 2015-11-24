'use strict';

// Configuring the form-builder module
angular.module('form-builder').run(['Menus',
	function(Menus) {
		// Set top bar menu items
		Menus.addMenuItem('topbar', 'Forms', 'forms', 'dropdown', '/forms(/create)?');
		Menus.addSubMenuItem('topbar', 'forms', 'List Forms', 'forms');
		Menus.addSubMenuItem('topbar', 'forms', 'New form', 'forms/create');
	}
]);