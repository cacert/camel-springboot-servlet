package com.smg.octopus.soap.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
	@RequestMapping(value = "/rs/hello")
	public String index() {
		return "Medisys:Hello from REST!";
	}
}
