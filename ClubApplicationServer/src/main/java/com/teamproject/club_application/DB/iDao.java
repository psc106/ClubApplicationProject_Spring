package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.Alarm;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.Comment;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.Schedule;
import com.teamproject.club_application.data.TestData;

//mapper.xml에 작성된 쿼리문과 연결된 메소드들.

public interface iDao {
	public ArrayList<TestData> getTestData(); 
	
    public Member selectLoginUser(String id, String pw);

    public Integer checkId(String id);
    public void insertMember(Member member);
    public void createAuth(Long loginId, String key);
    public Integer checkAuth(Long loginId, String key);
    public void updateAuth(Long loginId);
    public void deleteAuth(Long loginId);
    
    public ArrayList<Alarm> selectMyAlarm(Long userId);
    public ArrayList<Post> selectMyPost(Long userId);
    public ArrayList<Comment> selectMyComment(Long userId);
    public ArrayList<Schedule> selectMySchedule(Long userId);
    public ArrayList<Club> selectMyClub(Long userId);   
    
}
