package com.teamproject.club_application.authorized;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.club_application.DB.iDao;
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
	public void authCreate(Member member) {
		iDao dao = sqlSession.getMapper(iDao.class);
		dao.insertMember(member.getLogin_id(), member.getLogin_pw(), member.getName(), member.getBirthday(), member.getGender(), member.getLocal(), member.getEmail(), member.getPhone(), "N"); // ȸ������ DAO

		String key = new TempKey().getKey(50, false); // ����Ű ����
		dao.createAuth(member.getLogin_id(), key);
		
		MailHandler sendMail;
		try {
			sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[\"��ȣȸ\" �̸��� �������ּ���]");
			sendMail.setText(
					new StringBuffer().append("<h1>��������</h1>").
					append("<a href='http://192.168.0.70:8090/club_application/authOk.do?login_id=").
					append(member.getLogin_id()).
					append("&key=").
					append(key).
					append("' target='_blenk'>�̸��� ���� Ȯ��</a>").toString());
			sendMail.setFrom("clubapplicationproject@gmail.com", "��ȣȸ");
			sendMail.setTo(member.getEmail());
			sendMail.send();		
		
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
		iDao dao = sqlSession.getMapper(iDao.class);
		
		//1, 0
		int userCount = dao.checkAuth(loginId, key);
		
		if(userCount==1) {
			dao.updateAuth(loginId);
			dao.deleteAuth(loginId);
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public boolean findPw(String email, String id) {
		iDao dao = sqlSession.getMapper(iDao.class);
		int userCount = dao.selectFindPw(email, id);
		
		//reset���
		if(userCount==1) {
			String pw = new TempKey().getKey(10, false);
			dao.updatePw(id, pw);

			MailHandler sendMail;
			try {
				sendMail = new MailHandler(mailSender);
				sendMail.setSubject("[\"��ȣȸ\" �ӽ� ��й�ȣ�Դϴ�]");
				sendMail.setText(
						new StringBuffer().append("<h1>�� ���� ����</h1>").
						append("����� �� ��й�ȣ�� ������ �����ϴ�.<br>").
						append("<h1>"+pw+"</h1>").toString());
				sendMail.setFrom("clubapplicationproject@gmail.com", "��ȣȸ");
				sendMail.setTo(email);
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

}
