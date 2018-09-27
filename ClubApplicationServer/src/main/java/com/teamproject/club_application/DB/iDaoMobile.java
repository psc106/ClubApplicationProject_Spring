package com.teamproject.club_application.DB;

import java.util.ArrayList;

import com.teamproject.club_application.data.*;

//mapper.xml에 작성된 쿼리문과 연결된 메소드들.

public interface iDaoMobile {
	public ArrayList<TestData> getTestData(); 

	//공통
    public void insertImage(Image image);
    
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
    
    public void createTmpPw(String loginId, String pw);
    public Integer checkTmpPw(String loginId, String pw);
    public void deleteTmpPw(String loginId);
    
    //내 메뉴
    public ArrayList<Alarm> selectMyAlarm(Long userId);
    public ArrayList<PostView> selectMyPost(Long userId);
    public ArrayList<Comment> selectMyComment(Long userId);
    public ArrayList<ClubView> selectMyClub(Long userId);   
    public ArrayList<Schedule> selectMySchedule(Long userId);
    public ArrayList<Schedule> selectMyDaySchedule(Long userId, String dateFormat);//yyyymmdd
    
    //클럽
    public void insertClub(Club club);
    public ClubView selectClub(Long club_id);
    public Integer getCurrentMemberCount(Long club_id);
    public String selectClubMemberClass(Long club_id, Long user_id);
    public void joinClub(Long club_id, Long member_id, String verify);
	public void makeClubProfile(Long club_id, Long user_id);
    public Long checkClubProfileImg(Long clubId);
    public Image selectClubProfileImg(Long club_id);

    public Integer getNoticeCount(Long club_id);
    public ArrayList<Notice> selectClubNotice(Long club_id, Integer page);
    public Integer getPostCount(Long club_id);
    public ArrayList<PostView> selectClubPost(Long club_id, Integer page);
    public Integer getAlbumCount(Long club_id);
    public ArrayList<AlbumView> selectClubAlbum(Long club_id, Integer page);
    
    public PostView selectCurrPost(Long post_id);
    public Integer getImageCount(Long post_id);
    public ArrayList<String> selectPostImg(Long post_id);
    public Integer getCommentCount(Long post_id);
    public ArrayList<CommentView> selectPostComment(Long post_id, Integer page, Integer pageCount);
    public ArrayList<CommentView> refreshPostComment(Long post_id, Integer page, Integer pageCount);
    
    public ArrayList<MemberView> selectJoinMember(Long clubId);
    public ArrayList<MemberView> selectWaitingMember(Long clubId);
    public void deleteMember(Long targetId, Long memberId, Long clubId);
    public void updateMember(Long targetId, Long memberId, Long clubId);
    public void updateAdmin(Long targetId, Long memberId, Long clubId);
    public String selectUserProfileImg(Long clubId, Long memberID);
    
    public void insertComment(Long postId, Long memberId, String content);
    public void updateComment(Long commentId, Long memberId, String content);
    public void deleteComment(Long commentId, Long memberId);
    
    public void insertPost(Post post);
    
    public Integer checkPostId(Long postId, Long memberId);
    public void deletePost(Long postId, Long memberId);
    public void deletePostImage(Long postId);
    public void deletePostComment(Long postId);
    public void deletePostImageRelation(Long postId);
    
    public void insertAlbum(Album album);
    public void relationPostImage(Long postId, Long imageId);

    public void	deleteImageRelation(Long postId, String deleteName);
    public void	deleteImage(Long postId, String deleteName);
    public void updatePost(Long postId, Long memberId, String content);

    public void insertTag(Tag tag);   
    public Tag selectTag(String tagName);
    //	0 포스트/ 1 앨범
    public void relationTag(Long TagId, Long referenceId, Integer type);
    
    public void updateProfile(Profile profile);
    public void deleteProfileImage(Long image_id);
    public Profile selectProfile(Long clubId, Long memberId);
    
}
