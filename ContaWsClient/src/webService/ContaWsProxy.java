package webService;

public class ContaWsProxy implements webService.ContaWs {
  private String _endpoint = null;
  private webService.ContaWs contaWs = null;
  
  public ContaWsProxy() {
    _initContaWsProxy();
  }
  
  public ContaWsProxy(String endpoint) {
    _endpoint = endpoint;
    _initContaWsProxy();
  }
  
  private void _initContaWsProxy() {
    try {
      contaWs = (new webService.ContaWsServiceLocator()).getContaWsPort();
      if (contaWs != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contaWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contaWs)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contaWs != null)
      ((javax.xml.rpc.Stub)contaWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webService.ContaWs getContaWs() {
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs;
  }
  
  public webService.Conta[] listaWs(java.lang.String arg0) throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listaWs(arg0);
  }
  
  public webService.Conta[] listar() throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listar();
  }
  
  public void salvar(webService.Conta arg0) throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    contaWs.salvar(arg0);
  }
  
  
}