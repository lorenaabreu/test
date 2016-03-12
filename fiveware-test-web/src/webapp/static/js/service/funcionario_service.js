'use strict';


App.factory('FuncionarioService', ['$http','$q', function ($http, $q) {
	//$resource() function returns an object of resource class
    return {
    		
    		fetchAllFuncs: function() {
				return $http.get('http://localhost:8080/fiveware/api/v1/funcionario/')
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Erro na busca de todos os Funcionários.');
									return $q.reject(errResponse);
								}
						);
		},
	    
		createFunc: function(func){
				return $http.post('http://localhost:8080/fiveware/api/v1/funcionario/', func)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Erro ao salvar funcionário.');
									return $q.reject(errResponse);
								}
						);
	    },
	    
	    updateFunc: function(func, ctps){
				return $http.put('http://localhost:8080/fiveware/api/v1/funcionario/'+ctps, func)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Erro durante atualização do Funcionário.');
									return $q.reject(errResponse);
								}
						);
		},
	    
		deleteFunc: function(ctps){
				return $http.delete('http://localhost:8080/fiveware/api/v1/funcionario/'+ctps)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Erro durante deleção.');
									return $q.reject(errResponse);
								}
						);
				
		}
    };
}]);