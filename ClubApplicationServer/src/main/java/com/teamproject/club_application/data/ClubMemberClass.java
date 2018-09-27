package com.teamproject.club_application.data;

public class ClubMemberClass {
	ClubView clubView;
	String memberClass;

	public ClubMemberClass() {
		// TODO Auto-generated constructor stub
	}

	public ClubMemberClass(ClubView clubView, String memberClass) {
		super();
		this.clubView = clubView;
		this.memberClass = memberClass;
	}

	public ClubView getClubView() {
		return clubView;
	}

	public void setClubView(ClubView clubView) {
		this.clubView = clubView;
	}

	public String getMemberClass() {
		return memberClass;
	}

	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
	

}