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
  
  public webService.Conta[] listaDataLancamento(java.lang.String arg0) throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listaDataLancamento(arg0);
  }
  
  public webService.Conta[] listar() throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listar();
  }
  
  public webService.Conta listarId(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listarId(arg0);
  }
  
  public webService.Conta[] listarNome(java.lang.String arg0) throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listarNome(arg0);
  }
  
  public webService.Conta[] listaTipoLancamento(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.listaTipoLancamento(arg0);
  }
  
  public void excluir(java.lang.Integer arg0) throws java.rmi.RemoteException, webService.Exception{
    if (contaWs == null)
      _initContaWsProxy();
    contaWs.excluir(arg0);
  }
  
  public webService.Conta alterar(webService.Conta arg0) throws java.rmi.RemoteException, webService.Exception{
    if (contaWs == null)
      _initContaWsProxy();
    return contaWs.alterar(arg0);
  }
  
  public void salvar(webService.Conta arg0) throws java.rmi.RemoteException, webService.Exception{
    if (contaWs == null)
      _initContaWsProxy();
    contaWs.salvar(arg0);
  }
  
  
}