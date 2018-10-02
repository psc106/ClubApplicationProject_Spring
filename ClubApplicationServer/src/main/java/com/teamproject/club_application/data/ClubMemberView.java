package com.teamproject.club_application.data;

public class ClubMemberView {
	private String img_db_name;
	private String nickname;
	private String login_id;
	private long member_id;
	
	public ClubMemberView() {
		super();
	}

	public ClubMemberView(String img_db_name, String nickname, String login_id, long member_id) {
		super();
		this.img_db_name = img_db_name;
		this.nickname = nickname;
		this.login_id = login_id;
		this.member_id = member_id;
	}

	public String getImg_db_name() {
		return img_db_name;
	}

	public void setImg_db_name(String img_db_name) {
		this.img_db_name = img_db_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}
	
	
}
