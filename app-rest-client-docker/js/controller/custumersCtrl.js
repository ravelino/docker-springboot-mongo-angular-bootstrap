angular
	.module('app')
	.controller('custumerCtrl', function($scope, $http, appConfig) {

		var buscarClientes = function() {
			$http
			.get(appConfig.restApiBaseUrl + 'customers')
			.then(
				function successCallback(response) {
					console.log(response.data);
					$scope.customers = response.data;
				}, 
				function errorCallback(response) {
					console.log('Erro');
				}
			);
		}
		
		var buscarCliente = function(idCliente) {
			$http
			.get(appConfig.restApiBaseUrl + 'customers/' + idCliente)
			.then(
				function successCallback(response) {
					console.log(response.data);
					$scope.clientes = response.data;
				}, 
				function errorCallback(response) {
					console.log('Erro');
				}
			);
		}
		
		$scope.removerCliente = function(id) {
			console.log(id);
			
			$http
				.delete(appConfig.restApiBaseUrl + 'customers/' + id)
				.then(
					function successCallback(response) {
						console.log(response.data);
					}, 
					function errorCallback(response) {
						console.log(response);
					}
				);
		}
				
		buscarClientes();
	});