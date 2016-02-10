package routines;

public class PolicyImportCleaning {

	/**
	 * cleanField: Enables better fuzzy matching.
	 * 
	 * 
	 * {talendTypes} String
	 * 
	 * {Category} User Defined
	 * 
	 * {param} string(fieldName) input: Name of the field that is to be cleaned.
	 * 
	 * {example} cleanField(row1.Names).
	 */
	public static String cleanField(String fieldName) {
		if(fieldName != null){

			fieldName = fieldName.replaceAll("(?i)Co[^m]","Company");
			fieldName = fieldName.replaceAll("(?i)Co$","Company");
			fieldName = fieldName.replaceAll("(?i)UW[^a-zA-Z] ","Underwriters");
			fieldName = fieldName.replaceAll("(?i)UW$","Underwriters");
			String replacements[] = {"via", "Via", "LLC", "Ins[^a-zA-Z]", "(?i)inc[^a-zA-Z]", "(?i)inc$"};
			for(int i = 0; i < replacements.length; i++)
				fieldName = fieldName.replaceAll(replacements[i], "") ;
			fieldName = fieldName.replaceAll("[^a-zA-Z0-9]","");
		}
		return fieldName;
	}
}
