package com.jweb.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jweb.main.Answer;
import com.jweb.main.AnswerRepository;
import com.jweb.main.JWebApplication;
import com.jweb.main.Question;
import com.jweb.main.QuestionRepository;

@SpringBootTest(classes = JWebApplication.class)
class JWebApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		/*
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
		
		
		/*
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
		*/
        
		/*
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
		
		/*
	    Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?"); 
        assertEquals(1, q.getId());
		*/
		
		
		/*
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
        
		*/
		
		
		/*
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
		
		
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q); //어떤 질문의 답변인지 알기 위해 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
		
	}

}

















