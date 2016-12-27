'use strict';

angular.module('core').factory('MediaSize', [function(){
	/**
	 * Detect and return the current active responsive breakpoint in Bootstrap
	 * @returns {string}
	 */
	function getCurrentSize() {
	    var envs = ["xs", "sm", "md", "lg"];
	    var env = "";

	    var el = angular.element("<div>");
	    el.appendTo(angular.element("body"));

	    for (var i = envs.length - 1; i >= 0; i--) {
	        env = envs[i];
	        el.addClass("hidden-" + env);
	        if (el.is(":hidden")) {
	            break; // env detected
	        }
	    }
	    el.remove();
	    return env;
	}
	
	var initialSize = getCurrentSize();
	
	return {
		initialSize: initialSize,
		currentSize: getCurrentSize
	};
}]);