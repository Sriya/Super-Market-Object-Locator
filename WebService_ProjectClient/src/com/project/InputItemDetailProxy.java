package com.project;

public class InputItemDetailProxy implements com.project.InputItemDetail {
  private String _endpoint = null;
  private com.project.InputItemDetail inputItemDetail = null;
  
  public InputItemDetailProxy() {
    _initInputItemDetailProxy();
  }
  
  public InputItemDetailProxy(String endpoint) {
    _endpoint = endpoint;
    _initInputItemDetailProxy();
  }
  
  private void _initInputItemDetailProxy() {
    try {
      inputItemDetail = (new com.project.InputItemDetailServiceLocator()).getInputItemDetail();
      if (inputItemDetail != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)inputItemDetail)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)inputItemDetail)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (inputItemDetail != null)
      ((javax.xml.rpc.Stub)inputItemDetail)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.project.InputItemDetail getInputItemDetail() {
    if (inputItemDetail == null)
      _initInputItemDetailProxy();
    return inputItemDetail;
  }
  
  public java.lang.String getItemName(java.lang.String name) throws java.rmi.RemoteException{
    if (inputItemDetail == null)
      _initInputItemDetailProxy();
    return inputItemDetail.getItemName(name);
  }
  
  
}