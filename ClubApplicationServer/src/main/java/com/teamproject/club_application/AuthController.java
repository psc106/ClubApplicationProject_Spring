package com.teamproject.club_application;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamproject.club_application.DB.iDao;
import com.teamproject.club_application.authorized.MailAuthService;
import com.teamproject.club_application.authorized.MailHandler;
import com.teamproject.club_application.authorized.TempKey;
import com.teamproject.club_application.data.Member;

@Controller
public class AuthController {
	SqlSession sqlSession;
	iDao dao = sqlSession.getMapper(iDao.class);
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	

//	
//	MailAuthService service = new MailAuthService() {
//		@Inject
//		private JavaMailSender mailSender;
//
//		@Transactional
//		@Override
//		public void create(Member member) {
//			dao.insertMember(); // 회원가입 DAO
//
//			String key = new TempKey().getKey(50, false); // 인증키 생성
//
//			dao.createAuthKey(member.getEmail(), key); // 인증키 DB저장
//
//			MailHandler sendMail = new MailHandler(mailSender);
//			sendMail.setSubject("[ALMOM 서비스 이메일 인증]");
//			sendMail.setText(
//					new StringBuffer().append("<h1>메일인증</h1>").append("<a href='http://localhost/user/emailConfirm?user_email=").append(vo.getUser_email()).append("&key=").append(key).append("' target='_blenk'>이메일 인증 확인</a>").toString());
//			sendMail.setFrom("호스트 이메일 아이디", "알몸개발자");
//			sendMail.setTo(vo.getUser_email());
//			sendMail.send();		
//		}
//		
//	};
	
	

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String RegisterPost(Member member) throws Exception {
//		service.create(member);
		return "";
	}
	

}
