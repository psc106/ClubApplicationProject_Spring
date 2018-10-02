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
	
	// 마이페이지(설정) 관련
	public ArrayList<Club> getMyclubList(long member_id);
	public void updateMyInfo(String pw, String name, String birthday, int i_gender, String local, String phone, long member_id);
	
	// 동호회 관련
	public ArrayList<ClubView> getClubList(Integer index1, Integer index2, String search); // 동호회 리스트 가져오기
	public ArrayList<Integer> getClubMemberCount(Integer index1, Integer index2, String search); //동호회 리스트 클럽 현재인원 가져오기
	public Integer getClubMemberCount2(long club_id); // 회원가입시 현재인원 카운트검사
	public Integer getTotalCount2(String search);
	
	public ArrayList<Category> getCategoryList(); // 동호회 카테고리(주제) 가져오기
	public Long insertClub(Club club); // 동호회 생성
	public void insertClubMember(long club_id, long member_id, String verify); // 동호회 회원가입
	public Club getClubInfo(long club_id); // 동호회 데이터 가져오기
	public Integer countClubMember(long club_id); // 클럽현재인원수 가져오기
	public String getClubMaster(long member_id); // 클럽장 이름 가져오기
	public void insertProfile(long club_id, long member_id, long image_id); // 동호회 회원가입시 프로필 저장
	public ArrayList<ClubMemberView> getClubApplyList(long member_id, long club_id); // 동호회 가입신청 리스트
	public ArrayList<ClubMemberView> getClubMemberList(long member_id, long club_id); // 동호회 가입된 멤버 리스트
	public Integer getClubMember(long login_member_id, long myclub_id); // 동호회 가입상태 확인
	public Long getClubImageId(long club_id); // 클럽아이디를 받아 이미지아이디 리턴
	public String getClubImage(long club_image_id); // 클럽이미지아이디를 받아 이미지이름 리턴
	public String getMyProfileImage(long l_myclub_id, long member_id); // 내프로필이미지(댓,프로필설정)
	public String getMynickname(long l_myclub_id, long member_id);// 댓글 닉네임
	public Integer checkClubLeader(long member_id, long club_id); // 클럽 리더인지 확인
	public void updateClubMember(long club_id, long member_id); //동호회 가입수락
	
	public Profile getMyProfile(long club_id, long member_id); // 내 프로필데이터 가져오기
	public void deleteProfileImage(long club_id, long member_id); // 멤버프로필 삭제시 디폴트프로필이 아니라면 등록된 프로필도 삭제
	public void deleteClubMember(long club_id, long member_id); // 동호회 가입거절, 동호회 강퇴
	public void deleteClubProfile(long club_id, long member_id); // 동호회 가입거절, 동호회 강퇴
	public void updateClubImageId(long club_id, long image_id); // 동호회이미지id수정
	public void updateClubImage(long image_id, String saveFileName, String origName);
	public void updateProfileImageId(long club_id, long member_id, long image_id);
	public void updateProfileImage(long image_id, String saveFileName, String origName);
	public void updateClubInfo(long club_id, String intro, Integer max_people);
	public void updateNickname(long club_id, long member_id, String nickname);
	
	// 동호회 게시판
	public ArrayList<PostProfile> getPostProfile(long club_id, Integer index1, Integer index2, String search); // 동호회 목록 표시용
	public PostProfile postProfileDetail(long l_myclub_id, long l_board_id);
	public void writePost(Post post); // 글 작성
	public void insertPostImage(long post_id, long image_id); // 글 이미지 삽입
	public String getProfileImage(long profile_image_id); // 게시판내 글쓴이프로필이미지
	public ArrayList<String> getPostImage(long post_id); // 이미지이름목록
	public Integer getTotalCount(long club_id, String search); // 게시판 페이징용
	public ArrayList<String> getPostImageList(long post_id); // 글이미지 목록 string 출력
	public void updatePostContent(long post_id, String content); // 글 내용 업데이트
	public void deletePostLinkedImage(long post_id);
	public void deletePostImage(long post_id);
	public void deletePost(long post_id);
	
	public void insertComment(long post_id, long member_id, String content); // 댓글 입력
	public void deleteComment(long comment_id); // 댓글 삭제
	public ArrayList<CommentView> getCommentList(long post_id); // 댓글 리스트
	public void deletePostComment(long post_id); // 글삭제시 댓글 전부 삭제
	
}
