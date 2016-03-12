package org.fiveware.test.service;

import java.util.List;

import org.fiveware.test.model.Funcionario;

/**
 * @author Lole Abreu
 *
 */
public interface FuncionarioService {

	/**
	 * @param id
	 * @return Funcionario
	 */
	Funcionario encontrarPeloId(int id);

    /**
     * @param funcionario
     */
    void salvarFuncionario(Funcionario funcionario);
          
    /**
     * @param funcionario
     */
    void updateFuncionario(Funcionario funcionario);
     
    /**
     * @param ctps
     */
    void deleteFuncionarioPelaCtps(String ctps);
 
    /**
     * @return List<Funcionario>
     */
    List<Funcionario> encontrarTodosFuncionarios();
    
    /**
     * @param ctps
     * @return Funcionario
     */
    Funcionario encontrarFuncionarioPelaCtps(String ctps);
 
    /**
     * @param id
     * @param ctps
     * @return boolean
     */
    boolean isFuncionarioCtpsUnica(Integer id, String ctps);
    
    
    
    
     
    

}
