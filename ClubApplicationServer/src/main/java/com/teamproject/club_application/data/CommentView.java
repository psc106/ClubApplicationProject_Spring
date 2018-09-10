package com.teamproject.club_application.data;

public class CommentView {
    private  Long id;
    private  String nickname;
    private  String content;
    private  String create_date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public CommentView(Long id, String nickname, String content, String create_date) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.content = content;
		this.create_date = create_date;
	}
    
    public CommentView() {
		// TODO Auto-generated constructor stub
	}
}
