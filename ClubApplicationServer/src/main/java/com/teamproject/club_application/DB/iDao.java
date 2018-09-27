package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.Category;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMember;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.PostProfile;
import com.teamproject.club_application.data.TestData;

//mapper.xml에 작성된 쿼리문과 연결된 메소드들.

public interface iDao {
	public ArrayList<TestData> getTestData();
	
	public void insertImage(Image image); // 이미지 저장
	
	// 회원가입 관련
	public Integer mailCheck(String mail);
	public void insertMember(String login_mail, String pw, String name, String birthday, Integer i_gender, String local, String phone);
	
	// 로그인 관련
	public Integer loginCheck(String login_id, String login_pw);
	public Member getMemberInfo(String login_id);
	public ArrayList<Club> getMyclub(String login_id);
	
	// 동호회 관련
	public ArrayList<Category> getCategoryList(); // 동호회 카테고리(주제) 가져오기
	public Long insertClub(Club club); // 동호회 생성
	public void insertClubMember(long club_id, long member_id); // 동호회 회원가입
	public Club getClubInfo(long club_id); // 동호회 데이터 가져오기
	public Integer countClubMember(long club_id); // 클럽현재인원수 가져오기
	public String getClubMaster(long member_id); // 클럽장 이름 가져오기
	public void insertProfile(long club_id, long member_id, long image_id); // 동호회 회원가입시 프로필 저장
	public ArrayList<ClubMember> getClubMemberList();
	public Integer getClubMember(long login_member_id, long myclub_id);
	
	// 동호회 게시판
	public ArrayList<PostProfile> getPostProfile();	
	
}
