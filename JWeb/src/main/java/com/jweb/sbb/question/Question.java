package com.jweb.sbb.question;

import java.time.LocalDateTime;  
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jweb.sbb.answer.Answer;
import com.jweb.sbb.user.SiteUser;

/*
 * 스프링 3.0.0 버전
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
*/

import lombok.Getter;
import lombok.Setter;


/**
 * 데이터베이스에서는 id와 같은 특징을 가진 속성을 기본 키(primary key)라고 한다.
 * 
 * @GeneratedValue 애너테이션을 적용하면 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여
 * 저장된다. strategy는 고유번호를 생성하는 옵션으로 GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여
 * 번호를 증가시킬 때 사용한다.
 */


@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    
    @ManyToOne
    private SiteUser author;
    
    private LocalDateTime modifyDate;
}