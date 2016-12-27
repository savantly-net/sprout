'use strict';

// Configuring the Articles module
angular.module('organizations').run(['Menus',
	function(Menus) {
		// Set top bar menu items
		Menus.addMenuItem('topbar', 'Organizations', 'organizations', 'dropdown', '/organizations(/create)?', false, ['ROLE_ADMIN']);
		Menus.addSubMenuItem('topbar', 'organizations', 'List Organizations', 'organizations');
		Menus.addSubMenuItem('topbar', 'organizations', 'New Organization', 'organizations/create');
	}
]);