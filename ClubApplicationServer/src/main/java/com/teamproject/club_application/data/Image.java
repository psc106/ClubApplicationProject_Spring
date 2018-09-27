package com.teamproject.club_application.data;

public class Image {
	private long id;
	private String img_db_name;
	private String img_ori_name;
	
	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Image(long id, String img_db_name, String img_ori_name) {
		super();
		this.id = id;
		this.img_db_name = img_db_name;
		this.img_ori_name = img_ori_name;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImg_db_name() {
		return img_db_name;
	}

	public void setImg_db_name(String img_db_name) {
		this.img_db_name = img_db_name;
	}

	public String getImg_ori_name() {
		return img_ori_name;
	}

	public void setImg_ori_name(String img_ori_name) {
		this.img_ori_name = img_ori_name;
	}
	
}
