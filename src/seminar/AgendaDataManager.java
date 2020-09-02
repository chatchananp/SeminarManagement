package seminar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AgendaDataManager {
	public static Map<String, Integer> sortSeminar(Map<String, Integer> seminarMap) {
		
        return seminarMap.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
		
	}
	
	public static ArrayList<String> showTime(Map<String, Integer> seminarMap) {
		ArrayList<String> fullSeminar = new ArrayList<>();
		for (Map.Entry<String, Integer> seminar : seminarMap.entrySet()) {
			fullSeminar.add(TimeCalculation.normalTime(seminar.getValue()) + " " + seminar.getKey() + " " + seminar.getValue() + "min"); 
        }
		return fullSeminar;
	}
}
