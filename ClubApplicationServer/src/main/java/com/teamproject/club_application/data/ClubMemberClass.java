package com.teamproject.club_application.data;


public class ClubMemberClass {
    Club club;
    String memberClass;
    
    public ClubMemberClass() {
		// TODO Auto-generated constructor stub
	}    
	public ClubMemberClass(Club club, String memberClass) {
		super();
		this.club = club;
		this.memberClass = memberClass;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public String getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
    
}