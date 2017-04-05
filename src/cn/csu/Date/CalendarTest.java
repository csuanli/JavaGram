package cn.csu.Date;

import java.util.Calendar;

/**
 * @file CalendarTest.java
 * @author 李岸
 * @version 1.0
 * @since Oct 13, 2010
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar date=Calendar.getInstance();
		String year="Year: "+date.get(Calendar.YEAR);
		String month="month: "+date.get(Calendar.MONTH);
		String day="day: "+date.get(Calendar.DATE);
		String dow="DAY_OF_WEEK: "+date.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(dow);
	}

}
