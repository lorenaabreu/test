package org.fiveware.test.model.repositorio;


import java.util.List;

import org.fiveware.test.model.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("funcionarioDao")
public class FuncionarioDaoImpl extends AbstractDao<Integer, Funcionario> implements FuncionarioDao{
	

    @SuppressWarnings("unchecked")
	public List<Funcionario> encontrarTodosFuncionarios() {
        Criteria criteria = createEntityCriteria();
        return (List<Funcionario>) criteria.list();
    }
	
	public Funcionario encontrarPeloId(int id) {
        return getByKey(id);
    }
	
	public Funcionario encontrarFuncionarioPelaCtps(String ctps) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ctps", ctps));
        return (Funcionario) criteria.uniqueResult();
    }
	
    public void salvarFuncionario(Funcionario funcionario) {
        persist(funcionario);
    }
    
    public void deleteFuncionarioPeloId(int id) {
        Query query = getSession().createSQLQuery("delete from Funcionario where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    public void deletarTodosFuncionarios(){
    	Query query = getSession().createSQLQuery("delete from Funcionario");
        query.executeUpdate();
    }

}
