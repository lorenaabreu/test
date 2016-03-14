package org.fiveware.test.service;


import java.util.List;

import org.fiveware.test.model.Funcionario;

/**
 * @author Lorena Abreu
 *
 */
public interface FuncionarioService {

	/**
	 * @return
	 */
	List<Funcionario> encontrarTodosFuncionarios();
	
	/**
	 * @param id
	 * @return
	 */
	Funcionario encontrarPeloId(int id);
	
	/**
	 * @param ctps
	 * @return
	 */
	Funcionario encontrarPelaCtps(String ctps);
	
	/**
	 * @param nome
	 * @return
	 */
	Funcionario encontrarPeloNome(String nome);
	
	/**
	 * @param funcionario
	 */
	void salvarFuncionario(Funcionario funcionario);
    
	/**
	 * @param funcionario
	 */
	void updateFuncionario(Funcionario funcionario);
    
	/**
	 * @param funcionario
	 * @return
	 */
	boolean isFuncionarioExiste(Funcionario funcionario);
	
	/**
	 * @param funcionario
	 * @return
	 */
	boolean isExisteCtps(Funcionario funcionario);
	
	/**
	 * @param id
	 */
	void deleteFuncionarioPeloId (int id);
	
	/**
	 * 
	 */
	void deletarTodosFuncionarios();
	
}
