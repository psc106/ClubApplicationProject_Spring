package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.TestData;

//mapper.xml�� �ۼ��� �������� ����� �޼ҵ��.

public interface iDao {
	public ArrayList<TestData> getTestData(); 
	
	// ȸ������ ����
	public Integer mailCheck(String mail);
	public void insertMember(String pw, String name, String birthday, Integer i_gender, String local, String login_mail, String phone);
	 
}
