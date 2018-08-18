package webService;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import br.com.javaee.beans.ContaBean;
import br.com.javaee.dao.ContaDao;
import br.com.javaee.models.Conta;

@Stateless
@WebService
public class ContaWs {
	
	@Inject
	ContaBean bean;
	
	@Inject
	ContaDao dao;



	public List<Conta> listar(){
		
		return bean.listar();
		
	}
	
	public Conta listarId(Integer id){
		
		return bean.listarId(id);
		
	}
	
	public List<Conta> listarNome(String nome) {
		
		return bean.listarNome(nome);
		
	}
	
	public List<Conta> listaTipoLancamento(Integer tipoLancamento){
		
		return bean.listTipoLancamento(tipoLancamento);
		
	}
	
	public List<Conta> listaDataLancamento(String dataLancamento){
		
		return bean.listaData(dataLancamento);
		
	}
	
	
	
	public void salvar(Conta conta) throws Exception {
				
		bean.salvar(conta);
	}
	
	
	public void excluir(Integer id) throws Exception {
		
		bean.excluir(id);
				
	}
	
	public void alterar(Integer id) throws Exception {
		
		 try {
			 	bean.alterar(id);
			 	
	        } catch (Exception ex) {

	            throw ex;
	        }
	}
	
}
