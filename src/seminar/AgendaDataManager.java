package seminar;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AgendaDataManager {
	public static Map<String, Integer> sortSeminar(Map<String, Integer> seminarMap) {
		
		// Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > seminarList = 
               new LinkedList<Map.Entry<String, Integer>>(seminarMap.entrySet()); 
  
        // Sort the list 
        Collections.sort(seminarList, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hash map  
        HashMap<String, Integer> sortedSeminar = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> seminarDetail : seminarList) { 
        	sortedSeminar.put(seminarDetail.getKey(), seminarDetail.getValue()); 
        } 
        
        return sortedSeminar; 
		
	}
}
