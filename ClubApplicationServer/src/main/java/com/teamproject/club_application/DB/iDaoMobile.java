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

//mapper.xml에 작성된 쿼리문과 연결된 메소드들.

public interface iDaoMobile {
	public ArrayList<TestData> getTestData(); 
	
	//로그인
    public Member selectLoginUser(String id, String pw);
    public Member refreshLoginUser(Long id);
    
    //회원가입
    public Integer checkId(String id);    
    public void insertMember(Member memeber);
    
    public void createAuth(String loginId, String key);
    public Integer checkAuth(String loginId, String key);
    public void updateAuth(String loginId);
    public void deleteAuth(String loginId);
    
    //정보 찾기
    public String selectFindId(String id) ;
    public Integer selectFindPw(String loginId) ;
    public void updatePw(String loginId, String newPw);
    
    //내 메뉴
    public ArrayList<Alarm> selectMyAlarm(Long userId);
    public ArrayList<Post> selectMyPost(Long userId);
    public ArrayList<Comment> selectMyComment(Long userId);
    public ArrayList<Club> selectMyClub(Long userId);   
    public ArrayList<Schedule> selectMySchedule(Long userId);
    public ArrayList<Schedule> selectMyDaySchedule(Long userId, String dateFormat);//yyyymmdd
    
}
