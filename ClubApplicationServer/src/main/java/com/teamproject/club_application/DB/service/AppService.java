package com.teamproject.club_application.DB.service;

import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMemberClass;
import com.teamproject.club_application.data.Image;

public interface AppService {
	public Long insertClub(Image image, Club club);
	public ClubMemberClass selectClub(Long club_id, Long user_id);

}
