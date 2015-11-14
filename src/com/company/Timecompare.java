package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by sarleon on 15-11-14.
 */
public class Timecompare {
    Calendar calendar=new GregorianCalendar();
    int year =calendar.get(Calendar.YEAR);
    int month =calendar.get(Calendar.MONTH)+1;
    int day=calendar.get(Calendar.DAY_OF_MONTH);
}
