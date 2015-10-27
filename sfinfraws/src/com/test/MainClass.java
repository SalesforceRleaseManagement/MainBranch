package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainClass {

	public static void main(String[] args) throws Exception {
		Calendar calendar = new GregorianCalendar();

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR); // 12 hour clock
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		test2();
	}

	public static void test(){
		 Calendar calendar = Calendar.getInstance();
         TimeZone tz = TimeZone.getDefault();
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
         
         Date currenTimeZone = (Date) calendar.getTime();
         System.out.println(sdf.format(currenTimeZone));
         resetCalender(calendar);
         calendar.clear();
        
         currenTimeZone = (Date) calendar.getTime();
         System.out.println(sdf.format(currenTimeZone));
         
	}
	
	public static void test2(){
		String myFormatString = "yyyyMMdd";
		SimpleDateFormat df = new SimpleDateFormat(myFormatString);
		try {
			Date date1 = df.parse("");
			System.out.println(df.format(date1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Calendar resetCalender(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.YEAR, 0001);
        calendar.set(Calendar.MONTH, 00);
        calendar.set(Calendar.DATE, 00);
        calendar.set(Calendar.MILLISECOND, 0);
        
        /*String dateStr = "00000102";
        System.out.println(dateStr);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse("00000102");
        String convertedStr = dateFormat.format(date);
        System.out.println(convertedStr);
        */
        
        return calendar;
    }
	
	public static Calendar resetCalender1(Calendar calendar) {
        calendar.set(Calendar.YEAR, 0);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}