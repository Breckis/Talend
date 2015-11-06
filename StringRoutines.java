package routines;

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
public class StringRoutines {


	/**
	 * getStringPosition: returns the substring of a string between two positions.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("field") input: The string need to be printed.
	 * 
	 * {param} integer(first) input: The starting position 
	 * 
	 * {param} integer (last) input: The ending position
	 * 
	 * {example} getStringPosition("email", 2,4) # ai.
	 */
	public static String stringPosition(String field, int start, int end) {
		if(field != null){
			if(field.length() >= end)
				return(field.substring(start, end));
			else
				return "End position exceeds string length";
		} else {
			return null;
		}
	}

	/**
	 * intToString: returns the String version of an integer.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("intVar") input: The integer variable that need to be converted.
	 * 
	 * {example} intToString(22) # "22".
	 */
	public static String intToString(Integer intVar) {
		if(intVar != null)
			return(Integer.toString(intVar));
		else
			return null;
	}

	/**
	 * doubleToString: returns the String version of a double.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("doubleVar") input: The double variable that need to be converted.
	 * 
	 * {example} doubleToString(22.1231) # "22.1231".
	 */
	public static String doubleToString(double doubleVar) {
		return(Double.toString(doubleVar));
	}

	/**
	 * stringToInt: returns the integer version of a string.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("stringVar") input: The string that need to be converted.
	 * 
	 * {example} stringToInt("22.1231") # 22.
	 */
	public static int stringToInt(String stringVar) {
		if(stringVar != null)
			return(Integer.parseInt(stringVar));
		else
			return 0;
	}

	/**
	 * stringToDouble: returns the double version of a string.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("stringVar") input: The string that need to be converted.
	 * 
	 * {example} stringToDouble("22.1231") # 22.1231.
	 */
	public static double stringToDouble(String doubleVar) {
		if(doubleVar != null)
			return(Double.parseDouble(doubleVar));
		else
			return 0.0;
	}

	/**
	 * addDecimals: adds two decimal places into a string value.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("valueAmount") input: The number that needs decimals added.
	 *  
	 * {example} addDecimals("123456") # "1234.56".
	 */
	public static String addDecimals(String valueAmount) {
		if(valueAmount != null && valueAmount.length() > 2)
			return(valueAmount.substring(0,valueAmount.length() - 2) + "." 
					+ valueAmount.substring(valueAmount.length() - 2, valueAmount.length()));
		else
			return(valueAmount);
	}    

	/**
	 * addDecimals: adds a specified amount of decimals into a string value.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("valueAmount") input: The number that needs decimals added.
	 * 
	 * {param} integer(numberOfDecimalPlaces) input: The number of decimal places needed.
	 * 
	 * {example} addDecimals("123456", 3) # "123.456".
	 */
	public static String addDecimals(String valueAmount, int numberOfDecimalPlaces) {
		if(valueAmount != null && valueAmount.length() > numberOfDecimalPlaces)
			return(valueAmount.substring(0,valueAmount.length() - numberOfDecimalPlaces) + "."
					+ valueAmount.substring(valueAmount.length() - numberOfDecimalPlaces,valueAmount.length()));
		else
			return(valueAmount);
	}

	/**
	 * removeCharacters: removes specified characters from a string.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("fieldString") input: The full field that has characters to be removed.
	 *
	 * {param} string[]("fieldString") input: The list of characters that need to be removed (can be infinite)
	 * 
	 * {example} addDecimals("123456") # "1234.56".
	 */
	public static String removeCharacters(String fieldString, String... args) {
		if(fieldString == null)
			return null;
		else{
			for(String arg : args){
				fieldString = fieldString.replaceAll(arg,"");
			}
			return fieldString;
		}
	}

	/**
	 * convertIBMField: Converts the last character in an IBM Signed Field into a digit.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string("stringValue") input: The field that is in an IBM Signed integer format.
	 * 
	 * {example} convertIBMField(0000000A) # 00000001.
	 */
	public static String convertIBMField(String stringValue){
		if(stringValue == null)
			return null;
		else{
			try{
				char last = stringValue.charAt(stringValue.length()-1);
				switch(last) {
				case 'A': 
					stringValue=stringValue.replace("A","1");
					break;
				case 'B': 
					stringValue=stringValue.replace("B","2");
					break;
				case 'C': 
					stringValue=stringValue.replace("C","3");
					break;
				case 'D': 
					stringValue=stringValue.replace("D","4");
					break;
				case 'E': 
					stringValue=stringValue.replace("E","5");
					break;
				case 'F': 
					stringValue=stringValue.replace("F","6");
					break;
				case 'G': 
					stringValue=stringValue.replace("G","7");
					break;
				case 'H': 
					stringValue=stringValue.replace("H","8");
					break;
				case 'I': 
					stringValue=stringValue.replace("I","9");
					break;
				case '{': 
					stringValue=stringValue.replace("{","0");
					break;
				case '}': 
					stringValue="-"+stringValue.replace("}","0");
					break;
				case 'J': 
					stringValue="-"+stringValue.replace("J","1");
					break;
				case 'K': 
					stringValue="-"+stringValue.replace("K","2");
					break;
				case 'L': 
					stringValue="-"+stringValue.replace("L","3");
					break;
				case 'M': 
					stringValue="-"+stringValue.replace("M","4");
					break;
				case 'N': 
					stringValue="-"+stringValue.replace("N","5");
					break;
				case 'O': 
					stringValue="-"+stringValue.replace("O","6");
					break;
				case 'P': 
					stringValue="-"+stringValue.replace("P","7");
					break;
				case 'Q': 
					stringValue="-"+stringValue.replace("Q","8");
					break;
				case 'R': 
					stringValue="-"+stringValue.replace("R","9");
					break;
				}
				return stringValue;
			}
			catch (Exception e) {
				return "Bad input";
			}
		}
	}

	/**
	 * partialString: returns the part of a field between the first position (0), and last position.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string(fieldString) input: The full field that contains the partial String.
	 *
	 * {param} int(startPos) input: The starting position of the partial string
	 *   
	 * {param} int(endPos) input: The ending position of the partial string
	 * 
	 * {example} partialString("inputField",0,3) # "par".
	 */
	public static String partialString(String fieldString, int startPos, int endPos) {
		if(fieldString == null)
			return null;
		else
			return fieldString.substring(startPos, endPos);
	}

	/**
	 * partialString: returns the part of a field between the first position (0), and the first
	 * occurrence of a character.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string(fieldString) input: The full field that contains the partial String.
	 *
	 * {param} int(startPos) input: The starting position of the partial string
	 *   
	 * {param} String("endPos") input: The first occurrence of a character that will end the partial string
	 * 
	 * {example} partialString("inputFi3ld",0,"3") # "inputFi3".
	 */
	public static String partialString(String fieldString, int startPos, String endPos) {
		if(fieldString == null)
			return null;
		else if(!fieldString.contains(endPos))
			return "endPos not found";
		else{
			try{
				return fieldString.substring(startPos, fieldString.indexOf(endPos));
			} catch (Exception e){
				return "endPos found before startPos";
			}

		}

	}

	/**
	 * partialString: returns the part of a field between the first position (0), and the first
	 * occurrence of a character.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string(fieldString) input: The full field that contains the partial String.
	 *
	 * {param} String("startChar") input: The first occurrence of a character that starts
	 * the partial String
	 *   
	 * {param} int(endPos) input: The ending position of the partial string
	 * 
	 * {example} partialString("inputFi3ld","3",10) # "3ld".
	 */
	public static String partialString(String fieldString, String startPos, int endPos) {
		if(fieldString == null)
			return null;
		else if(!fieldString.contains(startPos))
			return "startPos not found";
		else if(fieldString.length() >= endPos){
			try{
				return fieldString.substring(fieldString.indexOf(startPos)+1, endPos);
			} catch (Exception e){
				return "endPos found before startPos";
			}
		}else
			return "Make endPos smaller";
	}
}