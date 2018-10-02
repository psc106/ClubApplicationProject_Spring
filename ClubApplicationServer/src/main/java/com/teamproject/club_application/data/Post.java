package com.teamproject.club_application.data;

public class Post {
    private long id;
    private long club_id;
    private long member_id;
    private String content;
    private String create_date;
    
    public Post() {
		// TODO Auto-generated constructor stub
	}
    
	public Post(long id, long club_id, long member_id, String content, String create_date) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.member_id = member_id;
		this.content = content;
		this.create_date = create_date;
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
    
}
