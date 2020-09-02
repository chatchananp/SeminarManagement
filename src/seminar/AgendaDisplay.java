package seminar;

import java.util.Map;

public class AgendaDisplay {
	public static void displaySeminar(String time, Map<String, Integer> sortedSeminar) {
		
		for (Map.Entry<String, Integer> seminar : sortedSeminar.entrySet()) {
            System.out.println(time + " " + seminar.getKey() + " " + seminar.getValue() + "min"); 
        }
	}
}
 