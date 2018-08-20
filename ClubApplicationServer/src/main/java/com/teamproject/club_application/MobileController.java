package com.teamproject.club_application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.authorized.MailService;
import com.teamproject.club_application.data.Alarm;
import com.teamproject.club_application.data.CalendarSchedule;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.Comment;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.Schedule;
import com.teamproject.club_application.data.TestData;

@Controller
public class MobileController {
	SqlSession sqlSession;
	
	@Resource(name="MailAuthService")
	MailService service;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@RequestMapping(value="androidTest.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String testJson() {
		iDao dao = sqlSession.getMapper(iDao.class);
				
		ArrayList<TestData> items = dao.getTestData();
		
		Gson gson = new Gson();
		System.out.println("테스트");		
		System.out.println(gson.toJson(items).toString());
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectLoginUser.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectLoginUser_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("pw");		
		Gson gson = new Gson();
		
		Member item = dao.selectLoginUser(loginId, loginPw);
		
		System.out.println(gson.toJson(item));
		
		return gson.toJson(item);
	}

	@RequestMapping(value="mobile/checkId.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String checkId_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String id = request.getParameter("id");
		Gson gson = new Gson();
				
		Integer item = dao.checkId(id);
				
		return gson.toJson(item);
	}

	@RequestMapping(value="mobile/selectMyAlarm.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyAlarm_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
				
		ArrayList<Alarm> items = dao.selectMyAlarm(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMyPost.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyPost_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
				
		ArrayList<Post> items = dao.selectMyPost(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMyComment.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyComment_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
				
		ArrayList<Comment> items = dao.selectMyComment(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMySchedule.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMySchedule_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
		
		ArrayList<Schedule> items = dao.selectMySchedule(userId);
		
		return gson.toJson(items);
	}

	@RequestMapping(value="mobile/selectMyCalendar.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyCalendar_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String userIdStr = request.getParameter("userId");
		String yearStr = request.getParameter("year");
		String monthStr = request.getParameter("month");
		Long userId;
		Integer year;
		Integer month;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}

		if(yearStr!=null) {
			year = Integer.parseInt(yearStr);
		} else {
			return gson.toJson(null);
		}

		if(monthStr!=null) {
			month = Integer.parseInt(monthStr);
		} else {
			return gson.toJson(null);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		int maxDay = cal.getActualMaximum(Calendar.DATE);
		ArrayList<CalendarSchedule> realItems = new ArrayList<CalendarSchedule>();
		String dateFormat = null;
		for(int i = 1  ; i <= maxDay; ++i) {
			cal.set(Calendar.DATE, i);
			dateFormat = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
			ArrayList<Schedule> tmpItems = dao.selectMyDaySchedule(userId, dateFormat);
			CalendarSchedule calendarSchedule = new CalendarSchedule(dateFormat, tmpItems);
			realItems.add(calendarSchedule);
		}		
		return gson.toJson(realItems);
	}

	@RequestMapping(value="mobile/selectMyGroup.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyGroup_toMobile(HttpServletRequest request) {
		iDao dao = sqlSession.getMapper(iDao.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();
		
		if(userIdStr!=null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
				
		ArrayList<Club> items = dao.selectMyClub(userId);
		
		return gson.toJson(items);
	}
	

	@RequestMapping(value="mobile/insertMember.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String insertMember_toMobile(HttpServletRequest request) {
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String genderStr = request.getParameter("gender");
		String local = request.getParameter("local");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int gender;
		Gson gson = new Gson();
		if(genderStr!=null) {
			gender = Integer.parseInt(genderStr);
		} else {
			return gson.toJson("fail");
		}
		Member member = new Member(-1, loginId, loginPw, name, birthday, gender, local, email, phone, "N");
		service.authCreate(member);

		return gson.toJson("");
	}
	

	@RequestMapping(value="mobile/findId.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String findId_toMobile(HttpServletRequest request) {
		System.out.println("들어온다");
		iDao dao = sqlSession.getMapper(iDao.class);
		String email = request.getParameter("email");
		
		Gson gson = new Gson();
		String id = dao.selectFindId(email);
		System.out.println(id);

		return gson.toJson(id);
	}

	@RequestMapping(value="mobile/findPw.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String findPw_toMobile(HttpServletRequest request) {
		String id = request.getParameter("id");
		String email = request.getParameter("email");

		service.findPw(email, id);

		Gson gson = new Gson();
		return gson.toJson("");
	}
}
