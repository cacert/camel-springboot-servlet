package com.smg.octopus.soap.demo;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="krd.targetNameSpace")
public interface PingPongService {

	@WebMethod
	public String ping(@WebParam(name = "ping") String ping);
	
	@WebMethod
	public void uploadPhoto(byte[] photo);

}
