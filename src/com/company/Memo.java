package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

/**
 * Created by sarleon on 15-11-14.
 */
public class Memo {
	int number;
    int year;
    int month;
    int day;
    int hour;
    int minute;
    String place;
    IMP importance;
	public Memo(int number, int year, int month, int day, 
			int hour, int minute, String place, IMP importance) {
		this.number = number;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.place = place;
		this.importance = importance;
	}




	

}
