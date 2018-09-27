package com.teamproject.club_application.data;

public class ClubMember {
	private long id;
	private long club_id;
	private long member_id;
	private String verify;
	
	public ClubMember() {
		
	}
	
	public ClubMember(long id, long club_id, long member_id, String verify) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.member_id = member_id;
		this.verify = verify;
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

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}
	
	
	
	
}
