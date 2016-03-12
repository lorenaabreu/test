'use strict';

App.controller('FuncionarioController', ['$scope', 'FuncionarioService', function($scope, FuncionarioService) {
          
		  $scope.meses = ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'];
		  var self = this;
          self.func= new Funcionario();
          
          self.funcs=[];
              
          self.fetchAllFuncs = function(){
        	  FuncionarioService.encontrarTodosFuncionarios()
        	  	.then( 
        	  			function(f){
        	  				self.funcs = f;
        	  			},
        	  			function(errResponse){
        	  				window.alert("Erro na busca de todos os Funcionários.");
        	  				console.error('Erro na busca de todos os Funcionários.');
        	  			}
        	  	);
        	  
          };
           
          self.createFunc = function(func){
        	  FuncionarioService.salvarFuncionario(func)
        	  	.then(
        	  			self.fetchAllFuncs,
        	  			function(errResponse){
        	  				window.alert("Funcionário já existente.");
        	  				console.error('Erro ao salvar funcionário.');
        	  			}
       	  			);
        	  self.reset();
          };

          self.updateFunc = function(func, ctps){
        	  
        	  FuncionarioService.updateFuncionario(func, ctps)
        	  	.then(
        	  			self.fetchAllFuncs,
        	  			function(){
        	  				window.alert("Funcionário atualizado.")
        	  			},
        	  			function(errResponse){
        	  				window.alert("Erro durante atualização do Funcionário.");
        	  				console.error('Erro durante atualização do Funcionário');
        	  			}
        	  	);
        	  
        	  
        	  self.reset();
          };

         self.deleteFunc = function(ctps){
        	 FuncionarioService.deleteFuncionarioPelaCtps(ctps)
        	 	.then(
        	 			self.fetchAllFuncs,
        	 			function(errResponse){
        	 				window.alert("Erro durante deleção.");
        	 				console.error('Erro durante deleção.');
        	 			}
        	 		);
        	 self.reset();
          };

          self.fetchAllFuncs();

          self.submit = function() {
              if(self.func.id==null){
                  console.log('Salvando funcionário', self.func);    
                  self.createFunc(self.func);
              }else{
    			  console.log('Atualizando funcionário com ID ', self.func.id);
                  self.updateFunc(self.func, self.func.ctps);
                  console.log('Atualizado o funcionário com ID ', self.func.id);
              }
              self.reset();
          };
              
          self.edit = function(func){
              console.log('ID a ser editado ', func.id);
              for(var i = 0; i < self.funcs.length; i++){
                  if(self.funcs[i].id === func.id) {
                     self.func = angular.copy(self.funcs[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(ctps){
              console.log('CTPS a ser deletada', ctps);
              if(self.func.ctps === ctps) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteFunc(ctps);
          };

          
          self.reset = function(){
              self.func= new Funcionario();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
