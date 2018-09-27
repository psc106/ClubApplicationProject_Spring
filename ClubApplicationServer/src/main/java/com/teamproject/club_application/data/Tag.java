package com.teamproject.club_application.data;

public class Tag {
	long id;
	long club_id;
	String name;
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public Tag(long id, long club_id, String name) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
