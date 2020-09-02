package seminar;

import java.util.ArrayList;

public class AgendaDisplay {
	public static void displaySeminar(ArrayList<String> seminarWithTime) {
		
		for (int i = 0; i < seminarWithTime.size(); i++) {
			System.out.println(seminarWithTime.get(i));
		}
		
		
	}
}
 