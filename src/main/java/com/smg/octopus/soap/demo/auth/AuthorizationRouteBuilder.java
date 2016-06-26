package com.smg.octopus.soap.demo.auth;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;

import com.smg.octopus.soap.demo.util.SmgException;

//https://github.com/cmoulliard/security-camel-cxf/blob/master/camel-cxf-jaas/src/main/java/com/redhat/fuse/example/camel/Enrich.java
public class AuthorizationRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		onException(CamelAuthorizationException.class).log(">> User not authorized").handled(true)
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						SmgException exception = new SmgException("User not authenticated");
						exchange.getOut().setFault(true);
						exchange.getOut().setBody(exception);
					}
				});
	}

}
