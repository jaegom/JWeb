package com.jweb.bbs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BbsController {
	
	public BbsController() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("---BbsController() 객체 생성됨.");
	}
	
	
	//form에서는 post방식으로 호출 가능. GET, POST 선택할 수 있다.
	
	//@RequestMapping(value = "/bbs/create.do", method = RequestMethod.GET)
	//결과확인 http://localhost:9096/bbs/create.do
	//GET방식은 URL에 직접 쓰라는 것이에요.
	/* 1)
	public ModelAndView bbsForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bbs/bbsForm"); //  /WEB-INF/views/bbs/bbsForm.jsp
		
		return mav;
	} //bbsForm() end
	*/
	
	//2) 위의 1번과 동일하게 페이지 이동 가능하다
	
	/*
	public String bbsForm() {
		return "bbs/bbsForm"; //  /WEB-INF/views/bbs/bbsForm.jsp
	}
	*/
	
	//동일한 요청명령어를 GET | POST 방식으로 분리해서 호출 가능하다.
	
	//@RequestMapping(value ="/bbs/create.do", method=RequestMethod.POST)
	/*1)
		public ModelAndView bbsIns(HttpServletRequest req) {
			
		//요청 정보 가져오기
		String wname = req.getParameter("wname").trim();
		String subject = req.getParameter("subject").trim();
		String content = req.getParameter("content").trim();
		String passwd = req.getParameter("passwd").trim();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/bbsResult");
		
		mav.addObject("wname", wname);
		mav.addObject("subject", subject);
		mav.addObject("content", content);
		mav.addObject("passwd", passwd);

		return mav;

	} // bbsIns() end
	*/
	
	// 2) 매개변수(parameter)가 DTO 객체인 경우
	// ->해당클래스(BbsDTO)에 반드시 폼 컨트롤 요소이름(wname)으로 되어 있는 멤버변수와 각 getter(getWname)와 setter(setWname)함수가 있어야 한다
	// ->예를 들어 <input type=text name=wname>와 private String wname의 이름이 동일해야 한다
	// 하단의 작업을 한 줄에 끝낼 수 있다.
	
	
	
	/*
	
	public ModelAndView bbsIns(@ModelAttribute BbsDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/bbsResult2");
		mav.addObject("dto", dto);
		return mav;
	}// bbsIns() end
	
	*/
	
} 

//class end


/*
	String wname   = request.getParameter("wname").trim();
	String subject = request.getParameter("subject").trim();
	String content = request.getParameter("content").trim();
	String passwd  = request.getParameter("passwd").trim();
	String ip	   =request.getRemoteAddr();//요청PC의 IP

	
	//dto 객체에 담기
	dto.setWname(wname);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPasswd(passwd); 
	dto.setIp(ip);
	
 * 
 * */


