package com.jweb.sbb.user;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "thymeleaf/signup_form";
	}
	
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "thymeleaf/signup_form";
		}
		
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 비밀번호가 일치하지 않습니다.");
			
			return "signup_form";
		}
		
		try {
			userService.create(userCreateForm.getUsername(), 
					   		   userCreateForm.getEmail(), 
					   		   userCreateForm.getPassword1());
			
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다."); //중복 사용자 걸러내기
			
			return "signup_form";
			
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			
			return "signup_form";
		}
		
		
		return "redirect:/question/list";
	}
	
	/**
	 * Get으로 템플릿 렌더링만 처리.
	 * 실제 로그인인 Post는 스프링 시큐리티가 처리
	 * 
	 */
	@GetMapping("/login")
	public String login() {
		return "thymeleaf/login_form";
	}
	
	
	
	
	
}
