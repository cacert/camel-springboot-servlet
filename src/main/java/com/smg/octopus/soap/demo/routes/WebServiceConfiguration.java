package com.smg.octopus.soap.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfiguration {
	
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
    	SpringBus springBus = new SpringBus();
//    	springBus.getInFaultInterceptors().add( new org.apache.cxf.interceptor.LoggingInInterceptor());
//    	springBus.getInInterceptors().add( new org.apache.cxf.interceptor.LoggingInInterceptor());
        return  springBus;
    } 
    
	@Bean
	public RouteBuilder webServiceRoute(SpringCamelContext context ) throws Exception {
		WebServiceRoute route = new WebServiceRoute();
		context.addRoutes(route);
		return route;
	}
	
}
