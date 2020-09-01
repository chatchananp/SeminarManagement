package seminar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AgendaDataReader {
	public static ArrayList<String> readTextFile() throws IOException {
		ArrayList<String> seminarArray = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
									"src/textFile/demo.txt"));) {
			String strLine = br.readLine();
			while (strLine != null) {
				seminarArray.add(strLine);
				strLine = br.readLine();
			}
		}

		return seminarArray;
	}
}
