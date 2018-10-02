package com.teamproject.club_application.data;

public class Comment {
    private  long id;
    private  long post_id;
    private  long member_id;
    private   String content;
    private  String create_date;
    
    public Comment() {
		// TODO Auto-generated constructor stub
	}
    
	public Comment(long id, long club_id, long member_id, String content, String create_date) {
		super();
		this.id = id;
		this.post_id = club_id;
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
		return post_id;
	}
	public void setClub_id(long club_id) {
		this.post_id = club_id;
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
