/**
 * ContaWsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webService;

public class ContaWsServiceLocator extends org.apache.axis.client.Service implements webService.ContaWsService {

    public ContaWsServiceLocator() {
    }


    public ContaWsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContaWsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContaWsPort
    private java.lang.String ContaWsPort_address = "http://localhost:8080/javaee/ContaWs";

    public java.lang.String getContaWsPortAddress() {
        return ContaWsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContaWsPortWSDDServiceName = "ContaWsPort";

    public java.lang.String getContaWsPortWSDDServiceName() {
        return ContaWsPortWSDDServiceName;
    }

    public void setContaWsPortWSDDServiceName(java.lang.String name) {
        ContaWsPortWSDDServiceName = name;
    }

    public webService.ContaWs getContaWsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContaWsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContaWsPort(endpoint);
    }

    public webService.ContaWs getContaWsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webService.ContaWsServiceSoapBindingStub _stub = new webService.ContaWsServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getContaWsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContaWsPortEndpointAddress(java.lang.String address) {
        ContaWsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webService.ContaWs.class.isAssignableFrom(serviceEndpointInterface)) {
                webService.ContaWsServiceSoapBindingStub _stub = new webService.ContaWsServiceSoapBindingStub(new java.net.URL(ContaWsPort_address), this);
                _stub.setPortName(getContaWsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ContaWsPort".equals(inputPortName)) {
            return getContaWsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webService/", "ContaWsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webService/", "ContaWsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContaWsPort".equals(portName)) {
            setContaWsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
