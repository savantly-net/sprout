'use strict';


// Trees controller
angular.module('trees').controller('TreesController', ['$rootScope', '$scope', '$stateParams', '$location', 'smoothScroll', 'Authentication', 'Trees', 'FormBuilder', 'Activity', 'GuidGen', 'notify',
	function($rootScope, $scope, $stateParams, $location, smoothScroll, Authentication, Trees, FormBuilder, Activity, GuidGen, notify) {
		$scope.title = 'Trees';
		$scope.authentication = Authentication;
		$scope.formList = FormBuilder.api.query();

		$scope.scrollTo = function(id) {
			var element = document.getElementById(id);
			smoothScroll(element);
		};

		// Create new Tree
		$scope.create = function() {
			// Create new Tree object
			var tree = new Trees ({
				_id: GuidGen.generate(),
				name: this.name,
				description: this.description,
				coverImageUrl: this.coverImageUrl
			});

			// Redirect after save
			tree.$save(function(response) {
				$location.path('trees/' + response._id + '/edit');

				// Clear form fields
				$scope.name = '';
				$scope.description = '';
				$scope.coverImageUrl = '';
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		// Remove existing Tree
		$scope.remove = function(tree) {
			if ( tree ) {
				tree.$remove();

				for (var i in $scope.trees) {
					if ($scope.trees [i] === tree) {
						$scope.trees.splice(i, 1);
					}
				}
			} else {
				$scope.tree.$remove(function() {
					$location.path('trees');
				});
			}
		};

		// Update existing Tree
		$scope.update = function() {
			var tree = $scope.tree;
			console.info(tree);

			tree.$update(function() {
				$location.path('trees/' + tree._id);
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		$scope.updateWithNoRedirect = function(){
			var tree = $scope.tree;
			console.info(tree);

			tree.$update(function() {
				notify({
					message: 'Your Tree has been saved!',
					duration: '5000',
					position: 'right',
					classes: ['success']
				});
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};

		// Find a list of Trees
		$scope.find = function() {
			$scope.trees = Trees.query();
		};

		// Find existing Tree
		$scope.findOne = function() {
			Trees.get({
				treeId: $stateParams.treeId
			}).$promise.then(function(tree){
				$scope.tree = tree;
				$scope.startPage = $scope.getStartPage(tree);
				$scope.checkForPages();
			});
		};

		// Notify if there are no pages and the edit screen is active
		$scope.checkForPages = function(){
			if($scope.tree.pages.length === 0){
				if(S($location.path()).endsWith('edit')){
					notify({
						messageTemplate: '<span>There are no pages! <br />' +
							'<a class="btn" data-ng-click="addPage()">Add a page now</a></span>',
						scope: $scope,
						duration: '10000',
						position: 'right',
						classes: ['warning']
					});
				} else{
					notify({
						message: 'There is no Starting Page set!',
						duration: '5000',
						position: 'right',
						classes: ['warning']
					});
				}
			}
		};

		// Find existing Tree and set active page
		$scope.findPage = function() {
			Trees.get({
				treeId: $stateParams.treeId
			}).$promise.then(function(tree){
				$scope.tree = tree;
				$scope.startPage = $scope.getStartPage(tree);
				$scope.activatePageById($stateParams.branchId);
			});
		};

		// Add a page to the tree
		$scope.addPage = function(){
			var tree = $scope.tree;
			var page = {
							_id: GuidGen.generate(),
							title: 'Page ' + (tree.pages.length + 1),
							body: '',
							imageUrl: '',
							tags: [],
							choices:[]
						};
			if(tree.pages.length === 0){
				page.isStartPage = true;
			}
			tree.pages.push(page);
			$scope.activatePageThenScroll(page, 'pageEditor');
		};

		// Add a choice to the page
		$scope.addChoice = function(page){
			page.choices.push({
				_id: GuidGen.generate()
			});
		};

		// Activate a page
		$scope.activatePage = function(page){
			$scope.activePage = page;
			for (var pageIndex = 0; pageIndex < $scope.tree.pages.length; pageIndex++) {
				if(page === $scope.tree.pages[pageIndex]){
					$scope.tree.pages[pageIndex].isActive = true;
				}
				else{
					$scope.tree.pages[pageIndex].isActive = false;
				}
			}
		};

		// Activate a page
		$scope.activatePageThenScroll = function(page, elementId){
			$scope.activatePage(page);
			$scope.scrollTo(elementId);
		};

		// Activate a page by the id
		$scope.activatePageById = function(pageId){
			for (var pageIndex = 0; pageIndex < $scope.tree.pages.length; pageIndex++) {
				if(pageId === $scope.tree.pages[pageIndex]._id){
					$scope.activatePage($scope.tree.pages[pageIndex]);
				}
			}
		};

		// Set the starting page
		$scope.setStartPage = function(page){
			for (var pageIndex = 0; pageIndex < $scope.tree.pages.length; pageIndex++) {
				if(page === $scope.tree.pages[pageIndex]){
					$scope.tree.pages[pageIndex].isStartPage = true;
				}
				else{
					$scope.tree.pages[pageIndex].isStartPage = false;
				}
			}
		};

		// Get the starting page
		$scope.getStartPage = function(tree){
			var pageCount = 0;
			if(tree.pages){
				pageCount = tree.pages.length;
			}
			for (var pageIndex = 0; pageIndex < pageCount; pageIndex++) {
				if(tree.pages[pageIndex].isStartPage){
					return tree.pages[pageIndex];
				}
			}
		};

		$scope.deletePage = function(page){
			if(confirm('Delete this page?')){
				$scope.activePage = undefined;
				for (var pageIndex = 0; pageIndex < $scope.tree.pages.length; pageIndex++) {
					if(page._id === $scope.tree.pages[pageIndex]._id){
						$scope.tree.pages.splice([pageIndex], 1);
					}
				}
			}

		};
		
		$scope.decisionMade = function(choice){
			Activity.session.questionAnswers.push({
				key: $scope.activePage.title,
				value: choice.displayText
			});
		};

		$scope.toggleFullScreen = function(elementId){
			var myEl = angular.element(document.querySelector('#'+elementId));
			myEl.toggleClass('full-screen');
		};
		
		$scope.submitForm = function(form){
			form.form_fields.map(function(form_field){
				Activity.session.formAnswers.push({
					key: form_field.field_title,
					value: form_field.field_value
				});
			});
		};
		
		$scope.submitUserActivity = function(){
			var activity = new Activity.api({
				tree: $scope.tree,
				questionAnswers: Activity.session.questionAnswers,
				formAnswers: Activity.session.formAnswers
			});
			activity.$save(function(response) {
				// Clear user activity data
				Activity.session.questionAnswers = [];
				Activity.session.formAnswers = [];
				$location.path('thankYou');				
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};
	}
]);