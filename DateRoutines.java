package routines;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class DateRoutines {
	/**
     * convertDate: Takes the input date (String), input date format, and expected
     * date format and converts the date into the output format.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("inputDate") input: The string representation of the date you want converted.
     * 
     * {param} string("inputDateFormat") input: The format that the date is currently in.
     * 
     * {param} string("ouputDateFormat") input: The format that you want the date in.
     * 
     * {example} stringToInt("03-08-1990", "MM-dd-yyyy", "yyyyMMdd") # 19900308.
     */
    public static String convertDate(String inputDate, String inputDateFormat
    		,String outputDateFormat) {
    	if(inputDate != null && inputDate.replaceAll("\\W", "").length()>0){
        	DateFormat inDateFormat = new SimpleDateFormat(inputDateFormat);
        	DateFormat outDateFormat = new SimpleDateFormat(outputDateFormat);
    		try{
    			Date inDate = inDateFormat.parse(inputDate);
    			String outDate = outDateFormat.format(inDate);
    			return(outDate);
    		}
    		catch(ParseException e){
    			e.printStackTrace();
    			return "Date Error";
    		}
    	} else {
    		return "";
    	}
    }
    
	/**
     * convertDate: Takes only the input date (String) and input date format 
     * and converts the date into yyyyMMdd format.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("inputDate") input: The string representation of the date you want converted.
     * 
     * {param} string("inputDateFormat") input: The format that the date is currently in.
     * 
     * {example} stringToInt("03-08-1990", "MM-dd-yyyy") # 19900308.
     */
    public static String convertDate(String inputDate, String inputDateFormat) {
    	if(inputDate != null && inputDate.replaceAll("\\W", "").length()>0){
        	DateFormat inDateFormat = new SimpleDateFormat(inputDateFormat);
        	DateFormat outDateFormat = new SimpleDateFormat("yyyyMMdd");
    		try{
    			Date inDate = inDateFormat.parse(inputDate);
    			String outDate = outDateFormat.format(inDate);
    			return(outDate);
    		}
    		catch(ParseException e){
    			e.printStackTrace();
    			return "Date Error";
    		}
    	} else {
    		return "";
    	}
    }
    
	/**
     * convertExcelDate: Takes the input date (String) and expected
     * date format and converts the date into that format.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("inputDate") input: The string representation of the Excel date you want converted.
     * 
     * {param} string("ouputDateFormat") input: The format that you want the date in.
     * 
     * {example} stringToInt("THU MAR 08 00:00:00 EST 1990", "yyyyMMdd") # 19900308.
     */
    public static String convertExcelDate(String inputDate, String outputDateFormat) {
    	if(inputDate != null && inputDate.replaceAll("\\W", "").length()>0){
        	DateFormat inDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        	DateFormat outDateFormat = new SimpleDateFormat(outputDateFormat);
    		try{
    			Date inDate = inDateFormat.parse(inputDate);
    			String outDate = outDateFormat.format(inDate);
    			return(outDate);
    		}
    		catch(ParseException e){
    			e.printStackTrace();
    			return "Date Error";
    		}
    	} else {
    		return "";
    	}
    }
    
    /**
     * convertExcelDate: Takes the input date (String) into "yyyyMMdd" format.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("inputDate") input: The string representation of the Excel date you want converted.
     * 
     * {example} stringToInt("THU MAR 08 00:00:00 EST 1990") # 19900308.
     */
    public static String convertExcelDate(String inputDate) {
    	if(inputDate != null && inputDate.replaceAll("\\W", "").length()>0){
        	DateFormat inDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        	DateFormat outDateFormat = new SimpleDateFormat("yyyyMMdd");
    		try{
    			Date inDate = inDateFormat.parse(inputDate);
    			String outDate = outDateFormat.format(inDate);
    			return(outDate);
    		}
    		catch(ParseException e){
    			e.printStackTrace();
    			return "Date Error";
    		}
    	} else {
    		return "";
    	}
    }
public static String testDate(){ return null;}
}
