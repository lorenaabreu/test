package org.fiveware.test.web.controller;

import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;

import org.fiveware.test.model.Funcionario;
import org.fiveware.test.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	
	@Autowired
	MessageSource messageSource;
	
	/*
	 * Este método irá listar todos os funcionarios
	 */
	@RequestMapping(value = { "/api/v1/funcionario" }, method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> listFuncionarios (){
		
		List<Funcionario> funcionarios = service.encontrarTodosFuncionarios();
		
		if (funcionarios.isEmpty()) {
			return new ResponseEntity<List<Funcionario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/api/v1/funcionario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable("id") Integer id) {
		Funcionario funcionario = service.encontrarPeloId(id);
		if (funcionario== null) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	/*
	 * Este m�todo ir� adicionar novo funcionario
	 */
//	@RequestMapping(value = { "/api/v1/funcionario/" }, method = RequestMethod.GET)
//	public String novoFuncionario(ModelMap model) {
//		Funcionario funcionario= new Funcionario();
//	    model.addAttribute("funcionario", funcionario);
//	    model.addAttribute("edit", false);
//	    return "registration";
//	}
	 
	 /*
	  * Este m�todo ser� chamado na submiss�o do form, usando requisi��o POST
	  * para salvar o funcionario no banco. Tamb�m valida o input.
	  */
	@RequestMapping(value = { "/api/v1/funcionario/" }, method = RequestMethod.POST)
    public ResponseEntity<Void> salvarFuncionario(@RequestBody Funcionario funcionario, UriComponentsBuilder ucBuilder) {
         
        if(!service.isFuncionarioCtpsUnica(funcionario.getId(), funcionario.getCtps())){
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
         
        service.salvarFuncionario(funcionario);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/v1/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	/*
	 * Este metodo ir� prover a edi��o de um funcion�rio existente
	 */
//	@RequestMapping(value = { "/edit-{ctps}-funcionario" }, method = RequestMethod.GET)
//    public String editarFuncionario(@PathVariable String ctps, ModelMap model) {
//        Funcionario funcionario = service.encontrarFuncionarioPelaCtps(ctps);
//        model.addAttribute("funcionario", funcionario);
//        model.addAttribute("edit", true);
//        return "registration";
//    }
	
	/*
	 * Este m�todo ser� chamando na submiss�o do form de edi��o do funcion�rio.
	 * Tamb�m ir� validar o input.
	 */
	@RequestMapping(value = { "/api/v1/funcionario/{ctps}" }, method = RequestMethod.PUT)
    public  ResponseEntity<Funcionario>  updateFuncionario(@PathVariable("ctps") String ctps, @RequestBody Funcionario funcionario ) {
  
        service.updateFuncionario(funcionario);
 
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }
	
	/*
	 * Este m�todo ir� deletar um funcion�rio pelo n�mero da CTPS
	 */
	@RequestMapping(value = { "/api/v1/funcionario/{ctps}" }, method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable("ctps") String ctps) {
        service.deleteFuncionarioPelaCtps(ctps);
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
    }
}
