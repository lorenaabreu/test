package org.fiveware.test.service;

import java.util.ArrayList;
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

    
	public List<Funcionario> encontrarTodosFuncionarios() {
		return dao.encontrarTodosFuncionarios();
    }
  
    public Funcionario encontrarPeloId(int id) {
    	return dao.encontrarPeloId(id);
    }
    
    public Funcionario encontrarPelaCtps(String ctps) {
		return dao.encontrarFuncionarioPelaCtps(ctps);
	}
    
    public Funcionario encontrarPeloNome(String nome){
    	List<Funcionario> funcs = new ArrayList<Funcionario>();
    	
    	funcs = encontrarTodosFuncionarios();
    	
    	for (Funcionario funcionario : funcs) {
			if (funcionario.getNome().equalsIgnoreCase(nome)){
				return funcionario;
			}
		}
    	return null;
    }
 
    public void salvarFuncionario(Funcionario funcionario) {
       dao.salvarFuncionario(funcionario);
    }
 
    public void updateFuncionario(Funcionario funcionario) {
    	Funcionario entity = dao.encontrarPeloId(funcionario.getId());
    	
    	if(entity != null){
    		entity.setNome(funcionario.getNome());
    		entity.setCtps(funcionario.getCtps());
    		entity.setAceite(funcionario.getAceite());
    		entity.setMesPreferencia(funcionario.getMesPreferencia());
    		entity.setSexo(funcionario.getSexo());
    	}
    }
    public void deleteFuncionarioPeloId (int id){
    	dao.deleteFuncionarioPeloId(id);
    }
    
   public boolean isFuncionarioExiste(Funcionario funcionario){
	   return encontrarPeloNome(funcionario.getNome())!=null;
   }
   
   public boolean isExisteCtps(Funcionario funcionario){
	   
	   Funcionario func = encontrarPelaCtps(funcionario.getCtps());
	   
	   return func!=null;
   }
 
   public void deletarTodosFuncionarios(){
	   dao.deletarTodosFuncionarios();
   }
    
}
