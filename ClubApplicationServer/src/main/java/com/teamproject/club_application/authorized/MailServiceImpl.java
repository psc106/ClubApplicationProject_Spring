package com.teamproject.club_application.authorized;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.inject.Inject;
import javax.mail.MessagingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.data.Member;

@Service("MailAuthService")
public class MailServiceImpl implements MailService {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	@Inject
	private JavaMailSender mailSender;
	@Transactional
	@Override
	public void authCreate(Member member, HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		dao.insertMember(member); // 회원가입 DAO
		String key = new TempKey().getKey(50, false); // 인증키 생성
		dao.createAuth(member.getLogin_id(), key);
		
		String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
		
		MailHandler sendMail;
		try {
			sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[\"동호회\" 이메일 인증해주세요]");
			sendMail.setText(
					new StringBuffer().append("<h1>메일인증</h1>").
					append("<a href='"+url+"/authOk.do?login_id=").
					//append("<a href='http://localhost:8090/club_application/authOk.do?login_id=").
					append(member.getLogin_id()).
					append("&key=").
					append(key).
					append("' target='_blenk'>이메일 인증 확인</a>").toString());
			sendMail.setFrom("clubapplicationproject@gmail.com", "동호회");
			sendMail.setTo(member.getLogin_id());
			sendMail.send();		
		//http://192.168.0.70:8090/club_application/authOk.do?login_id=113&key=U2I6wTocYfWaGMCrDEWr1znPjAcLdWUR2fEsJ7B6mlZSmMQIPW
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public boolean authUpdate(String loginId, String key) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		
		System.out.println(loginId+"_"+key);
		
		//1, 0
		int userCount = dao.checkAuth(loginId, key);
		System.out.println(userCount);
		
		if(userCount==1) {
			dao.updateAuth(loginId);
			dao.deleteAuth(loginId);
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean findPw(String id, HttpServletRequest request) {
		
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		int userCount = dao.selectFindPw(id);
		
		String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
		
		//reset방식
		if(userCount==1) {
			String pw = new TempKey().getKey(10, false);
			dao.createTmpPw(id, pw);
			
			MailHandler sendMail;
			try {
				sendMail = new MailHandler(mailSender);
				sendMail.setSubject("[\"동호회\" 임시 비밀번호입니다]");
				sendMail.setText(
						new StringBuffer().append("<h1>새 정보 수정</h1>").
						append("당신의 새 비밀번호는 다음과 같습니다.<br>").
						append("<h1>"+pw+"</h1>").
						append("아래의 링크를 누르면 비밀번호가 변경됩니다.<br>").
						append("<a href='"+url+"/updatePw.do?login_id=").
						//append("<a href='http://192.168.0.70:8090/club_application/updatePw.do?login_id=").
						append(id).
						append("&pw=").
						append(pw).
						append("' target='_blenk'>비밀번호 변경</a>").toString());
				sendMail.setFrom("clubapplicationproject@gmail.com", "동호회");
				sendMail.setTo(id);
				sendMail.send();		
			
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean tmpPwUpdate(String loginId, String pw) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		System.out.println(loginId+"\t"+pw);
		
		//1, 0
		int userCount = dao.checkTmpPw(loginId, pw); 
		System.out.println(userCount);
		
		if(userCount==1) {
			dao.updatePw(loginId, pw);
			dao.deleteTmpPw(loginId);
			return true;
		} else {
			return false;
		}
	}
}