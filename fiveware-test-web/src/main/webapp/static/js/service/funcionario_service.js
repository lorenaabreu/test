'use strict';


App.factory('Funcionario', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
	return $resource(
				'http://localhost:8080/fiveware-test-web/funcionario/:id',
				{id: '@id'},//parametros
				{
					update: {
						method:'PUT'
					}
				}, //acoes
				{
					
				} //opcoes
			);
}]);