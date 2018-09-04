package com.teamproject.club_application.data;

public class AlbumView {
    Long id;
    Long tag_id;
    String url;
    String nickname;
    String realName;
    String create_date;
    String img_size;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTag_id() {
		return tag_id;
	}
	public void setTag_id(Long tag_id) {
		this.tag_id = tag_id;
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
	
    public AlbumView(Long id, Long tag_id, String url, String nickname, String realName, String create_date,
			String img_size) {
		super();
		this.id = id;
		this.tag_id = tag_id;
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
