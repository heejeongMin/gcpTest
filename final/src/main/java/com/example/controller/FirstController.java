package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@GetMapping(value = "/")
	public String hello () {
		return "과장님 이제 되요 ㅠㅠ ";
	}
	
	@GetMapping(value = "/ssh")
	public String ssh() {
		return "from ssh";
	}

}
