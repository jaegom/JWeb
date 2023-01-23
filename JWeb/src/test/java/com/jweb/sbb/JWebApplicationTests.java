package com.jweb.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//QuestionRepository가 Question 객체를 조회하고 DB 세션이 바로 끊기지 않도록..
import javax.transaction.Transactional; 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jweb.sbb.JWebApplication;
import com.jweb.sbb.answer.Answer;
import com.jweb.sbb.answer.AnswerRepository;
import com.jweb.sbb.question.Question;
import com.jweb.sbb.question.QuestionRepository;
import com.jweb.sbb.question.QuestionService;



@SpringBootTest(classes = JWebApplication.class)
class JWebApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testJpa() {
		
		for (int i = 1; i <= 10; i++) {
	        String subject = String.format("테스트 데이터입니다:[%03d]", i);
	        String content = "내용무";
	        this.questionService.create(subject, content);
	    }
	}
		/* 질문등록
		 * 
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장
        
        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
        */
		
		
		/* 질문의 개수가 2개인가?
		 * 
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
		*/
        
		/* id가 2인 질문 찾기
		 * 
        Optional<Question> oq = this.questionRepository.findById(2);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("스프링부트 모델 질문입니다.", q.getSubject()); //getSubject -> lombok.. 따로 getter setter를 만든 적이 없음.
            
        }
		*/
		
		/**QuestionRepository 인터페이스 수정..QuestionRepository는 findBySuject 함수를 내장하지 않음.
		*	그럼 인터페이스만 만들고 구현은 안 했는데 어떻게 작동하는가?
		*	JpaRepository를 상속한 QuestionRepository가 생성될 때 (DI에 의해 스프링이 자동으로 생성) 
		*
		*/
		
		/* subject로 질문 찾기
		 * 
	    Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?"); 
        assertEquals(1, q.getId());
		*/
		
		
		/* subject와 content로 찾기
		 * 
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
        
		*/
		
		
		/* 질문 리스트에서 특정 문자열을 포함한 제목인 질문을 찾기
		 * 
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
      
      //Question은 일종의 DTO이며.. getter와 setter를 설정하지 않아도 자동으로 conventional naming으로 getter 만들어줌.
        assertEquals("sbb가 무엇인가요?", q.getSubject()); 
		*/
		
		
		/**
		 * 데이터 수정
		Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent()); //true인지 테스트
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q); //엔티티를 저장
		*/
		
		/**
		 * 데이터 삭제
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent()); //JUnit 테스트용 함수
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());	
		
		*/
		
		/* 
		 * 답변 생성
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q); //어떤 질문의 답변인지 알기 위해 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
		*/
		
		/*
		 * 
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();//id가 1인 Answer 객체 받아옴
        assertEquals(2, a.getQuestion().getId());
		
		*/
		
		/*
		Optional<Question> oq = this.questionRepository.findById(2);
		 assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		*/
		
		
	}
	
	


















