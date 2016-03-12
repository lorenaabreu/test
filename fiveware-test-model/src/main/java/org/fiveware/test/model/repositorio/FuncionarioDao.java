package org.fiveware.test.model.repositorio;

import java.util.List;

import org.fiveware.test.model.Funcionario;


public interface FuncionarioDao {

	Funcionario encontrarPeloId(int id);

    void salvarFuncionario(Funcionario funcionario);
     
    void deleteFuncionarioPelaCtps(String ctps);
     
    List<Funcionario> encontrarTodosFuncionarios();
 
    Funcionario encontrarFuncionarioPelaCtps(String ctps);

}
