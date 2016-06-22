package com.smg.octopus.soap.demo;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		// Access us using http://localhost:8080/camel/hello
		from("servlet:///hello").to("log:DEBUG?showBody=true&showHeaders=true").transform().constant("Medisys:Hello from Camel!");
		
		// Trigger run right after startup. No Servlet request required.
		from("timer://foo?fixedRate=true&period=10s").log("Medisys:Camel timer triggered.");
	}
}
