package org.fiveware.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller para redirecionar a pag de registro
 * de funcionario
 * @author Lorena Abreu
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "GerenciamentoFuncionarios";
	    }

}