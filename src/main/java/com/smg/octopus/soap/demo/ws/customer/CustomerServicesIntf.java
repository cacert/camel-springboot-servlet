package com.smg.octopus.soap.demo.ws.customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.smg.octopus.soap.demo.ws.BasicWebRequest;

@WebService(targetNamespace="mms.targetNameSpace")
public interface CustomerServicesIntf {

	@WebMethod
	public Customer createCustomer(BasicWebRequest bwr,@WebParam(name = "custInfo") CustomerInfo info);
	
	@WebMethod
	public void uploadPhotoCustomer(byte[] photo);

}
