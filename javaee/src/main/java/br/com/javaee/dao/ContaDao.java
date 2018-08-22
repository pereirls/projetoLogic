package br.com.javaee.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import br.com.javaee.models.Conta;

@Stateless
public class ContaDao {
	
	@PersistenceContext//(type=PersistenceContextType.EXTENDED)
    EntityManager  manager;
	
	public Conta salvar(Conta conta) {
				
		manager.persist(conta);
		return conta;
		
	}
	
	public void excluir(Integer id) {
		
		 Conta contaE = manager.find(Conta.class,id);
		 manager.remove(contaE);
		
	}
	

	public Conta alterar(Conta conta) {
			
		Conta contaA = manager.find(Conta.class, conta.getId());
		if(contaA != null) {
			contaA = conta;
			manager.merge(contaA);
		}
		
		return contaA;
		
	}
	
	public List<Conta> listar() {
		
		String jpql = "select c from Conta c";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> listWs(String nome){
		
		String sql = "select c from Conta c where upper(c.nome) like '%" + nome.toUpperCase() + "%'";
				Query query = manager.createQuery(sql);
		        return query.getResultList();
		
	}
	
	
	/*public  Integer validaTipolancamento (Integer id) {
		
		
		String sql = "select t.id from tipolancamento t where t.id =" + id + "";
		Query query = manager.createNativeQuery(sql);
	
	}*/
	
	public Conta listarId(Integer id) {
		
		return manager.find(Conta.class, id);
		
	}
	
	public List<Conta> listarData(String dataLancamento) {
		
		TypedQuery<Conta> query = this.manager.createQuery(
                "select c from Conta c " + 
                "where c.dataLancamento like :data", Conta.class);
        query.setParameter("data","%"+dataLancamento+"%");
        System.out.println(dataLancamento);
        return query.getResultList();
        
       
	}
	

	public List<Conta> listarNome(String nome){
		
		TypedQuery<Conta> query = this.manager.createQuery(
				"select c from Conta c " + 
						"where c.nome like :nome", Conta.class);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
		
	}
		
	
	
	public List<Conta> listarTipoLancamento(Integer tipoLancamento){
		
		TypedQuery<Conta> query = this.manager.createQuery(
                "select c from Conta c " + 
                "where c.tipoLancamento like :tipo", Conta.class);
        query.setParameter("tipo", tipoLancamento );
		return query.getResultList();
		
	}
		
}
	
	
	
	
	
	
	

	
