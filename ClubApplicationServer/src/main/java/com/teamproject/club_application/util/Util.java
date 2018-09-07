package com.teamproject.club_application.util;

<<<<<<< HEAD
import java.awt.image.BufferedImage;
import java.io.File;
=======
import java.io.PrintWriter;
>>>>>>> refs/remotes/origin/abcd
import java.util.ArrayList;
import java.util.UUID;

<<<<<<< HEAD
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.data.ClubMember;
import com.teamproject.club_application.data.Member;
>>>>>>> refs/remotes/origin/abcd

public class Util {
	
	public static Integer ATTFILECOUNT = 1;
	
	public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	
	/**
	 * 썸네일을 생성합니다.
	 * 250 x 150 크기의 썸네일을 만듭니다.
	 */
	private void makeThumbnail(String filePath, String fileName, String fileExt, HttpServletRequest request) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources/sumnail/";
		String sumnailPath = rootPath+attachPath;

	    // 저장된 원본파일로부터 BufferedImage 객체를 생성합니다.
	    BufferedImage srcImg = ImageIO.read(new File(filePath));

	    // 썸네일의 너비와 높이 입니다.
	    int dw = 250, dh = 150;
	    
	    // 원본 이미지의 너비와 높이 입니다.
	    int ow = srcImg.getWidth();
	    int oh = srcImg.getHeight();
	    
	    // 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다.
	    int nw = ow;
	    int nh = (ow * dh) / dw;
	    
	    // 계산된 높이가 원본보다 높다면 crop이 안되므로
	    // 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다.
	    if(nh > oh) {
	        nw = (oh * dw) / dh;
	        nh = oh;
	    }
	  	
	    // 계산된 크기로 원본이미지를 가운데에서 crop 합니다.
	    BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);

	    // crop된 이미지로 썸네일을 생성합니다.
	    BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
	    
	    // 썸네일을 저장합니다. 이미지 이름 앞에 "THUMB_" 를 붙여 표시했습니다.
	    String thumbName = sumnailPath + "THUMB_" + fileName;
	    File thumbFile = new File(thumbName);
	    
	    ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
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
