package com.teamproject.club_application;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.data.Alarm;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.Comment;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.Schedule;
import com.teamproject.club_application.data.TestData;

@Controller
public class MobileController {
	SqlSession sqlSession;
	iDao iDAO = sqlSession.getMapper(iDao.class);
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	

	@RequestMapping(value="androidTest.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String testJson() {
				
		ArrayList<TestData> items = iDAO.getTestData();
		
		Gson gson = new Gson();
		System.out.println("Å×½ºÆ®");		
		System.out.println(gson.toJson(items).toString());
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectLoginUser.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectLoginUser_toMobile(HttpServletRequest request) {
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("pw");		
		Gson gson = new Gson();
		
		Member item = iDAO.selectLoginUser(loginId, loginPw);
		
		return gson.toJson(item);
	}

	@RequestMapping(value="mobile/checkId.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String checkId_toMobile(HttpServletRequest request) {
		String id = request.getParameter("id");
		Gson gson = new Gson();
				
		Integer item = iDAO.checkId(id);
				
		return gson.toJson(item);
	}

	@RequestMapping(value="mobile/selectMyAlarm.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyAlarm_toMobile(HttpServletRequest request) {
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(-1L);
		}
				
		ArrayList<Alarm> items = iDAO.selectMyAlarm(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMyPost.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyPost_toMobile(HttpServletRequest request) {
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(-1L);
		}
				
		ArrayList<Post> items = iDAO.selectMyPost(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMyComment.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyComment_toMobile(HttpServletRequest request) {
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(-1L);
		}
				
		ArrayList<Comment> items = iDAO.selectMyComment(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMySchedule.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMySchedule_toMobile(HttpServletRequest request) {
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(-1L);
		}
		
		ArrayList<Schedule> items = iDAO.selectMySchedule(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMyGroup.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyGroup_toMobile(HttpServletRequest request) {
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(-1L);
		}
				
		ArrayList<Club> items = iDAO.selectMyClub(userId);
		
		return gson.toJson(items);
	}
	
}
