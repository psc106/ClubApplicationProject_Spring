package com.teamproject.club_application.data;

public class PostProfile {
	private Post post;
	private Profile profile;
	
	public PostProfile() {
		super();
	}

	public PostProfile(Post post, Profile profile) {
		super();
		this.post = post;
		this.profile = profile;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
}
