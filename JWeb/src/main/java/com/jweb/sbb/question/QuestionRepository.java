package com.jweb.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



/**
 * @author 바이텍씨스템
 *	QuestionRepository는 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속했다. JpaRepository를 상속할 때는 제네릭스
 *	타입으로 <Question, Integer> 처럼 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입
 *	(Integer)을 지정해야 한다. 이것은 JpaRepository를 생성하기 위한 규칙이다.
 */



//실제로 사용하려면 객체를 생성하여 함수들을 정의해야하지만, 스프링부트가 알아서 만들어줌 (DI)
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	 Question findBySubject(String subject);
	 Question findBySubjectAndContent(String subject, String content);
	 List<Question> findBySubjectLike(String subject);
	 Page<Question> findAll(Pageable pageable);
	 Page<Question> findAll(Specification<Question> spec, Pageable pageable);
	 
	 @Query("select "
	            + "distinct q "
	            + "from Question q " 
	            + "left outer join SiteUser u1 on q.author=u1 "
	            + "left outer join Answer a on a.question=q "
	            + "left outer join SiteUser u2 on a.author=u2 "
	            + "where "
	            + "   q.subject like %:kw% "
	            + "   or q.content like %:kw% "
	            + "   or u1.username like %:kw% "
	            + "   or a.content like %:kw% "
	            + "   or u2.username like %:kw% ")
	    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
	
}
