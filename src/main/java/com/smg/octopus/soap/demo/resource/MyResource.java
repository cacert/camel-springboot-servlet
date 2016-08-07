package com.smg.octopus.soap.demo.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MyResource {

	@Autowired
	@Value("classpath:abc.properties")
	private Resource myresource ;
	
	public void print() throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myresource.getInputStream()));
		String line ;
		while((line = bufferedReader.readLine())!=null){
			System.err.println(line);
		}
			
	}
}
