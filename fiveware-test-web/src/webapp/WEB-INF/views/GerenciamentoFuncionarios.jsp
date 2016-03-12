<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Fiveware Test</title>  
    <style>
      .nome.ng-valid {
          background-color: lightgreen;
      }
      .nome.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .nome.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

	  .dataContratacao.ng-valid {
          background-color: lightgreen;
      }
      .dataContratacao.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .dataContratacao.ng-dirty.ng-invalid-dataContratacao {
          background-color: yellow;
      }
      
      .salario.ng-valid {
          background-color: lightgreen;
      }
      .salario.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .salario.ng-dirty.ng-invalid-salario {
          background-color: yellow;
      }
      
      .ctps.ng-valid {
          background-color: lightgreen;
      }
      .ctps.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .ctps.ng-dirty.ng-invalid-ctps {
          background-color: yellow;
      }
      
      .sexo.ng-valid {
          background-color: lightgreen;
      }
      .sexo.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      
      .mesFavorito.ng-valid {
          background-color: lightgreen;
      }
      .mesFavorito.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="FuncionarioController as ctrl">
          <div class="panel panel-default">
          
              <div class="panel-heading"><span class="lead">Registro de Funcion�rios</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.func.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nome">Nome</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.func.nome" id="nome" class="nome form-control input-sm" placeholder="Entre com o nome" required ng-minlength="3" />
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.nome.$error.required">Este � um campo requerido</span>
                                      <span ng-show="myForm.nome.$error.minlength">M�nimo de 3 caracteres</span>
                                      <span ng-show="myForm.nome.$invalid">Este valor � inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="dataContratacao">Data de Contrata��o</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.func.dataContratacao" id="dataContratacao" class="dataContratacao form-control input-sm" placeholder="Entre com a data de contrata��o" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
	                                  <span ng-show="myForm.dataContratacao.$error.required">Este � um campo requerido</span>
	                                  <span ng-show="myForm.dataContratacao.$invalid">Este valor � inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="salario">Sal�rio</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.func.salario" id="salario" class="salario form-control input-sm" placeholder="Entre com o sal�rio" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
	                                  <span ng-show="myForm.salario.$error.required">Este � um campo requerido</span>
	                                  <span ng-show="myForm.salario.$invalid">Este valor � inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="sex">Sexo</label>
                              <div class="col-md-7">
	                               <label><input type="radio" ng-model="ctrl.func.sexo" value="Feminino" ng-required="!ctrl.func.sexo">Feminino</label><br/>
	                               <label><input type="radio" ng-model="ctrl.func.sexo" value="Masculino" ng-required="!ctrl.func.sexo">Masculino</label>
	                               <div class="has-error" ng-show="myForm.$dirty">
	                           			<span ng-show="myForm.sex.$error.required">Este � um campo requerido</span>
	                           	   </div>
                               </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="mesFavorito">M�s Favorito</label>
                              <div class="col-md-7">
	                              <select name="mesFavorito" ng-model="ctrl.func.mesFavorito" ng-options="opt as opt for opt in meses" ng-init="selected='Mar�o'" required />
	                              <div class="has-error" ng-show="myForm.$dirty">
	                              	<span ng-show="myForm.mesFavorito.$error.required">Este � um campo requerido</span>
                              	  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="ctps">CTPS</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.func.ctps" id="ctps" class="ctps form-control input-sm" placeholder="Entre com o n�mero da CTPS" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.ctps.$error.required">Este � um campo requerido</span>
                                      <span ng-show="myForm.ctps.$invalid">Este valor � inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.func.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Formul�rio</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Funcion�rios </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Nome</th>
                              <th>Data Contrata��o</th>
                              <th>Sal�rio</th>
                              <th>Sexo</th>
                              <th>M�s Favorito</th>
                              <th>CTPS</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="f in ctrl.funcs">
                              <td><span ng-bind="f.id"></span></td>
                              <td><span ng-bind="f.nome"></span></td>
                              <td><span ng-bind="f.dataContratacao"></span></td>
                              <td><span ng-bind="f.salario"></span></td>
                              <td><span ng-bind="f.sexo"></span></td>
                              <td><span ng-bind="f.mesFavorito"></span></td>
                              <td><span ng-bind="f.ctps"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(f)" class="btn btn-success custom-width">Editar</button>  <button type="button" ng-click="ctrl.remove(f.ctps)" class="btn btn-danger custom-width">Remover</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/funcionario_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/funcionario_controller.js' />"></script>
  </body>
</html>