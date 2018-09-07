package com.teamproject.club_application.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.data.ClubMember;
import com.teamproject.club_application.data.Member;

public class Util {
	
	public static Integer ATTFILECOUNT = 1;
	
	public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	
	public static boolean isLoginAlive(HttpSession httpSession) {
		String sessionId = (String)httpSession.getAttribute("login_member");
		if(sessionId==null) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void callAlert1(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		System.out.println("callAlert1실행");
		if(isLogin(request)) {
			
			model.addAttribute("msgCheck", 1);
			model.addAttribute("msg", "로그인을 먼저 하세요1234"); 
			model.addAttribute("url", "login.do");
			System.out.println("callAlert1실행2");
		}
	}
	
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute("login_member") == null) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isMember(HttpServletRequest request, ArrayList<ClubMember> club_member, long l_club_id) {
		HttpSession httpSession = request.getSession();
		
		Member login_member = (Member)httpSession.getAttribute("login_member");
		
		for(int i=0; i<club_member.size(); i++) {
			System.out.println(l_club_id+"  ???  "+club_member.get(i).getClub_id());
			System.out.println(login_member.getId()+"  ???  "+club_member.get(i).getMember_id());
			System.out.println(club_member.get(i).getVerify());
			
			if(l_club_id == club_member.get(i).getClub_id() && login_member.getId() == club_member.get(i).getMember_id() && club_member.get(i).getVerify().equals("Y")) {
				return true;
			}
		}
		
		
		return false;
	}
	
}
