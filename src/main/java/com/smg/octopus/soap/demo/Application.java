package com.smg.octopus.soap.demo;

import java.io.IOException;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.smg.octopus.soap.demo.resource.MyResource;

@SpringBootApplication
public class Application {

	@Autowired
	private MyResource resource;
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean
	public SpringCamelContext camelContext(ApplicationContext applicationContext) throws Exception {
		SpringCamelContext camelContext = new SpringCamelContext(applicationContext);
		return camelContext;
	}

	@Bean
	public String printIt() throws IOException{
		resource.print();
		return "kasim";
	}
}