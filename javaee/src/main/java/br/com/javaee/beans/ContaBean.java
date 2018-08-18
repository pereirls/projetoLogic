package br.com.javaee.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.javaee.dao.ContaDao;
import br.com.javaee.models.Conta;

@Stateless
public class ContaBean {
	
	
	
	@Inject
	private ContaDao dao;
	
	@Transactional
	public Conta salvar(Conta conta) throws Exception{
		
		try {	
				valida(conta);
				conta = dao.salvar(conta);
			
			
			} catch (Exception e) {
				throw e;
			}
		
			return conta;
	}
	
	@Transactional
	public void excluir(Integer id) throws Exception {
		try {
				dao.excluir(id);
		} catch (Exception e) {
				throw e;
		}
		
	}

	
	@Transactional
	public void alterar(Integer id) throws Exception{
		
		try { 
			
					dao.alterar(id);          

        } catch (Exception e) {

            
            throw e;

        }

        
	}
	
		
	private List<Conta> contas = new ArrayList<>();	
	
	@Transactional
	public List<Conta> listar() {
		
		try {
				this.contas = dao.listar();
		} catch (Exception e) {
				throw e;
		}	
		
		return contas;
		
	}
	
	public Conta listarId(Integer id){
		try {
				return dao.listarId(id);
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
	@Transactional
    public List<Conta> listarNome(String nome){
		try {
				 dao.listarNome(nome);
				
		} catch (Exception e) {
			throw e;
		}
		
		return dao.listarNome(nome);
		
	}	
		
	@Transactional
	public List<Conta> listaData(String dataLancamento){
		try {
				return dao.listarData(dataLancamento);
		} catch (Exception e) {
			throw e;
		}
		
	
	}

	@Transactional
	public List<Conta> listTipoLancamento(Integer tipoLancamento){
		try {
				return dao.listarTipoLancamento(tipoLancamento);
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
	
	
	
	
	private void valida(Conta conta) throws Exception {
		
			if (conta.getNome() == null || (conta.getNome().length() < 5)) {
        		throw new Exception("Insira o Nome da conta");
        	}
        
        	if (conta.getDataLancamento() == null) {
        		throw new Exception("Insira a data Lançamento");
        	}
        	
        	if (conta.getValor() == null || conta.getValor() <= 0) {
        		throw new Exception("Insira o valor");
        	}

        	if (conta.getTipoLancamento() == null) {
        		throw new Exception("Insira o tipo Lançamento");
        	} 
        	
        	
    }
	
}
