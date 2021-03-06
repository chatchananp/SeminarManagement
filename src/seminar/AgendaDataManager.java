package seminar;

import java.time.LocalTime;
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
		ArrayList<LocalTime> seminarLocalTime = new ArrayList<>();
		for (Map.Entry<String, Integer> seminar : seminarMap.entrySet()) {
			
			seminarWithTime.add(TimeCalculation.setBeginSeminarTime(seminar.getValue()) + " " + seminar.getKey() + " " + seminar.getValue() + "min");
			seminarLocalTime.add(TimeCalculation.setBeginSeminarLocalTime(seminar.getValue()));
			
			if (TimeCalculation.setBeginSeminarLocalTime(seminar.getValue()).compareTo(LocalTime.of(12, 0)) == 0) {
				seminarWithTime.add(TimeCalculation.setLunchTime() + " " + "Lunch");
				seminarLocalTime.add(TimeCalculation.setBeginSeminarLocalTime(seminar.getValue()));
			}
				
			if (TimeCalculation.setBeginSeminarLocalTime(seminar.getValue()).compareTo(LocalTime.of(16, 0)) > 0 && TimeCalculation.setBeginSeminarLocalTime(seminar.getValue()).compareTo(LocalTime.of(17, 0)) < 0 && TimeCalculation.startMinute + seminar.getValue() > 60) {
				seminarWithTime.add(TimeCalculation.setNETime() + " " + "Networking Event" + "\n");
				seminarLocalTime.add(TimeCalculation.setBeginSeminarLocalTime(seminar.getValue()));
			}
				
        }
		
		if (seminarLocalTime.get(seminarLocalTime.size() - 1).compareTo(LocalTime.of(16, 0)) > 0 && seminarLocalTime.get(seminarLocalTime.size() - 1).compareTo(LocalTime.of(17, 0)) < 0) {
			seminarWithTime.add(TimeCalculation.setNETime() + " " + "Networking Event" + "\n");
		}
		
		return seminarWithTime;
	}
}
