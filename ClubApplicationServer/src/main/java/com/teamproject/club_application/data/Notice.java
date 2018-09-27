package com.teamproject.club_application.data;

public class Notice {
    private long id;
    private long club_id;
    private String content;
    private String create_date;
	
    public Notice() {
		// TODO Auto-generated constructor stub
	}
    
    

	public Notice(long id, long club_id, String content, String create_date) {
		super();
		this.id = id;
		this.club_id = club_id;
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
