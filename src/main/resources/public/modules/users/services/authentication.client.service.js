'use strict';

// Authentication service for user variables
angular.module('users').factory('Authentication', [
	function() {
		var _this = this;

		_this._data = {
			security: window.security,
			user: window.security.principal
		};
		
		// reformatting the authority array to make it easier to access
		_this._data.user.roles = window.security.principal.authorities.map(function(authorityItem){
			return authorityItem.authority;
		});

		return _this._data;
	}
]);