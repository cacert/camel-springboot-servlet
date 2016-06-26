package com.smg.octopus.soap.demo.ws.credit;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.smg.octopus.soap.demo.ws.BasicWebRequest;

@WebService(targetNamespace="krd.targetNameSpace")
public interface CreditServiceIntf {

	@WebMethod
	public CreditScoreOutput checkScore(BasicWebRequest bwr, @WebParam(name = "creditInput") CreditScoreInput creditInput);


}
