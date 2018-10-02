package com.teamproject.club_application.data;

public class AlbumView {
	long id;
    String url;
    String nickname;
    String realName;
    String create_date;
    String img_size;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getImg_size() {
		return img_size;
	}
	public void setImg_size(String img_size) {
		this.img_size = img_size;
	}
	
    public AlbumView(long id, String url, String nickname, String realName, String create_date,
			String img_size) {
		super();
		this.id = id;
		this.url = url;
		this.nickname = nickname;
		this.realName = realName;
		this.create_date = create_date;
		this.img_size = img_size;
	}
	public AlbumView() {
		// TODO Auto-generated constructor stub
	}

}
