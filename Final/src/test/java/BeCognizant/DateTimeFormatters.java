package BeCognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatters {
	
	// Date format convertor
	
	public static String convertDateFormat(String inputDate)
	{
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("M/dd/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");

            Date date = inputFormat.parse(inputDate);
            String outputDate = outputFormat.format(date);

            return outputDate;
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }	
	
	// Time Format convertor
	
	public static String formatTime(LocalTime time)
	{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return time.format(formatter).replaceFirst("^0", "");
    }
}
