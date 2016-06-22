package com.smg.octopus.soap.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import scala.annotation.meta.beanGetter;

@SpringBootApplication
class Application {
	private static final String CAMEL_URL_MAPPING = "/camel/*";
	private static final String CAMEL_SERVLET_NAME = "CamelServlet";

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
     }
		
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), CAMEL_URL_MAPPING);
		registration.setName(CAMEL_SERVLET_NAME);
		return registration;
	}
	
	
	@Bean
	public ServletRegistrationBean cxfServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new CXFServlet(), "/soap/*");
		registration.setName("cxfServlet");
		return registration;
	}
	
	@Bean
	Bus cxf() {
		return BusFactory.newInstance().createBus();
	}
	
	@Bean
	public SpringCamelContext camelContext(ApplicationContext applicationContext) throws Exception {
		SpringCamelContext camelContext = new SpringCamelContext(applicationContext);
		camelContext.addRoutes(routeBuilder());
		camelContext.addRoutes(pingPongRoute());
		return camelContext;
	}
	
	@Bean
	public RouteBuilder routeBuilder() {
		return new MyRouteBuilder();
	}
	@Bean
	public RouteBuilder pingPongRoute() {
		return new PingPongRoute();
	}
}