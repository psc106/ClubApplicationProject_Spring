package com.teamproject.club_application.util;

import java.util.UUID;

public class Util {
	
	public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
