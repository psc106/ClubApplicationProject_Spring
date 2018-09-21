package com.teamproject.club_application.data;

public class CommentView {
	private long id;
	private long member_id;
	private String nickname;
	private String content;
	private String create_date;
	private String img_db_name;
	
	
	
	public CommentView() {
		super();
	}

	public CommentView(long id, long member_id, String nickname, String content, String create_date, String img_db_name) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.nickname = nickname;
		this.content = content;
		this.create_date = create_date;
		this.img_db_name = img_db_name;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getCreate_date() {
		return create_date;
	}



	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}



	public String getImg_db_name() {
		return img_db_name;
	}



	public void setImg_db_name(String img_db_name) {
		this.img_db_name = img_db_name;
	}
	
	
}
