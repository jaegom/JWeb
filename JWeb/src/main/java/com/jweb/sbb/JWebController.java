package com.jweb.sbb;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class JWebController {

	/**
	 * 
	 */
	
	/* lombok으로 대체
	 * 
	public JWebController() {
		super();
		System.out.println("---JWeb Constructor Generated--");
		// TODO Auto-generated constructor stub
	}
	*/
	
	/*
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World Spring Boot";
	}
	*/
	
	/*
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		// application.properties에 명시해놓은 
		// /WEB-INF/views/index.jsp
		mav.setViewName("index");
		mav.addObject("message", "어서오시게");

		return mav;
	}
	*/
	
	@GetMapping("/")
	public String home() {
		
		
		
		/* return "thymeleaf/question_list";
		 * 비어있는 상태에서 view를 return하라고 했기 때문에..
		 * org.springframework.expression.spel.SpelEvaluationException: EL1011E: Method
		 * call: Attempted to call method isEmpty() on null context object
		 */
		
		return "redirect:/question/list";
	}
	

}
