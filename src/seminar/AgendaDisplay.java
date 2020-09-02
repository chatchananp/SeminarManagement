package seminar;

import java.util.ArrayList;

public class AgendaDisplay {
	public static void displaySeminar(ArrayList<String> fullSeminar) {
		
		for (int i = 0; i < fullSeminar.size(); i++) {
			System.out.println(fullSeminar.get(i));
		}
		
		
	}
}
 