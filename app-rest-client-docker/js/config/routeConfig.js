angular
	.module("app")
	.config(function ($routeProvider) {
		
		$routeProvider.when("/novoCliente", {
			templateUrl: "view/novoCliente.html",
			controller: "custumerCtrl",
		}
	);
});