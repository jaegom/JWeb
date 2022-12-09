package com.jweb.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JWebController {

	/**
	 * 
	 */
	public JWebController() {
		super();
		System.out.println("--JWeb Constructor Generated--");
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/sbb")
	@ResponseBody
	public String index() {
		return "Hello World";
	}
	
	

}
