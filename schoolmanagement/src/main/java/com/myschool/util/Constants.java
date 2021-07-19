package com.myschool.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Constants {
	
	public static final int MAX_STUDENTS_FOR_COURSE = 50;
	public static final int MAX_COURSES_FOR_STUDENT = 5;
	
	public static Date convertStringToDate(String dateInStringddMMMyyyy) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		Date date = formatter.parse(dateInStringddMMMyyyy);
		return date;
	}
	
	public static String covertDateToString(Date date) {
		String pattern = "dd-MMM-yyyy";

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);

		// Get the today date using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String todayAsString = df.format(today);
		return todayAsString;
	}

}
