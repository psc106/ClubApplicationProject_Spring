package com.teamproject.club_application;

import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/home.do")
	public String home2() {		
		return "home";
	}	
	//로그인////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("login.do")
	public String login() {		
		return "login";
	}
	
	@RequestMapping("login_ok.do")
	public String login_ok(HttpServletRequest request) {
		String login_id = request.getParameter("login_mail");
		String login_pw = request.getParameter("login_pw");
		
		iDao iDAO = sqlSession.getMapper(iDao.class);
		
		
		return "login"; 
	}
	
	//로그인 끝////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("search.do")
	public String search() {		
		return "search";
	}
	
	@RequestMapping("make_club.do")
	public String makeClub() {		
		return "make_club";
	}
	
	@RequestMapping("my_schedule.do")
	public String mySchedule() {		
		return "my_schedule";
	}
	
	@RequestMapping("my_write.do")
	public String myWrite() {		
		return "my_write";
	}
	
	@RequestMapping("my_club.do")
	public String myClub() {		
		return "my_club";
	}
	
	@RequestMapping("my_info.do")
	public String myInfo() {		
		return "my_info";
	}
	
	@RequestMapping("myclub_board.do")
	public String myclub_board() {		
		return "myclub_board";
	}
	
	@RequestMapping("myclub_write.do")
	public String myclub_write() {		
		return "myclub_write";
	}
	
	@RequestMapping("myclub_album.do")
	public String myclub_album() {		
		return "myclub_album";
	}
	
	@RequestMapping("myclub_calendar.do")
	public String myclub_calendar() {		
		return "myclub_calendar";
	}
	
	@RequestMapping("myclub_setting.do")
	public String myclub_setting() {		
		return "myclub_setting";
	}
	
	@RequestMapping("myclub_member.do")
	public String myclub_member() {		
		return "myclub_member";
	}
	//회원가입////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("join.do")
	public String join() {		
		return "join";
	}
	
	@RequestMapping("join_ok.do")
	public String join_ok(HttpServletRequest request) {
		System.out.println("as");
		
		String login_mail = request.getParameter("login_mail");
		String pw = request.getParameter("login_pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		Integer i_gender = Integer.parseInt(gender);
		String phone = request.getParameter("phone");
		String local = request.getParameter("local");
		System.out.println(""+pw+ name+ birthday+ i_gender+ local+ login_mail+ phone);
		iDao iDAO = sqlSession.getMapper(iDao.class);
		iDAO.insertMember(pw, name, birthday, i_gender, local, login_mail, phone);
		
		return "redirect:login.do";
	}
	
	@RequestMapping("mailCheck.do")
	public String idCheck(HttpServletRequest request, Model model) {
		String use_mail = request.getParameter("use_mail");
		String mail = request.getParameter("mail");
		
		if(mail == null) {
			mail = "";
		}
		
		model.addAttribute("use_mail", use_mail);
		model.addAttribute("mail", mail);
		
		return "mailCheck";
	}
	
	@RequestMapping("mailCheck_ok.do")
	public String idCheckOk(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String mail = request.getParameter("mail");
		
		iDao iDAO = sqlSession.getMapper(iDao.class);
		Integer count = iDAO.mailCheck(mail);
		redirectAttributes.addAttribute("mail", mail);
		if(count > 0) {
			redirectAttributes.addAttribute("use_mail", 0); // 중복임
		} else {
			redirectAttributes.addAttribute("use_mail", 1); // 중복 아님
		}
		
		return "redirect:mailCheck.do"; 
	}
	
	//회원가입 끝////////////////////////////////////////////////////////////////////////////////

	@RequestMapping("club_join.do")
	public String club_join() {		
		return "club_join";
	}
	
	@RequestMapping("join_confirm.do")
	public String join_confirm() {		
		return "join_confirm";
	}
	
	@RequestMapping("club_join_confirm.do")
	public String club_join_confirm() {		
		return "club_join_confirm";
	}
	
	@RequestMapping(value="androidTest.do",produces = "application/json; charset=utf8")
	@ResponseBody
	public String testJson(HttpServletRequest request) {
				
		iDao iDAO = sqlSession.getMapper(iDao.class);
		ArrayList<TestData> items = iDAO.getTestData();
		
		Gson gson = new Gson();
		System.out.println("테스트");		
		System.out.println(gson.toJson(items).toString());
		
		return gson.toJson(items);
	}

	public String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
