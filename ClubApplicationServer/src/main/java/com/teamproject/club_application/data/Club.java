package com.teamproject.club_application.data;

public class Club {

    private long id;
    private long category_id;
    private long member_id;
    private long image_id;
    private String name;
    private String local;
    private int max_people;
    private String intro;
    private  String create_date;
    
    public Club() {
		// TODO Auto-generated constructor stub
	}
    
    

	public Club(long id, long category_id, long member_id, long image_id, String name, String local, int max_people,
			String intro, String create_date) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.member_id = member_id;
		this.image_id = image_id;
		this.name = name;
		this.local = local;
		this.max_people = max_people;
		this.intro = intro;
		this.create_date = create_date;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public long getImage_id() {
		return image_id;
	}

	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getMax_people() {
		return max_people;
	}

	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
    
    
}
