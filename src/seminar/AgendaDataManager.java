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
	
	public static ArrayList<String> includeTimeInSeminar(Map<String, Integer> seminarMap) {
		ArrayList<String> seminarWithTime = new ArrayList<>();
		for (Map.Entry<String, Integer> seminar : seminarMap.entrySet()) {
			
			seminarWithTime.add(TimeCalculation.setBeginSeminarTime(seminar.getValue()) + " " + seminar.getKey() + " " + seminar.getValue() + "min");
			
			if (TimeCalculation.startHour == 12) {
				seminarWithTime.add(TimeCalculation.setLunchTime() + " " + "Lunch");
			}
				
			if (TimeCalculation.startHour >= 16 && TimeCalculation.startHour <= 17 && TimeCalculation.newMinute(seminar.getValue()) >= 60) {
				seminarWithTime.add(TimeCalculation.setNETime() + " " + "Networking Event" + "\n");
			}
				
        }
		return seminarWithTime;
	}
}
