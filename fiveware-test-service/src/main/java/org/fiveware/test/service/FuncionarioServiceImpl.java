package org.fiveware.test.service;

import java.util.List;

import org.fiveware.test.model.Funcionario;
import org.fiveware.test.model.repositorio.FuncionarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("funcionarioService")
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDao dao;
    
    public Funcionario encontrarPeloId(int id) {
        return dao.encontrarPeloId(id);
    }
 
    public void salvarFuncionario(Funcionario funcionario) {
        dao.salvarFuncionario(funcionario);
    }
 
    public void updateFuncionario(Funcionario funcionario) {
        Funcionario entity = dao.encontrarPeloId(funcionario.getId());
        if(entity!=null){
            entity.setNome(funcionario.getNome());
            entity.setDataContratacao(funcionario.getDataContratacao());
            entity.setSalario(funcionario.getSalario());
            entity.setCtps(funcionario.getCtps());
        }
    }
 
    public void deleteFuncionarioPelaCtps(String ctps) {
        dao.deleteFuncionarioPelaCtps(ctps);
    }
     
    public List<Funcionario> encontrarTodosFuncionarios() {
        return dao.encontrarTodosFuncionarios();
    }
 
   public Funcionario encontrarFuncionarioPelaCtps(String ctps){
	   return dao.encontrarFuncionarioPelaCtps(ctps);
   }
 
    public boolean isFuncionarioCtpsUnica(Integer id, String ctps) {
        Funcionario funcionario = encontrarFuncionarioPelaCtps(ctps);
        return ( funcionario == null || ((id != null) && (funcionario.getId() == id)));
    }
}
