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
	 * ������� �����մϴ�.
	 * 250 x 150 ũ���� ������� ����ϴ�.
	 */
	private void makeThumbnail(String filePath, String fileName, String fileExt, HttpServletRequest request) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources/sumnail/";
		String sumnailPath = rootPath+attachPath;

	    // ����� �������Ϸκ��� BufferedImage ��ü�� �����մϴ�.
	    BufferedImage srcImg = ImageIO.read(new File(filePath));

	    // ������� �ʺ�� ���� �Դϴ�.
	    int dw = 250, dh = 150;
	    
	    // ���� �̹����� �ʺ�� ���� �Դϴ�.
	    int ow = srcImg.getWidth();
	    int oh = srcImg.getHeight();
	    
	    // ���� �ʺ� �������� �Ͽ� ������� ������ ���̸� ����մϴ�.
	    int nw = ow;
	    int nh = (ow * dh) / dw;
	    
	    // ���� ���̰� �������� ���ٸ� crop�� �ȵǹǷ�
	    // ���� ���̸� �������� ������� ������ �ʺ� ����մϴ�.
	    if(nh > oh) {
	        nw = (oh * dw) / dh;
	        nh = oh;
	    }
	  	
	    // ���� ũ��� �����̹����� ������� crop �մϴ�.
	    BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);

	    // crop�� �̹����� ������� �����մϴ�.
	    BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
	    
	    // ������� �����մϴ�. �̹��� �̸� �տ� "THUMB_" �� �ٿ� ǥ���߽��ϴ�.
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
		System.out.println("callAlert1����");
		if(isLogin(request)) {
			
			model.addAttribute("msgCheck", 1);
			model.addAttribute("msg", "�α����� ���� �ϼ���1234"); 
			model.addAttribute("url", "login.do");
			System.out.println("callAlert1����2");
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
