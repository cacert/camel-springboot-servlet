package com.smg.octopus.soap.demo.ws;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

@Component
public class OctopusLoggingInterceptor extends LoggingInInterceptor {

	public OctopusLoggingInterceptor() {
		super(Phase.PRE_STREAM);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		if(true)
			super.handleMessage(message);
	}
}
