package seminar;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCalculation {
	static int calHour = 0;
	static int calMinute = 0;
	static int startHour = 9;
	static int startMinute = 0;
	static int n = 1;
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
	
	public static int setHour(int hr) {
		startHour = hr;
		return startHour;
	}
	
	public static int setMinute(int min) {
		startMinute = min;
		return startMinute;
	}
	
	public static int calculateHour(int userMinute) {
		LocalTime time = LocalTime.of(startHour, startMinute);
		int newHour = (userMinute + startMinute) / 60;
		calHour = time.getHour() + newHour;
		startHour = calHour;
		return calHour;
	}
	
	public static int calculateMinute(int userMinute) {
		calMinute = (userMinute + startMinute) % 60;
		startMinute = calMinute;
		return calMinute;
	}

	public static LocalTime setBeginTime() {
		return LocalTime.of(startHour, startMinute);
	}
	
	public static LocalTime setEndTime(int userMinute) {
		int endHr = calculateHour(userMinute);
		int endMin = calculateMinute(userMinute);
		return LocalTime.of(endHr, endMin);
	}
	
	public static String setBeginSeminarTime (int userMinute) {
 		LocalTime beginT = setBeginTime();
		setEndTime(userMinute);

		return beginT.format(dtf); //+ EndTime(userMinute) 
	}
	
	public static LocalTime setBeginSeminarLocalTime (int userMinute) {
		LocalTime beginT = setBeginTime();
		return beginT;
	}
	
	public static String setLunchTime() {
		LocalTime setLunchTime = LocalTime.of(12, 0);
		setHour(13);
		setMinute(0);
		return setLunchTime.format(dtf);
	}
	
	public static String setNETime() {
		LocalTime setNETime = LocalTime.of(startHour, startMinute);
		setHour(9);
		setMinute(0);
		return setNETime.format(dtf);
	}
}
