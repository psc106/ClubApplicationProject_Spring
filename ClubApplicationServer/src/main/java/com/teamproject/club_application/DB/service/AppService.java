package com.teamproject.club_application.DB.service;

import java.util.ArrayList;

import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMemberClass;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.PostFrame;
import com.teamproject.club_application.data.Profile;

public interface AppService {
	public Long insertClub(Image image, Club club);
	public ClubMemberClass selectClub(Long club_id, Long user_id);
	
	public void joinClub(Long club_id, Long user_id); 
	
	public ArrayList<PostFrame> selectBoardView(Long club_id, int page);
	public ArrayList<PostFrame> searchBoardView(Long club_id, int page, String keyword);
	
	public void insertPost(ArrayList<Image> image, Post post, String tag, boolean check);

	public boolean deletePost(Long postId, Long memberId);
	public void updatePost(Long postId, Long memberId, String content, ArrayList<Image> image, String[] deleteList);
	public void updateProfile(Image image, Long clubId, Long memberId);
}
