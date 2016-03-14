package org.fiveware.test.model.repositorio;

import java.util.List;

import org.fiveware.test.model.Funcionario;


/**
 * Interface DAO
 * @author Lorena Abreu
 *
 */
public interface FuncionarioDao{

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
	Funcionario encontrarFuncionarioPelaCtps(String ctps);
	
    /**
     * @param funcionario
     */
    void salvarFuncionario(Funcionario funcionario);
     
    /**
     * @param id
     */
    void deleteFuncionarioPeloId (int id);
    
    /**
     * 
     */
    void deletarTodosFuncionarios();

}
