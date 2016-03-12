package org.fiveware.test.model.repositorio;

import java.util.List;

import org.fiveware.test.model.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("funcionarioDao")
public class FuncionarioDaoImpl extends AbstractDao<Integer, Funcionario> implements FuncionarioDao{

	public Funcionario encontrarPeloId(int id) {
        return getByKey(id);
    }
 
    public void salvarFuncionario(Funcionario funcionario) {
        persist(funcionario);
    }
 
    public void deleteFuncionarioPelaCtps(String ctps) {
        Query query = getSession().createSQLQuery("delete from Funcionario where ctps = :ctps");
        query.setString("ctps", ctps);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Funcionario> encontrarTodosFuncionarios() {
        Criteria criteria = createEntityCriteria();
        return (List<Funcionario>) criteria.list();
    }
 
    public Funcionario encontrarFuncionarioPelaCtps(String ctps) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ctps", ctps));
        return (Funcionario) criteria.uniqueResult();
    }

}
