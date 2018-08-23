package webService;

import java.rmi.RemoteException;
import java.util.Scanner;

public class SoapRequest {
	
private static Scanner ent;

public static void main(String[] args) throws RemoteException {
	
		ContaWs client = new ContaWsProxy();
		int opcao;
		do {
		System.out.println("Escolha uma opção:"
				+ "\n(1) Pesquisar todas as contas "
				+ "\n(2) Pesquisar contas por id"
				+ "\n(3) Pesquisar contas por nome"
				+ "\n(4) Pesquisar contas por tipo lançamento"
				+ "\n(5) Pesquisar contas por data"
				+ "\n(6) Criar nova conta"
				+ "\n(7) Excluir conta"
				+ "\n(8) Alterar conta"
				+ "\n(9) Sair");
		
		ent = new Scanner(System.in);
		opcao = ent.nextInt();
		
		switch (opcao) {
		case 1:
			Conta[] contas = client.listar();
			
			for(Conta conta : contas) {
				
				System.out.println("Id: " +conta.getId());
				System.out.println("Nome: " + conta.getNome());
				System.out.println("Data Lançamento: " + conta.getDataLancamento());
				System.out.println("Tipo Lançamento: " + conta.getTipoLancamento());
				System.out.println("Valor: " + conta.getValor()+"\n");
			}

			break;
			
		case 2:
			
			System.out.println("\nDigite o ID da conta: \n");
			Scanner idConta = new Scanner(System.in);
			Integer id = idConta.nextInt();
			
			Conta conta = new Conta();
			conta = client.listarId(id);
			
			System.out.println("Id: " +conta.getId());
			System.out.println("Nome: " + conta.getNome());
			System.out.println("Data Lançamento: " + conta.getDataLancamento());
			System.out.println("Tipo Lançamento: " + conta.getTipoLancamento());
			System.out.println("Valor: " + conta.getValor()+"\n");
			
			
			
			break;
		case 3:	
			System.out.println("Digite o nome da conta: ");
			Scanner nomeConta = new Scanner(System.in);
			String nome = nomeConta.next();
			
			Conta[] contasN = client.listarNome(nome);
			
			for(Conta contaN : contasN) {
				
				System.out.println("Id: " + contaN.getId());
				System.out.println("Nome: " + contaN.getNome());
				System.out.println("Data Lançamento: " + contaN.getDataLancamento());
				System.out.println("Tipo Lançamento: " + contaN.getTipoLancamento());
				System.out.println("Valor: " + contaN.getValor() + "\n");
			}
			break;
		 case 4:
			 System.out.println("Digite o tipo lançamento: ");
				Scanner tLancamentoConta = new Scanner(System.in);
				int tipoLancamento = tLancamentoConta.nextInt();
				
				Conta[] contasTp = client.listaTipoLancamento(tipoLancamento);
				
				for(Conta contasTp1 : contasTp) {
					
					System.out.println("Id: " +  contasTp1.getId());
					System.out.println("Nome: " + contasTp1.getNome()); 
					System.out.println("Data Lançamento: " + contasTp1.getDataLancamento());
					System.out.println("Tipo Lançamento: " + contasTp1.getTipoLancamento());
					System.out.println("Valor: " + contasTp1.getValor() +"\n");
				}
			 
			 
			 break;
		  case 5:
			 System.out.println("Digite a data lancamento: ");
				Scanner data = new Scanner(System.in);
				String dataLancamento = data.next();
				
				Conta[] contasDt = client.listaDataLancamento(dataLancamento);
				
				for(Conta contasDt1 : contasDt) {
					
					System.out.println("Id: " + contasDt1.getId());
					System.out.println("Nome: " + contasDt1.getNome());
					System.out.println("Data Lançamento: " +  contasDt1.getDataLancamento());
					System.out.println("Tipo Lançamento: " + contasDt1.getTipoLancamento());
					System.out.println("Valor: " + contasDt1.getValor() +"\n");
				}
			 
			 
			 break; 
		  case 6:
				 System.out.println("Digite o nome da conta: ");
				 Scanner nomeC = new Scanner(System.in);
				 String nomeCont = nomeC.next();
				
				 System.out.println("Digite a data lancamento: ");
				 Scanner dataC = new Scanner(System.in);
				 String dataCont = dataC.next();
					
				 System.out.println("Digite o tipo lançamento: ");
				 Scanner tplC = new Scanner(System.in);
				 int tplCont = tplC.nextInt();
					
				 System.out.println("Digite o valor: ");
				 Scanner valorC = new Scanner(System.in);
				 double valorCont = valorC.nextDouble();
				 
				 Conta contaAlt = new Conta();
				 
				 contaAlt.setNome(nomeCont);
				 contaAlt.setDataLancamento(dataCont);
				 contaAlt.setTipoLancamento(tplCont);
				 contaAlt.setValor(valorCont);
				 
				client.salvar(contaAlt);
				
				if(contaAlt != null) {
					
					System.out.println("Salvo com sucesso");
				}
				
			 break;  
		  case 7:
				 System.out.println("Digite o id da conta que deseja excluir: ");
				 Scanner idE = new Scanner(System.in);
				 int idExcluir = idE.nextInt();
				
				 
				client.excluir(idExcluir);
				
				
			 break; 
		  case 8:
			  	
			  	 System.out.println("Digite o id da conta que deseja alterar: ");
				 Scanner idC = new Scanner(System.in);
				 int idCont = idC.nextInt();
			  	
			  	 System.out.println("Digite o nome da conta: ");
				 Scanner nomeCa = new Scanner(System.in);
				 String nomeContA = nomeCa.next();
				
				 System.out.println("Digite a data lancamento: ");
				 Scanner dataCa = new Scanner(System.in);
				 String dataContA = dataCa.next();
					
				 System.out.println("Digite o tipo lançamento: ");
				 Scanner tplCa = new Scanner(System.in);
				 int tplContA = tplCa.nextInt();
					
				 System.out.println("Digite o valor: ");
				 Scanner valorCa = new Scanner(System.in);
				 double valorContA = valorCa.nextDouble();
				 
				 Conta contaAltA = new Conta();
				 contaAltA.setId(idCont);
				 
				 contaAltA.setNome(nomeContA);
				 contaAltA.setDataLancamento(dataContA);
				 contaAltA.setTipoLancamento(tplContA);
				 contaAltA.setValor(valorContA);
				 
				client.alterar(contaAltA);
				
				
			 break;  
		  	case 9 :
	            System.exit(0);
	            break; 
		
		}
		
		}while (opcao != 9);
	}

}
