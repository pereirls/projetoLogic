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
	
	public List<Conta> listarNome(String nome) throws Exception {
		
		return bean.listarNome(nome);
		
	}
	
	public List<Conta> listaTipoLancamento(Integer tipoLancamento) throws Exception{
		
		return bean.listTipoLancamento(tipoLancamento);
		
	}
	
	public List<Conta> listaDataLancamento(String dataLancamento) throws Exception{
		
		return bean.listaData(dataLancamento);
		
	}
	
	
	
	public void salvar(Conta conta) throws Exception {
		
		conta.setId(null);
		bean.salvar(conta);
	}
	
	
	public void excluir(Integer id) throws Exception {
		
		bean.excluir(id);
				
	}
	
	
	public Conta alterar(Conta conta) throws Exception {
			
		return bean.alterar(conta);
	
	}
	
	
	
}
