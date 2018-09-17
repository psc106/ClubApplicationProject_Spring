package com.teamproject.club_application.data;

public class ClubView {
	private long id;
	private String img_db_name;
	private String name;
	private String nickname;
	private String intro;
	public ClubView() {
		super();
	}
	
	public ClubView(long id, String img_db_name, String name, String nickname, String intro) {
		super();
		this.id = id;
		this.img_db_name = img_db_name;
		this.name = name;
		this.nickname = nickname;
		this.intro = intro;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImg_db_name() {
		return img_db_name;
	}
	public void setImg_db_name(String img_db_name) {
		this.img_db_name = img_db_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
