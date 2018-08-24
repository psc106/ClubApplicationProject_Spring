package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.TestData;

//mapper.xml에 작성된 쿼리문과 연결된 메소드들.

public interface iDao {
	public ArrayList<TestData> getTestData(); 
	
	// 회원가입 관련
	public Integer mailCheck(String mail);
	public void insertMember(String pw, String name, String birthday, Integer i_gender, String local, String login_mail, String phone);
	 
}
