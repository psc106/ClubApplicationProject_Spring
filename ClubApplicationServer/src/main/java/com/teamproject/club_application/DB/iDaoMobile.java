package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.Alarm;
import com.teamproject.club_application.data.CalendarSchedule;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.Comment;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.Schedule;
import com.teamproject.club_application.data.TestData;

//mapper.xml�� �ۼ��� �������� ����� �޼ҵ��.

public interface iDaoMobile {
	public ArrayList<TestData> getTestData(); 
	
	//�α���
    public Member selectLoginUser(String id, String pw);
    public Member refreshLoginUser(Long id);
    
    //ȸ������
    public Integer checkId(String id);    
    public void insertMember(String id, String pw, String name, String birthday, int gender, String local, String email, String phone, String verify);
    
    public void createAuth(String loginId, String key);
    public Integer checkAuth(String loginId, String key);
    public void updateAuth(String loginId);
    public void deleteAuth(String loginId);
    
    //���� ã��
    public String selectFindId(String email) ;
    public Integer selectFindPw(String email, String loginId) ;
    public void updatePw(String loginId, String newPw);
    
    //�� �޴�
    public ArrayList<Alarm> selectMyAlarm(Long userId);
    public ArrayList<Post> selectMyPost(Long userId);
    public ArrayList<Comment> selectMyComment(Long userId);
    public ArrayList<Club> selectMyClub(Long userId);   
    public ArrayList<Schedule> selectMySchedule(Long userId);
    public ArrayList<Schedule> selectMyDaySchedule(Long userId, String dateFormat);//yyyymmdd
    
}
