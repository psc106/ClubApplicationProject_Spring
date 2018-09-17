package com.teamproject.club_application.data;

public class Comment {
    private  Long id;
    private  Long club_id;
    private  Long member_id;
    private  String content;
    private  String create_date;
    
    public Comment() {
		// TODO Auto-generated constructor stub
	}
    
	public Comment(Long id, Long club_id, Long member_id, String content, String create_date) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.member_id = member_id;
		this.content = content;
		this.create_date = create_date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClub_id() {
		return club_id;
	}
	public void setClub_id(Long club_id) {
		this.club_id = club_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
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
