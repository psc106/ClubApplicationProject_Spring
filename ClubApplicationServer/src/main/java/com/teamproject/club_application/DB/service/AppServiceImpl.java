package com.teamproject.club_application.DB.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMemberClass;
import com.teamproject.club_application.data.ClubView;
import com.teamproject.club_application.data.Image;

@Service("ApplicationService")
public class AppServiceImpl implements AppService {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	

	@Transactional
	@Override
	public Long insertClub(Image image, Club club) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		if(image != null) {
			dao.insertImage(image);
			club.setImage_id(image.getId());
		} else {
			club.setImage_id(-1);		
		}
		dao.insertClub(club);
		dao.joinClub(club.getId(), club.getMember_id(), "Y");
		dao.makeClubProfile(club.getId(), club.getMember_id());
		return club.getId();
	}


	//	비로그인	비회원 	대기		회원 		관리자
	//	'O'ut	'N'o	'W'ait	'Y'es	'A'dmin
	@Transactional
	@Override
	public ClubMemberClass selectClub(Long club_id, Long user_id) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		ClubMemberClass clubMemberClass;
		ClubView club = dao.selectClub(club_id);
		String memberClass = dao.selectClubMemberClass(club_id, user_id);
		if(memberClass==null) {
			if(user_id==-1L) {
				memberClass = "O";
			} else {
				memberClass = "N";
			}
		} else if(memberClass.equals("Y")) {			
			if(club.getMember_id() == user_id) {
				memberClass = "A";
			}
		} else {
			memberClass = "W";
		}
		
		clubMemberClass = new ClubMemberClass(club, memberClass);

		return clubMemberClass;
	}


	@Override
	public void joinClub(Long club_id, Long user_id) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		dao.joinClub(club_id, user_id, "N");
		dao.makeClubProfile(club_id, user_id);		
	}


}
