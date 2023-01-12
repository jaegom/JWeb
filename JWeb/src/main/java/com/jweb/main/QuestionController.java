package com.jweb.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {
	
	public QuestionController() {
		System.out.println("QuestionController() 객체 생성됨.");
	}
	
	
	
	@GetMapping("/question/list")
	@ResponseBody
	public String list() {
		return "question list";
	}
	
}
