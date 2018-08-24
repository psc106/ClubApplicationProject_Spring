package com.teamproject.club_application.authorized;

import com.teamproject.club_application.data.Member;

public interface MailService {
	public void authCreate(Member member);
	public boolean authUpdate(String id, String key);
	
	public boolean findPw(String email, String id);	
}