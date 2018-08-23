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
	public Conta alterar(Conta conta) throws Exception{
	
			try { 
				
				valida(conta);
				dao.alterar(conta);
				
				
			} catch (Exception e) {

				throw e;
             
			}
			return conta;
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
	
	@Transactional
	public Conta listarId(Integer id){
		try {
				return dao.listarId(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
    public List<Conta> listarNome(String nome) throws Exception{
		try {
			
			validaNome(nome);
			return dao.listarNome(nome);
		} catch (Exception e) {
			throw e;
		}
		
		
	}	
		
	@Transactional
	public List<Conta> listaData(String dataLancamento) throws Exception{
		try {	
				validaData(dataLancamento);
				return dao.listarData(dataLancamento);
		} catch (Exception e) {
			throw e;
		}
		
	
	}

	@Transactional
	public List<Conta> listTipoLancamento(Integer tipoLancamento) throws Exception{
		try {
				validaTipo(tipoLancamento);
				return dao.listarTipoLancamento(tipoLancamento);
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
	private void validaNome(String nome) throws Exception {
		
		
		if(dao.listarNome(nome).isEmpty() == true) {
			
			throw new Exception("Nenhuma conta encontrada");
			
		}
	}
	
	private void validaData(String data) throws Exception {
		
		
		if(dao.listarData(data).isEmpty() == true) {
			
			throw new Exception("Nenhuma conta encontrada");
			
		}
	}

	private void validaTipo(int tipo) throws Exception {
	
	
		if(dao.listarTipoLancamento(tipo).isEmpty() == true) {
		
			throw new Exception("Nenhuma conta encontrada");
		
		}
	}
	
	private void valida(Conta conta) throws Exception {
		
		
			if(dao.listarNome(conta.getNome())==null) {
				
				throw new Exception("Nome não encontrado");
				
			}
			if (conta.getNome() == null){
    		
				throw new Exception("O nome da conta não pode ser nulo");
			}
			
			if (conta.getNome().length() < 5){
        		
				throw new Exception("A conta precisa ter mais de 5 caracteres");
        	}
        
        	if (conta.getDataLancamento() == null ) {
        		throw new Exception("Insira a data Lançamento");
        	}
        	if (conta.getDataLancamento().length() != 8) {
        		
        		throw new Exception("Insira uma data válida (formato: YYYYMMDD)");
        		
        	}
        	if (conta.getValor() == null || conta.getValor() <= 0) {
        		throw new Exception("Insira o valor");
        	}

        	if (conta.getTipoLancamento() == null /*|| dao.validaTipolancamento(conta.getTipoLancamento()) != null*/) {
        		throw new Exception("Insira o tipo Lançamento");
        	} 
        	
        	
    }
	
}
