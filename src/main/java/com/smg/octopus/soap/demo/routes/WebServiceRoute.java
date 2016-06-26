package com.smg.octopus.soap.demo.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;

import com.smg.octopus.soap.demo.auth.AuthenticationBean;
import com.smg.octopus.soap.demo.ws.OctopusLoggingInterceptor;
import com.smg.octopus.soap.demo.ws.credit.CreditServiceIntf;


public class WebServiceRoute extends RouteBuilder {

	@Autowired
	private OctopusLoggingInterceptor interceptor;
	
	@Override
	public void configure() throws Exception {

		CxfEndpoint credit = new CxfEndpoint();
		credit.setAddress("/credit");
		credit.setServiceClass(CreditServiceIntf.class);
		credit.setDataFormat(DataFormat.POJO);
		credit.getInFaultInterceptors().add(new OctopusLoggingInterceptor());
		credit.getInInterceptors().add(new OctopusLoggingInterceptor());
		getContext().addEndpoint("creditService", credit);
		
		from(credit)
		.to("log:" + getClass().getName()+"?showHeaders=true")
		.bean(AuthenticationBean.class,"authenticate")
		.convertBodyTo(String.class)
		.process(new Processor() {
			@Override
			public void process(Exchange e) throws Exception {
				String pingRequest = e.getIn().getBody(String.class);   
				e.getIn().setBody(new Object[] { "Pong: " + pingRequest });
			}
		});
		
//		from("cxf:/CreditServices?serviceClass=" + CreditServiceIntf.class.getName())
//			.to("log:" + getClass().getName()+"?showHeaders=true")
//			.bean(AuthenticationBean.class,"authenticate")
//			.convertBodyTo(String.class)
//			.process(new Processor() {
//				@Override
//				public void process(Exchange e) throws Exception {
//					String pingRequest = e.getIn().getBody(String.class);   
//					e.getIn().setBody(new Object[] { "Pong: " + pingRequest });
//				}
//			});
//		
//		from("cxf:/CustomerServices?serviceClass=" + CustomerServicesIntf.class.getName())
//			.to("log:" + getClass().getName()+"?showHeaders=true")
//			.bean(AuthenticationBean.class,"authenticate")
//			.convertBodyTo(String.class)
//			.process(new Processor() {
//				@Override
//				public void process(Exchange e) throws Exception {
//					String pingRequest = e.getIn().getBody(String.class);   
//					e.getIn().setBody(new Object[] { "Pong: " + pingRequest });
//				}
//			});
	}
}
