package com.teamproject.club_application.DB.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.data.Club;
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
		dao.joinClub(club.getId(), club.getMember_id(), "A");
		return club.getId();
	}


}
