package com.jweb.sbb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jweb.sbb.question.Question;
import com.jweb.sbb.question.QuestionRepository;

import lombok.RequiredArgsConstructor;





/**
 * @RequiredArgsConstructor
 * @author 바이텍씨스템
 *	
 * questionRepository 속성을 포함하는 생성자를 생성
 * @RequiredArgsConstructor는 롬복이 제공하는 애너테이션으로 final이 붙은 속성을 포함하는 생성
 * 자를 자동으로 생성하는 역할을 한다. 롬복의 @Getter, @Setter가 자동으로 Getter, Setter 메서드를 생성
 * 하는 것과 마찬가지로 @RequiredArgsConstructor는 자동으로 생성자를 생성한다. 따라서 스프링 의존성
 * 주입 규칙에 의해 questionRepository 객체가 자동으로 주입된다.
 * 
 * 의존성 주입 방법 중 생성자를 작성하여 객체를 주입하는 방식에 해당된다 (자동으로 객체 lombok이 생성해줌)
 * 
 */

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	/**
	 * @author 박재식
	 * 
	 * 스프링빈 등록이 계속 안 됐었는데, 결국 패키지 디렉토리 문제였음.
	 * Lombok이나 생성자 주입 등 다 잘 됐음.
	 */
	private final QuestionRepository questionRepository;
	
	@GetMapping("/question/list")
	//@ResponseBody
	public String list(Model model) {
		List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
	}
	
	/*
	@GetMapping("/question/list")
	//@ResponseBody
	public String list() {
		return "question_list";
	}
	*/
	
	
}
