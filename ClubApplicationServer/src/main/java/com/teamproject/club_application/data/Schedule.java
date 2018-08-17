package com.teamproject.club_application.data;

public class Schedule {
    private long id;
    private  long club_id;
    private  long member_id;
    private  String place;
    private  int cost;
    private  String intro;
    private  String start_date;
    private  String create_date;
    
    public Schedule() {
	}
	    
	public Schedule(long id, long club_id, long member_id, String place, int cost, String intro, String start_date,
			String create_date) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.member_id = member_id;
		this.place = place;
		this.cost = cost;
		this.intro = intro;
		this.start_date = start_date;
		this.create_date = create_date;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
    
    
}
