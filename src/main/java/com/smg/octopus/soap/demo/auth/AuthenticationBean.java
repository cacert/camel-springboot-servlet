package com.smg.octopus.soap.demo.auth;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;

import com.smg.octopus.soap.demo.ws.BasicWebRequest;

public class AuthenticationBean {

	public void authenticate(BasicWebRequest bwr,Exchange exchange) throws CamelAuthorizationException{
		if(bwr == null || !"kasim".equals(bwr.getUserName()))
			throw new CamelAuthorizationException("user is not authenticated",exchange);
	}
}


