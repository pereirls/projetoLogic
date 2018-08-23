/**
 * ContaWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webService;

public interface ContaWs extends java.rmi.Remote {
    public webService.Conta[] listaDataLancamento(java.lang.String arg0) throws java.rmi.RemoteException;
    public webService.Conta[] listar() throws java.rmi.RemoteException;
    public webService.Conta listarId(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public webService.Conta[] listarNome(java.lang.String arg0) throws java.rmi.RemoteException;
    public webService.Conta[] listaTipoLancamento(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void excluir(java.lang.Integer arg0) throws java.rmi.RemoteException, webService.Exception;
    public webService.Conta alterar(webService.Conta arg0) throws java.rmi.RemoteException, webService.Exception;
    public void salvar(webService.Conta arg0) throws java.rmi.RemoteException, webService.Exception;
}
