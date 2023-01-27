package com.jweb.sbb.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	@RequestMapping("/hello")
	public String hell() {
		return "Hello REST!!";
	}
}
