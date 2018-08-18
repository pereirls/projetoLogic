/**
 * ContaWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webService;

public interface ContaWs extends java.rmi.Remote {
    public webService.Conta[] listaWs(java.lang.String arg0) throws java.rmi.RemoteException;
    public webService.Conta[] listar() throws java.rmi.RemoteException;
    public void salvar(webService.Conta arg0) throws java.rmi.RemoteException;
}
