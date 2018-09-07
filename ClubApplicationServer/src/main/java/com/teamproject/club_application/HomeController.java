package com.teamproject.club_application;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.authorized.MailService;
import com.teamproject.club_application.data.Category;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMember;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.PostProfile;
import com.teamproject.club_application.util.Util;

/*
if(!Util.isLogin(request)) { // 로그인여부검사
	return "redirect:check_login.do";
}
*/

/* 로그인 + 동호회가입 검사
String moveURL = loginMemberCheck(request);
if(moveURL!=null) {
	return moveURL;
}
 */


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController{
	SqlSession sqlSession;
	static String referer;
	
	@Resource(name="MailAuthService")
	MailService service;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
		
	@RequestMapping("home.do")
	public String home() {		
		return "home";
	}	
	//로그인////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("login.do")
	public String login(HttpServletRequest request) {
		//<input type="hidden" name="url" value="<%=request.getHeader("referer") %>" />
		
		
		
		
		return "login";
	}
	
	@RequestMapping("login_ok.do")
	public String login_ok(HttpServletRequest request) {
		String login_id = request.getParameter("login_mail");
		String login_pw = request.getParameter("login_pw");
		
		iDao iDAO = sqlSession.getMapper(iDao.class);
		Integer login_check = iDAO.loginCheck(login_id, login_pw);
		
		if(login_check > 0) {
			HttpSession httpSession = request.getSession();
			Member login_member = iDAO.getMemberInfo(login_id);
			ArrayList<Club> myclub = iDAO.getMyclub(login_id); 
			httpSession.setAttribute("login_member", login_member);
			httpSession.setAttribute("myclub", myclub);
			
			
			if(referer == null) {
				return "redirect:home.do";
			} else {
				String[] splitUrl = referer.split("/");
				for(int i=0; i<splitUrl.length; i++) {
					System.out.print(splitUrl[i]+", ");
				}
				return "redirect:"+splitUrl[splitUrl.length-1]; // 마지막으로 들어온 페이지의 url 값에서 .do 부분 저장
			}
		}else {
			return "redirect:login.do"; // 로그인 실패
		}
		
	}
	
	@RequestMapping("logout_ok.do")
	public String logout(HttpServletRequest request) {
//		if(!Util.isLoginAlive(request.getSession())) {
//			return "redirect:login.do"; // 세션 만료 검사
//		}
		
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("login_member");
		
		
		referer = request.getHeader("referer");
		String[] splitUrl = referer.split("/");
		for(int i=0; i<splitUrl.length; i++) {
			System.out.print(splitUrl[i]+", ");
		}
		return "redirect:"+splitUrl[splitUrl.length-1]; // 마지막으로 들어온 페이지의 url 값에서 .do 부분 저장
	 
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
	
	// 동호회 페이지 시작///////////////////////////////////////////////////////////////
	@RequestMapping("myclub_board.do")
	public String myclub_board(HttpServletRequest request, Model model) {
		getClubInfo(request, model);
		
		iDao iDAO = sqlSession.getMapper(iDao.class);
		ArrayList<PostProfile> PostProfile = iDAO.getPostProfile();
		request.setAttribute("PostProfile", PostProfile);
		
				
		
		
		return "myclub_board";
	}
	
	@RequestMapping("myclub_write.do")
	public String myclub_write(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		iDao iDAO = sqlSession.getMapper(iDao.class);
		
		String moveURL = loginMemberCheck(request);
		if(moveURL!=null) {
			return moveURL;
		}
		
		getClubInfo(request, model);
		
		
		
		return "myclub_write";
	}
	
	@RequestMapping("myclub_sel.do")
	public String myclub_sel(HttpServletRequest request, Model model) {
		String myclub_id = request.getParameter("myclub");
		System.out.println("myclub_id!!!!!!!!!!!!!!!!!!!!!"+myclub_id);
		
		
		
		return "redirect:myclub_board.do?id="+myclub_id;
	}
	
	@RequestMapping("myclub_album.do")
	public String myclub_album(HttpServletRequest request, Model model) {
		getClubInfo(request, model);
		
		return "myclub_album";
	}
	
	@RequestMapping("myclub_calendar.do")
	public String myclub_calendar(HttpServletRequest request, Model model) {
		getClubInfo(request, model);
		
		return "myclub_calendar";
	}
	
	@RequestMapping("myclub_setting.do")
	public String myclub_setting(HttpServletRequest request, Model model) {
		getClubInfo(request, model);
		
		return "myclub_setting";
	}
	
	@RequestMapping("myclub_member.do")
	public String myclub_member() {
		return "myclub_member";
	}
	
	@RequestMapping("check_login.do")
	public String check_login(HttpServletRequest request, Model model) { // 로그인 체크메시지 페이지
		referer = request.getHeader("referer");
		
		System.out.println("체크로그인 실행");
		model.addAttribute("msgCheck", 1); 
		model.addAttribute("msg", "로그인을 먼저 하세요1234"); 
		model.addAttribute("url", "login.do");
		
		return "check_login";
	}
	
	@RequestMapping("check_member.do")
	public String check_member(HttpServletRequest request, Model model) { // 로그인 체크메시지 페이지
		referer = request.getHeader("referer");
		
		String myclub_id = request.getParameter("id");
		long l_myclub_id = Long.parseLong(myclub_id);
		
		System.out.println("체크멤버 실행");
		model.addAttribute("msgCheck", 2); 
		model.addAttribute("msg", "가입을 먼저 하세요"); 
		model.addAttribute("url", "myclub_board.do?id=" + l_myclub_id);
		
		return "check_member";
	}
	
	//회원가입////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("join.do")
	public String join() {		
		return "join";
	}
	
	@RequestMapping("join_ok.do")
	public String join_ok(HttpServletRequest request) {
		
		String login_mail = request.getParameter("login_mail");
		String pw = request.getParameter("login_pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		Integer i_gender = Integer.parseInt(gender);
		String local = request.getParameter("local");
		String phone = request.getParameter("phone");
		System.out.println(""+login_mail+pw+name+birthday+i_gender+local+ phone);
		iDao iDAO = sqlSession.getMapper(iDao.class);
		//iDAO.insertMember(login_mail, pw, name, birthday, i_gender, local, phone);
		
		Member member = new Member(-1, login_mail, pw, name, birthday, i_gender, local, login_mail, phone, "N");
		service.authCreate(member);
		
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
	
	@RequestMapping("create_club.do")
	public String create_club(Model model) {
		iDao iDAO = sqlSession.getMapper(iDao.class);
		
		ArrayList<Category> items = new ArrayList<Category>();
		items = iDAO.getCategoryList();		
		model.addAttribute("items", items);
		
		
		
		
		
		return "create_club";
	}
	
	@RequestMapping("create_club_ok.do")
	public String create_club_ok(HttpServletRequest request, Model model) {
		iDao iDAO = sqlSession.getMapper(iDao.class);
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/upload/";
		String path = root_path + attach_path;
		
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
		String club_name = mhsr.getParameter("club_name");
		String category = mhsr.getParameter("category");
		Long l_category = Long.parseLong(category);
		String max_people = mhsr.getParameter("max_people");
		Integer i_max_people = Integer.parseInt(max_people);
		String local = mhsr.getParameter("local");
		String intro = mhsr.getParameter("intro");
		
		HttpSession httpSession = request.getSession();
		Member login_member = (Member)httpSession.getAttribute("login_member");
		
		
		Iterator<String> iter = mhsr.getFileNames();
		MultipartFile mfile = null;
		
		Image image=null;
		Club club=null;
		
		while (iter.hasNext()) {
			String fieldName = (String) iter.next();
			
			mfile = mhsr.getFile(fieldName);
			String origName;
			
			origName = mfile.getOriginalFilename();
			
			if (origName != null && !origName.equals("")) {
				String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
				String saveFileName = Util.getRandomString() + ext;
	
				File serverFile = new File(path + "/" + saveFileName);
				try {
					mfile.transferTo(serverFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				image = new Image(0l, saveFileName, origName);
				
			}
		}
		
		if(image==null) { // 이미지 첨부가 없을 떄 디폴트
			club = new Club(0l, l_category, login_member.getId(), -1l, club_name, local, i_max_people, intro, "");
			iDAO.insertClub(club);
		} else { // 이미지 첨부 있을 때
			iDAO.insertImage(image);
			club = new Club(0l, l_category, login_member.getId(), image.getId(), club_name, local, i_max_people, intro, "");
			iDAO.insertClub(club);
		}
		iDAO.insertClubMember(club.getId(), login_member.getId());
		iDAO.insertProfile(club.getId(), login_member.getId(), -2);
		//프로파일insert
		
		ArrayList<Club> myclub = iDAO.getMyclub(login_member.getLogin_id()); 
		httpSession.setAttribute("myclub", myclub);
		
		return "redirect:home.do";
	}
	
	@RequestMapping("club_join.do") // 사용안할꺼임
	public String club_join(HttpServletRequest request, Model model) {
		getClubInfo(request, model);
		
		return "club_join";
	}
	
	@RequestMapping("join_confirm.do")
	public String join_confirm() {		
		return "join_confirm";
	}
	
	@RequestMapping("club_join_confirm.do")
	public String club_join_confirm(HttpServletRequest request, Model model) {
		iDao iDAO = sqlSession.getMapper(iDao.class);
		HttpSession httpSession = request.getSession();
		
		if(!Util.isLogin(request)) { // 로그인여부검사
			return "redirect:check_login.do";
		}
		
		getClubInfo(request, model);
		
		String myclub_id = request.getParameter("id");
		long l_myclub_id = Long.parseLong(myclub_id);
		Member login_member = (Member)httpSession.getAttribute("login_member");
		
		iDAO.insertClubMember(l_myclub_id, login_member.getId());
		iDAO.insertProfile(l_myclub_id, login_member.getId(), -2);
		
		return "club_join_confirm";
	}
	
	@RequestMapping(value="/authOk.do", method=RequestMethod.GET)
	public String authMember(HttpServletRequest request) {
		String id = request.getParameter("login_id");
		String key = request.getParameter("key");
		
		System.out.println(id+"_"+key);
		
		
		boolean isSuccess = service.authUpdate(id, key);
		
		if(isSuccess) {	
			//인증 성공
			return "success";
		} else {
			//인증 실패
			return "fail";
		}
	}
	

	@RequestMapping(value="/updatePw.do", method=RequestMethod.GET)
	public String updatePw(HttpServletRequest request) {
		String id = request.getParameter("login_id");
		String pw = request.getParameter("pw");
		System.out.println(id+"\t"+pw);
		boolean isSuccess = service.tmpPwUpdate(id, pw);
		
		if(isSuccess) {	
			//인증 성공
			return "tmpPwSuccess";
		} else {
			//인증 실패
			return "tmpPwFail";
		}
	}
	public void getClubInfo(HttpServletRequest request, Model model) {
		iDao iDAO = sqlSession.getMapper(iDao.class);
		String myclub_id = request.getParameter("id");
		long l_myclub_id = Long.parseLong(myclub_id);
		
		Club club_info = iDAO.getClubInfo(l_myclub_id);
		
		Integer countClubMember = iDAO.countClubMember(club_info.getId());
		String getClubMaster = iDAO.getClubMaster(club_info.getMember_id());
		
		model.addAttribute("club_info", club_info);
		model.addAttribute("countClubMember", countClubMember);
	}
	
	public String loginMemberCheck(HttpServletRequest request) {
		iDao iDAO = sqlSession.getMapper(iDao.class);
		HttpSession httpSession = request.getSession();
		
		String myclub_id = request.getParameter("id");
		long l_myclub_id = Long.parseLong(myclub_id);
		
		if(!Util.isLogin(request)) { // 로그인여부검사
			return "redirect:check_login.do";
		}else {
			Member login_member = (Member)httpSession.getAttribute("login_member");
			Integer club_member = iDAO.getClubMember(login_member.getId(), l_myclub_id);
			System.out.println("club_member : " + club_member);
			if(club_member == 0) {
				return "redirect:check_member.do?id="+l_myclub_id;
			}
		}
		
		return null;
				
	}
}
