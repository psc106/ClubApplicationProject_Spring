package com.teamproject.club_application.data;

public class PostView {
    private long id;
    private long member_id;
    private String nickname;
    private String content;
    private String create_date;
    private String imgUrl;
    private long nextId;
    private long previousId;

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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getNextId() {
		return nextId;
	}

	public void setNextId(long nextId) {
		this.nextId = nextId;
	}

	public long getPreviousId() {
		return previousId;
	}

	public void setPreviousId(long previousId) {
		this.previousId = previousId;
	}

	public PostView(long id, long member_id, String nickname, String content, String create_date, String imgUrl,
			long nextId, long previousId) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.nickname = nickname;
		this.content = content;
		this.create_date = create_date;
		this.imgUrl = imgUrl;
		this.nextId = nextId;
		this.previousId = previousId;
	}

	public PostView() {
		// TODO Auto-generated constructor stub
	}

}
