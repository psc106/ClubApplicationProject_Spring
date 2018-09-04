package com.teamproject.club_application.data;

public class PostView {
    private Long id;
    private Long member_id;
    private String nickname;
    private String content;
    private String create_date;
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

    public PostView(Long id, Long member_id, String nickname, String content, String create_date) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.nickname = nickname;
		this.content = content;
		this.create_date = create_date;
	}
	public PostView() {
		// TODO Auto-generated constructor stub
	}

}
