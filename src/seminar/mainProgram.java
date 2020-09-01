package seminar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mainProgram {
	public static void main(String[] args) throws IOException {
		
		//full text file
		ArrayList<String> fileTextList = new ArrayList<>(AgendaDataReader.readTextFile());
		
		//text map that already split to seminar name & seminar minute
		Map<String, Integer> seminarMap = new HashMap<String, Integer>(AgendaDataUtility.tranformSeminarData(fileTextList));
		
		//sorted text map by ascending order
		Map<String, Integer> sortedSeminarMap = AgendaDataManager.sortSeminar(seminarMap);
		
		AgendaDisplay.displaySeminar(sortedSeminarMap);
	}
}
