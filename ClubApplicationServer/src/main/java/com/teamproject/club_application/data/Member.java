package com.teamproject.club_application.data;

public class Member {
    private long id;
    private String login_id;
    private String login_pw;
    private String name;
    private String birthday;
    private int gender;
    private String local;
    private String email;
    private String phone;
    private String verify;
    
    public Member() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public Member(long id, String login_id, String login_pw, String name, String birthday, int gender, String local,
			String email, String phone, String verify) {
		super();
		this.id = id;
		this.login_id = login_id;
		this.login_pw = login_pw;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.local = local;
		this.email = email;
		this.phone = phone;
		this.verify = verify;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getGender() {
		return gender;
	}
	public String getVerify() {
		return verify;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
    
    
}