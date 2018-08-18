package webService;

import java.rmi.RemoteException;

public class TesteRequestSoap {

	public static void main(String[] args) throws RemoteException {

		ContaWs client = new ContaWsProxy();
		
		Conta[] contas = client.listar();
		
		for(Conta conta : contas) {
			
			System.out.println(conta.getId());
			System.out.println(conta.getNome());
			
		}

	}

}
