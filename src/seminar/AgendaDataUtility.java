package seminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgendaDataUtility {
	
	public static Map<String, Integer> tranformSeminarData(ArrayList<String> fileText) {
		Map<String, Integer> seminarSplitMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < fileText.size(); i++) {
			String seminarName = fileText.get(i);
			
			String patternString1 = "(.*) (\\d+)min";

	        Pattern pattern = Pattern.compile(patternString1);
	        Matcher matcher = pattern.matcher(seminarName);

	        while(matcher.find()) {
	        	String n1 = matcher.group(1);
	        	String n2 = matcher.group(2);
	        	int minute = Integer.parseInt(n2);
	        	
	        	seminarSplitMap.put(n1, minute);
	        }
		}
		return seminarSplitMap;
		
	}
}
