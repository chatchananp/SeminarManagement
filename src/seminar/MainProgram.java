package seminar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainProgram {
	public static void main(String[] args) throws IOException {
		
		//read "demo.txt" file
		ArrayList<String> seminarTextList = new ArrayList<>(AgendaDataReader.readTextFile());
		
		/*
		 * send seminarTextList to tranformSeminarData method in AgendaDataUtility class
		 * for split seminar to seminar name & seminar minute
		*/
		Map<String, Integer> seminarMap = new HashMap<String, Integer>(AgendaDataUtility.tranformSeminarData(seminarTextList));
		
		//sort seminar by minute in descending order
		Map<String, Integer> sortedSeminarMap = AgendaDataManager.sortSeminar(seminarMap);
		
		//add begin time to each seminar
		ArrayList<String> seminarWithTime = AgendaDataManager.includeTimeInSeminar(sortedSeminarMap);
		
		//display seminar with begin time
		AgendaDisplay.displaySeminar(seminarWithTime);
		
		
	}
}
