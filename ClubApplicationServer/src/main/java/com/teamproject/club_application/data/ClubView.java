package com.teamproject.club_application.data;

public class ClubView {

    private long id;
    private long category_id;
    private String nickname;
    private String imgUrl;
    private String name;
    private String local;
    private int max_people;
    private int cur_people;
    private String intro;
    private  String create_date;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public int getCur_people() {
		return cur_people;
	}
	public void setCur_people(int cur_people) {
		this.cur_people = cur_people;
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
	public ClubView(long id, long category_id, String nickname, String imgUrl, String name, String local,
			int max_people, int cur_people, String intro, String create_date) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.nickname = nickname;
		this.imgUrl = imgUrl;
		this.name = name;
		this.local = local;
		this.max_people = max_people;
		this.cur_people = cur_people;
		this.intro = intro;
		this.create_date = create_date;
	}
    
    public ClubView() {
		// TODO Auto-generated constructor stub
	}
}
