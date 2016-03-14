'use strict';

App.controller('FuncionarioController', ['$scope', 'Funcionario', function($scope, Funcionario) {
          var self = this;
          self.func= new Funcionario();
          self.aceite = false;
          $scope.data = {
        		  	availableOptions: [
        		  	                   {id:'January', name: 'January'},
        		  	                   {id:'February', name: 'February'},
        		  	                   {id:'March', name: 'March'},
        		  	               	   {id:'April', name: 'April'},
        		  	               	   {id:'May', name: 'May'},
        		  	               	   {id:'June', name: 'June'},
        		  	               	   {id:'July', name: 'July'},
        		  	               	   {id:'August', name: 'August'},
        		  	               	   {id:'September', name: 'September'},
        		  	               	   {id:'October', name: 'October'},
        		  	               	   {id:'November', name: 'November'},
        		  	               	   {id:'December', name: 'December'}
        		  	]};
          
          self.funcs=[];
              
          self.fetchAllFuncs = function(){
        	  self.funcs = Funcionario.query();        	  
          };
           
          self.createFunc = function(){
        	  self.mudaInvert();
        	  self.func.$save(function(){
                  self.fetchAllFuncs();
              });
          };

          self.updateFunc = function(){
        	  self.mudaInvert();
        	  self.func.$update(function(){
                  self.fetchAllFuncs();
              });
          };

         self.deleteFunc = function(identity){
        	 var func = Funcionario.get({id:identity}, function() {
        		 func.$delete(function(){
                     console.log('Deletando funcionario de ID ', identity);
                     self.fetchAllFuncs();
                 });
            });
          };

          self.fetchAllFuncs();

          self.submit = function() {      	  
        	  
              if(self.func.id==null){
                  console.log('Salvando funcionário', self.func); 
                  self.createFunc();
              }else{
    			  console.log('Atualizando funcionário com ID ', self.func.id);
    			  self.updateFunc();
                  console.log('Atualizado o funcionário com ID ', self.func.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('ID a ser editado ', id);
              for(var i = 0; i < self.funcs.length; i++){
                  if(self.funcs[i].id === id) {
                     self.func = angular.copy(self.funcs[i]);
                     self.muda(self.func.aceite);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('ID do funcionario a ser deletado', id);
              if(self.func.id === id) {
                 self.reset();
              }
              self.deleteFunc(id);
          };

          
          self.reset = function(){
              self.func= new Funcionario();
              self.aceite = false;
              $scope.myForm.$setPristine(); //reset Form
          };
		  
          self.muda = function(aceite){
        	  if(aceite==='nao'){
        		  self.aceite = false;
        	  }else{
        		  self.aceite = true;
        	  }
          }
          
          self.mudaInvert = function(){
        	  if(!self.aceite){
        		  self.func.aceite = 'nao';
        	  }else{
        		  self.func.aceite = 'sim';
        	  }
          }
          
      }]);
