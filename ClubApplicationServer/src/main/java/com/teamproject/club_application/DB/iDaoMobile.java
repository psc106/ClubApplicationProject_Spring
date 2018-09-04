package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.*;

//mapper.xml�� �ۼ��� �������� ����� �޼ҵ��.

public interface iDaoMobile {
	public ArrayList<TestData> getTestData(); 

	//����
    public void insertImage(Image image);
    
	//�α���
    public Member selectLoginUser(String id, String pw);
    public Member refreshLoginUser(Long id);
    
    //ȸ������
    public Integer checkId(String id);    
    public void insertMember(Member memeber);
    
    public void createAuth(String loginId, String key);
    public Integer checkAuth(String loginId, String key);
    public void updateAuth(String loginId);
    public void deleteAuth(String loginId);
    
    //���� ã��
    public String selectFindId(String id) ;
    public Integer selectFindPw(String loginId) ;
    public void updatePw(String loginId, String newPw);
    
    public void createTmpPw(String loginId, String pw);
    public Integer checkTmpPw(String loginId, String pw);
    public void deleteTmpPw(String loginId);
    
    //�� �޴�
    public ArrayList<Alarm> selectMyAlarm(Long userId);
    public ArrayList<PostView> selectMyPost(Long userId);
    public ArrayList<Comment> selectMyComment(Long userId);
    public ArrayList<Club> selectMyClub(Long userId);   
    public ArrayList<Schedule> selectMySchedule(Long userId);
    public ArrayList<Schedule> selectMyDaySchedule(Long userId, String dateFormat);//yyyymmdd
    
    //Ŭ��
    public void insertClub(Club club);
    public Club selectClub(Long club_id);
    public String selectClubMemberClass(Long club_id, Long user_id);
    public void joinClub(Long club_id, Long member_id, String verify);
	public void makeClubProfile(Long club_id, Long user_id);
    public Image selectClubProfileImg(Long club_id);
    
    public ArrayList<Notice> selectClubNotice(Long club_id, Integer page);
    public ArrayList<PostView> selectClubPost(Long club_id, Integer page);
    public ArrayList<AlbumView> selectClubAlbum(Long club_id, Integer page);
    
    
}
