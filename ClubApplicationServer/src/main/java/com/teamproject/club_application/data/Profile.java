package com.teamproject.club_application.data;

import org.springframework.ui.Model;

public class Profile {
	private long id;
	private long club_id;
	private long member_id;
	private long image_id;
	private String nickname;
	
	public Profile() {
		super();
	}

	public Profile(long id, long club_id, long member_id, long image_id, String nickname) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.member_id = member_id;
		this.image_id = image_id;
		this.nickname = nickname;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClub_id() {
		return club_id;
	}

	public void setClub_id(long club_id) {
		this.club_id = club_id;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public long getImage_id() {
		return image_id;
	}

	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
