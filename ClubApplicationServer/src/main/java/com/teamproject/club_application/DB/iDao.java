package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.Category;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMember;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.PostProfile;
import com.teamproject.club_application.data.TestData;

//mapper.xml�� �ۼ��� �������� ����� �޼ҵ��.

public interface iDao {
	public ArrayList<TestData> getTestData();
	
	public void insertImage(Image image); // �̹��� ����
	
	// ȸ������ ����
	public Integer mailCheck(String mail);
	public void insertMember(String login_mail, String pw, String name, String birthday, Integer i_gender, String local, String phone);
	
	// �α��� ����
	public Integer loginCheck(String login_id, String login_pw);
	public Member getMemberInfo(String login_id);
	public ArrayList<Club> getMyclub(String login_id);
	
	// ��ȣȸ ����
	public ArrayList<Category> getCategoryList(); // ��ȣȸ ī�װ�(����) ��������
	public Long insertClub(Club club); // ��ȣȸ ����
	public void insertClubMember(long club_id, long member_id); // ��ȣȸ ȸ������
	public Club getClubInfo(long club_id); // ��ȣȸ ������ ��������
	public Integer countClubMember(long club_id); // Ŭ�������ο��� ��������
	public String getClubMaster(long member_id); // Ŭ���� �̸� ��������
	public void insertProfile(long club_id, long member_id, long image_id); // ��ȣȸ ȸ�����Խ� ������ ����
	public ArrayList<ClubMember> getClubMemberList();
	public Integer getClubMember(long login_member_id, long myclub_id);
	
	// ��ȣȸ �Խ���
	public ArrayList<PostProfile> getPostProfile();	
	
}
