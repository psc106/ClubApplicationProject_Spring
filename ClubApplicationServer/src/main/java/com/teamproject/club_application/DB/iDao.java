package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.Category;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMember;
import com.teamproject.club_application.data.ClubMemberView;
import com.teamproject.club_application.data.ClubView;
import com.teamproject.club_application.data.Comment;
import com.teamproject.club_application.data.CommentView;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.PostProfile;
import com.teamproject.club_application.data.Profile;
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
	
	// ����������(����) ����
	public ArrayList<Club> getMyclubList(long member_id);
	public void updateMyInfo(String pw, String name, String birthday, int i_gender, String local, String phone, long member_id);
	
	// ��ȣȸ ����
	public ArrayList<ClubView> getClubList(Integer index1, Integer index2, String search); // ��ȣȸ ����Ʈ ��������
	public ArrayList<Integer> getClubMemberCount(Integer index1, Integer index2, String search); //��ȣȸ ����Ʈ Ŭ�� �����ο� ��������
	public Integer getClubMemberCount2(long club_id); // ȸ�����Խ� �����ο� ī��Ʈ�˻�
	public Integer getTotalCount2(String search);
	
	public ArrayList<Category> getCategoryList(); // ��ȣȸ ī�װ�(����) ��������
	public Long insertClub(Club club); // ��ȣȸ ����
	public void insertClubMember(long club_id, long member_id, String verify); // ��ȣȸ ȸ������
	public Club getClubInfo(long club_id); // ��ȣȸ ������ ��������
	public Integer countClubMember(long club_id); // Ŭ�������ο��� ��������
	public String getClubMaster(long member_id); // Ŭ���� �̸� ��������
	public void insertProfile(long club_id, long member_id, long image_id); // ��ȣȸ ȸ�����Խ� ������ ����
	public ArrayList<ClubMemberView> getClubApplyList(long member_id, long club_id); // ��ȣȸ ���Խ�û ����Ʈ
	public ArrayList<ClubMemberView> getClubMemberList(long member_id, long club_id); // ��ȣȸ ���Ե� ��� ����Ʈ
	public Integer getClubMember(long login_member_id, long myclub_id); // ��ȣȸ ���Ի��� Ȯ��
	public Long getClubImageId(long club_id); // Ŭ�����̵� �޾� �̹������̵� ����
	public String getClubImage(long club_image_id); // Ŭ���̹������̵� �޾� �̹����̸� ����
	public String getMyProfileImage(long l_myclub_id, long member_id); // ���������̹���(��,�����ʼ���)
	public String getMynickname(long l_myclub_id, long member_id);// ��� �г���
	public Integer checkClubLeader(long member_id, long club_id); // Ŭ�� �������� Ȯ��
	public void updateClubMember(long club_id, long member_id); //��ȣȸ ���Լ���
	
	public Profile getMyProfile(long club_id, long member_id); // �� �����ʵ����� ��������
	public void deleteProfileImage(long club_id, long member_id); // ��������� ������ ����Ʈ�������� �ƴ϶�� ��ϵ� �����ʵ� ����
	public void deleteClubMember(long club_id, long member_id); // ��ȣȸ ���԰���, ��ȣȸ ����
	public void deleteClubProfile(long club_id, long member_id); // ��ȣȸ ���԰���, ��ȣȸ ����
	public void updateClubImageId(long club_id, long image_id); // ��ȣȸ�̹���id����
	public void updateClubImage(long image_id, String saveFileName, String origName);
	public void updateProfileImageId(long club_id, long member_id, long image_id);
	public void updateProfileImage(long image_id, String saveFileName, String origName);
	public void updateClubInfo(long club_id, String intro, Integer max_people);
	public void updateNickname(long club_id, long member_id, String nickname);
	
	// ��ȣȸ �Խ���
	public ArrayList<PostProfile> getPostProfile(long club_id, Integer index1, Integer index2, String search); // ��ȣȸ ��� ǥ�ÿ�
	public PostProfile postProfileDetail(long l_myclub_id, long l_board_id);
	public void writePost(Post post); // �� �ۼ�
	public void insertPostImage(long post_id, long image_id); // �� �̹��� ����
	public String getProfileImage(long profile_image_id); // �Խ��ǳ� �۾����������̹���
	public ArrayList<String> getPostImage(long post_id); // �̹����̸����
	public Integer getTotalCount(long club_id, String search); // �Խ��� ����¡��
	public ArrayList<String> getPostImageList(long post_id); // ���̹��� ��� string ���
	public void updatePostContent(long post_id, String content); // �� ���� ������Ʈ
	public void deletePostLinkedImage(long post_id);
	public void deletePostImage(long post_id);
	public void deletePost(long post_id);
	
	public void insertComment(long post_id, long member_id, String content); // ��� �Է�
	public void deleteComment(long comment_id); // ��� ����
	public ArrayList<CommentView> getCommentList(long post_id); // ��� ����Ʈ
	public void deletePostComment(long post_id); // �ۻ����� ��� ���� ����
	
}
