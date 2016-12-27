'use strict';

// Configuring the Articles module
angular.module('activity').run(['Menus',
	function(Menus) {
		// Set top bar menu items
		Menus.addMenuItem('topbar', 'Activity', 'activity', 'menuItem', '/activity', false, ['ROLE_ADMIN', 'ROLE_MANAGER']);
	}
]);