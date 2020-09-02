package seminar;

import java.util.Map;

public class AgendaDisplay {
	public static void displaySeminar(Map<String, Integer> sortedSeminar) {
		
		for (Map.Entry<String, Integer> seminar : sortedSeminar.entrySet()) { 
            System.out.println(TimeCalculation.normalTime(seminar.getValue()) + " " + seminar.getKey() + " " + seminar.getValue() + "min"); 
        } 
	}
}
 