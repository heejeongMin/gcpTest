package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}
	
	@GetMapping(value = "/")
	public String hello () {
		return "hello!";
	}
	
	@GetMapping(value = "/ssh")
	public String ssh() {
		return "from ssh";
	}
	
	

}
