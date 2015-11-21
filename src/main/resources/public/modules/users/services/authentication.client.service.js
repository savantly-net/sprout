'use strict';

// Authentication service for user variables
angular.module('users').factory('Authentication', [
	function() {
		var _this = this;

		_this._data = {
			security: window.security,
			user: window.security.principal
		};

		return _this._data;
	}
]);