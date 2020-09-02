package seminar;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCalculation {
	int minute = 0;
	static int calHour = 0;
	static int calMinute = 0;
	static int startHour = 9;
	static int startMinute = 0;
	int n = 1;
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
	
	public static LocalTime seminarTime(int startH, int startM) {
		return LocalTime.of(startH, startM);
	}
	
	public int setHour(int hr) {
		startHour = hr;
		return startHour;
	}
	
	public int setMinute(int min) {
		startMinute = min;
		return startMinute;
	}
	
	public static int calHour(int userMinute) {
		LocalTime time = LocalTime.of(startHour, startMinute);
		int newHour = (userMinute + startMinute) / 60;
		calHour = time.getHour() + newHour;
		startHour = calHour;
		return calHour;
	}
	
	public static int calMinute(int userMinute) {
		calMinute = (userMinute + startMinute) % 60;
		startMinute = calMinute;
		return calMinute;
	}

	public static LocalTime setBeginTime(int userMinute) {
		return seminarTime(startHour, startMinute);
	}
	
	public static LocalTime setEndTime(int userMinute) {
		int endHr = calHour(userMinute);
		int endMin = calMinute(userMinute);
		return seminarTime(endHr, endMin);
	}
	
	public static String normalTime (int userMinute) {
		LocalTime beginT = setBeginTime(userMinute);
		setEndTime(userMinute);

		return beginT.format(dtf); //+ EndTime(userMinute) 
	}
	
	void setLunchTime(int userMinute) {
		LocalTime setLunchTime = seminarTime(12, 0);
		System.out.print(setLunchTime.format(dtf) + " ");
		setHour(13);
		setMinute(0);
	}
	
	void setNETime(int userMinute) {
		LocalTime setNETime = seminarTime(startHour, startMinute);
		System.out.print(setNETime.format(dtf) + " ");
		setHour(9);
		setMinute(0);
		n++;
	}
}