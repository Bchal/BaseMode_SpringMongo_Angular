var userApp = angular.module("userApp", [ 'ngRoute', 'ngResource',
		'restangular' ]);

userApp.config(function(RestangularProvider) {
	RestangularProvider.setBaseUrl('/springmvc-mongodb-example');
});

userApp.controller("UsersCtrl", [ '$scope', 'Restangular',
		function($scope, Restangular) {
			$scope.username = "chunfeng liu";

			Restangular.all('hello').getList().then(

			function(data) {
				var obj1 = data[0];
				var obj2 = data[1];
				
//				console.log("object 1: " + obj1.name);
//				console.log("object 2: " + obj2.name);
			}, function(error) {
				console.log("error");
			}

			);
		} ]);
