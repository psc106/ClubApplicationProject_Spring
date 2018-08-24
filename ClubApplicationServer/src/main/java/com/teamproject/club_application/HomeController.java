package com.teamproject.club_application;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.authorized.MailService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController{
	SqlSession sqlSession;
	
	@Resource(name="MailAuthService")
	MailService service;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home() {	
		int a=1;
		return "home";
	}
	
	@RequestMapping(value="/authOk.do", method=RequestMethod.GET)
	public String authMember(HttpServletRequest request) {
		String id = request.getParameter("login_id");
		String key = request.getParameter("key");
		
		boolean isSuccess = service.authUpdate(id, key);
		
		if(isSuccess) {	
			//인증 성공
			return "success";
		} else {
			//인증 실패
			return "fail";
		}
	}
}
