package seminar;

import java.util.Map;

public class AgendaDisplay {
	public static void displaySeminar(Map<String, Integer> sortedSeminar) {
		
		for (Map.Entry<String, Integer> seminar : sortedSeminar.entrySet()) {
			String time = TimeCalculation.normalTime(seminar.getValue());
            System.out.println(time + " " + seminar.getKey() + " " + seminar.getValue() + "min"); 
        } 
	}
}
 