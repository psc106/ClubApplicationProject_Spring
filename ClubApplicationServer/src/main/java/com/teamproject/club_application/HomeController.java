package com.teamproject.club_application;

import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.data.TestData;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home() {		
		return "home";
	}
	
	@RequestMapping("home.do")
	public String home2() {		
		return "home";
	}
	
	@RequestMapping(value="androidTest.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String testJson(HttpServletRequest request) {
				
		iDao iDAO = sqlSession.getMapper(iDao.class);
		ArrayList<TestData> items = iDAO.getTestData();
		
		Gson gson = new Gson();
		System.out.println("Å×½ºÆ®");		
		System.out.println(gson.toJson(items).toString());
		
		return gson.toJson(items);
	}

	public String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
