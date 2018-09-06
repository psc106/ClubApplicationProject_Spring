package com.teamproject.club_application.data;

public class MemberView {

	Long memberId;
	String loginId;
	String name;
	String birthday;
	Integer gender;
	String local;
	String phone;
	String nickname;
	String imgUrl;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public MemberView(Long memberId, String loginId, String name, String birthday, Integer gender, String local,
			String phone, String nickname, String imgUrl) {
		super();
		this.memberId = memberId;
		this.loginId = loginId;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.local = local;
		this.phone = phone;
		this.nickname = nickname;
		this.imgUrl = imgUrl;
	}
	public MemberView() {
		// TODO Auto-generated constructor stub
	}
}
