package org.fiveware.test.web.controller;

import java.util.List;
import org.fiveware.test.model.Funcionario;
import org.fiveware.test.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class FuncionarioController {

	@Autowired
	FuncionarioService service;	

	/**
	 * Listando todos os funcionario
	 */
	@RequestMapping(value = { "/funcionario" }, method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> listTodosFuncionarios (){
		
		List<Funcionario> funcionarios = service.encontrarTodosFuncionarios();
		
		if (funcionarios.isEmpty()) {
			return new ResponseEntity<List<Funcionario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
		
	}
	
	/**
	 * Obter um funcionario pelo ID
	 */
	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable("id") int id) {
		
		Funcionario funcionario = service.encontrarPeloId(id);
		
		if (funcionario== null) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	/**
	 * Criar um funcionario
	 */
	@RequestMapping(value = { "/funcionario" }, method = RequestMethod.POST)
    public ResponseEntity<Void> createFuncionario(@RequestBody Funcionario funcionario, UriComponentsBuilder ucBuilder) {
         
        if(service.isFuncionarioExiste(funcionario)){
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        if(service.isExisteCtps(funcionario)){
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
         
        service.salvarFuncionario(funcionario);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	/**
	 * Atualizar um funcionario
	 */
	@RequestMapping(value = { "/funcionario/{id}" }, method = RequestMethod.PUT)
    public  ResponseEntity<Funcionario> updateFuncionario(@PathVariable("id") int id, @RequestBody Funcionario funcionario ) {
		
		Funcionario currFunc = service.encontrarPeloId(id);
		
		if(currFunc==null){
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}
		
		currFunc.setNome(funcionario.getNome());
		currFunc.setCtps(funcionario.getCtps());
		currFunc.setAceite(funcionario.getAceite());
		currFunc.setMesPreferencia(funcionario.getMesPreferencia());
		currFunc.setSexo(funcionario.getSexo());
		
        service.updateFuncionario(currFunc);
 
        return new ResponseEntity<Funcionario>(currFunc, HttpStatus.OK);
    }
	
	/**
	 * Deletar um funcionario
	 */
	@RequestMapping(value = { "/funcionario/{id}" }, method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable("id") int id) {
        
		Funcionario func = service.encontrarPeloId(id);
		
		if(func == null){
			return new ResponseEntity<Funcionario> (HttpStatus.NOT_FOUND);
		}
		
		service.deleteFuncionarioPeloId(id);
		
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 * Deletar todos os funcionarios
	 */
	@RequestMapping(value = "/funcionario", method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> deleteTodosFuncionarios() {
 
        service.deletarTodosFuncionarios();
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
    }
}
