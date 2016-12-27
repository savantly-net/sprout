'use strict';

// Form-Builder service used to communicate REST endpoints
angular.module('form-builder').factory('FormBuilder',
		[ '$resource', function($resource) {
			return {
				api : $resource('rest/forms/:formId', {formId : '@form_id'}, {update : {method : 'PUT'}}),
				fields : [ {
					name : 'textfield',
					value : 'Textfield'
				}, {
					name : 'email',
					value : 'E-mail'
				}, {
					name : 'password',
					value : 'Password'
				}, {
					name : 'radio',
					value : 'Radio Buttons'
				}, {
					name : 'dropdown',
					value : 'Dropdown List'
				}, {
					name : 'date',
					value : 'Date'
				}, {
					name : 'textarea',
					value : 'Text Area'
				}, {
					name : 'checkbox',
					value : 'Checkbox'
				}, {
					name : 'hidden',
					value : 'Hidden'
				} ]
			}
		} ]);