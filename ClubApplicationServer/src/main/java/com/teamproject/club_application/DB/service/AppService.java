package com.teamproject.club_application.DB.service;

import java.util.ArrayList;

import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMemberClass;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.PostFrame;

public interface AppService {
	public Long insertClub(Image image, Club club);
	public ClubMemberClass selectClub(Long club_id, Long user_id);
	
	public void joinClub(Long club_id, Long user_id); 
	
	public ArrayList<PostFrame> selectBoardView(Long club_id, int page);
	
	public void insertPost(ArrayList<Image> image, Post post, String tag, boolean check);

}
