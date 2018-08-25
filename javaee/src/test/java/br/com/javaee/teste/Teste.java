package br.com.javaee.teste;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.javaee.beans.ContaBean;
import br.com.javaee.dao.ContaDao;
import br.com.javaee.models.Conta;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(Arquillian.class)
public class Teste {
	
	@Inject
	private ContaBean bean;
	
	private Conta conta;
	
	@Deployment
    public static JavaArchive criarArquivoTeste() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(ContaBean.class,
                        ContaDao.class,
                        Conta.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

	public Teste() {

        conta = new Conta();
        conta.setNome("Teste");
        conta.setDataLancamento("20180824");
        conta.setValor(999.99);
        conta.setTipoLancamento(1);

    }  
	
	@Test
    @InSequence(1)
    public void testeListarTodas() throws Exception {

        List<Conta> contas = new ArrayList<>();
        conta = bean.salvar(conta);
        contas = bean.listar();

        bean.excluir(conta.getId());
        Assert.assertTrue(contas.size() > 0);

    }
	
	@Test
    @InSequence(2)
    public void testeListarId() throws Exception {

        conta = bean.salvar(conta);
        Conta contaRetorno = bean.listarId(conta.getId());

        bean.excluir(conta.getId());
        Assert.assertTrue(contaRetorno.getNome().equals(conta.getNome()));

    }

	@Test
    @InSequence(3)
    public void testeListaNome() throws Exception {

        List<Conta> contas = new ArrayList<>();
        conta = bean.salvar(conta);
        contas = bean.listarNome(conta.getNome());

        boolean validaConta = false;
        for (Conta c : contas) {
            if (c.getId().equals(conta.getId())) {
            	validaConta = true;
            }
        }

        bean.excluir(conta.getId());
        Assert.assertTrue(validaConta);

    }
	
	
    @Test
    @InSequence(4)
    public void testeListTipoLancamento() throws Exception {

        List<Conta> contas = new ArrayList<>();
        conta = bean.salvar(conta);
        contas = bean.listTipoLancamento(conta.getTipoLancamento());
        boolean valida = false;

        for (Conta c : contas) {
            if (c.getId().equals(conta.getId())) {
                valida = true;
            }
        }

        bean.excluir(conta.getId());
        Assert.assertTrue(valida);

    }

    @Test
    @InSequence(5)
    public void testeListPeriodo() throws Exception {

        List<Conta> contas = new ArrayList<>();
        conta = bean.salvar(conta);
        String dataInicial = "20180824";
        String dataFinal = "20180824";
        
        contas = bean.listaData(dataInicial,dataFinal);

        boolean validaData = false;
        for (Conta c : contas) {
            if (c.getId().equals(conta.getId())) {
            	validaData = true;
            }
        }

        bean.excluir(conta.getId());
        Assert.assertTrue(validaData);

    }
    
    @Test
	@InSequence(6)
	    public void testeSalvar() throws Exception {

	        try {

	            conta = bean.salvar(conta);

	            bean.excluir(conta.getId());
	            Assert.assertTrue(conta.getId() > 0);

	        } catch (Exception ex) {
	           throw ex;
	        }

	    }
	
	@Test
    @InSequence(7)
    public void testeExcluir() throws Exception {

        conta = bean.salvar(conta);

        bean.excluir(conta.getId());
        Assert.assertTrue(conta.getId() > 0);

    }
	
	@Test
    @InSequence(8)
    public void testeUpdate() throws Exception {

        String nome = "Atualizado";
        conta = bean.salvar(conta);
        
        conta.setNome(nome);
        
        bean.alterar(conta);
        
        Conta contaAtualizada = bean.listarId(conta.getId());
        bean.excluir(conta.getId());
        Assert.assertTrue(contaAtualizada.getNome().equals(nome));

    }
	   
}
