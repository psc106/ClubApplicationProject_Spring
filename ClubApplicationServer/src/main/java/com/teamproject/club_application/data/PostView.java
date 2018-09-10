package com.teamproject.club_application.data;

public class PostView {
    private Long id;
    private Long member_id;
    private String nickname;
    private String content;
    private String create_date;
    private Long nextId;
    private Long previousId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
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

	public Long getNextId() {
		return nextId;
	}

	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}

	public Long getPreviousId() {
		return previousId;
	}

	public void setPreviousId(Long previousId) {
		this.previousId = previousId;
	}

	
	
	public PostView(Long id, Long member_id, String nickname, String content, String create_date, Long nextId,
			Long previousId) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.nickname = nickname;
		this.content = content;
		this.create_date = create_date;
		this.nextId = nextId;
		this.previousId = previousId;
	}

	public PostView() {
		// TODO Auto-generated constructor stub
	}

}
