package seminar;

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
	
	public static String showTime(Map<String, Integer> seminarMap) {
		String time = null;
		for (Map.Entry<String, Integer> seminar : seminarMap.entrySet()) {
			time = TimeCalculation.normalTime(seminar.getValue());
        }
		
		return time;
	}
}
