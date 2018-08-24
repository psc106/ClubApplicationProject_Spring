package com.teamproject.club_application.data;

public class Alarm {
    private long id;
    private long member_id;
    private long reference_id;
    private int type;
    
    public Alarm() {
		// TODO Auto-generated constructor stub
	}
    

	public Alarm(long id, long member_id, long reference_id, int type) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.reference_id = reference_id;
		this.type = type;
	}



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

	public long getReference_id() {
		return reference_id;
	}

	public void setReference_id(long reference_id) {
		this.reference_id = reference_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
}
