package com.jweb.sbb;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World Spring Boot";
	}
	
	
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		// application.properties에 명시해놓은 
		// /WEB-INF/views/index.jsp
		mav.setViewName("index");
		mav.addObject("message", "어서오시게");

		return mav;		
	}
	
	

}
