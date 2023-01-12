package com.jweb.main;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @author 바이텍씨스템
 *	QuestionRepository는 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속했다. JpaRepository를 상속할 때는 제네릭스
 *	타입으로 <Question, Integer> 처럼 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입
 *	(Integer)을 지정해야 한다. 이것은 JpaRepository를 생성하기 위한 규칙이다.
 */

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	
	
	
}
