package com.teamproject.club_application.data;

import java.util.ArrayList;

public class CalendarSchedule {
    String day;
    ArrayList<Schedule> todaySchedule;
    public CalendarSchedule() {
		// TODO Auto-generated constructor stub
	}
    
	public CalendarSchedule(String day, ArrayList<Schedule> todaySchedule) {
		super();
		this.day = day;
		this.todaySchedule = todaySchedule;
	}

	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public ArrayList<Schedule> getTodaySchedule() {
		return todaySchedule;
	}
	public void setTodaySchedule(ArrayList<Schedule> todaySchedule) {
		this.todaySchedule = todaySchedule;
	}
    
    
}
