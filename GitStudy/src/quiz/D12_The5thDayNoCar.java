package quiz;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class D12_The5thDayNoCar {

	/*
		차량 5부제 the 5th-day-no-driving system
		  끝번호 쉬는차
		월 1, 6
		화 2, 7
		수 3, 8
		목 4, 9
		금 5, 0
		※ 공휴일 / 휴무일 적용 제외
		※ 제외차량 / 장애인, 임산부 및 유아동승, 경차 등
		
	*/
	private static class NoDriving {
		int[] endCarNum;
		
		private NoDriving(int n1, int n2) {
			this.endCarNum = new int[] {n1, n2};
		}
	}
	
	private static class HoliDay {
		String name;
		int month;
		int day;
		
		private HoliDay(String name, String date) {
			this.name = name;
			this.month = Integer.parseInt(date.substring(0, 2));
			this.day = Integer.parseInt(date.substring(3));
		}
	}
	
	public static NoDriving monday = new NoDriving(1, 6);
	public static NoDriving tuesday = new NoDriving(2, 7);
	public static NoDriving wednesday = new NoDriving(3, 8);
	public static NoDriving thursday = new NoDriving(4, 9);
	public static NoDriving friday = new NoDriving(5, 0);
	
	public final static HoliDay newYear = new HoliDay("설날", "01-01");
	public final static HoliDay samIlJeol = new HoliDay("삼일절", "03-01");
	public final static HoliDay childrensDay = new HoliDay("어린이날", "05-05");
	public final static HoliDay memorialDay = new HoliDay("현충일", "06-06");
	public final static HoliDay liverationDay = new HoliDay("광복절", "08-15");
	public final static HoliDay foundationDay = new HoliDay("개천절", "10-03");
	public final static HoliDay hangulDay = new HoliDay("한글날", "10-09");
	public final static HoliDay christmas = new HoliDay("성탄절", "12-25");

	public final static String[] CAR_TYPE = {"장애인 차량", "임산부 차량", "유아 동승 차량", "경차",
			"ordinary", "ordinary", "ordinary", "ordinary", "ordinary"};
	public final static HoliDay[] holidays = {newYear, samIlJeol, childrensDay, memorialDay,
			liverationDay, foundationDay, hangulDay, christmas};
	
	static int[] carNumber;
	static String typeOfCar;
	
	public static void yoursCarNumber() {
		carNumber = new int[4];
		typeOfCar = CAR_TYPE[(int)(Math.random() * CAR_TYPE.length)];
		
		System.out.print("[차량번호: ");
		for (int i = 0; i < 4; i++) {
			carNumber[i] += ((int)(Math.random() * 10));
			System.out.print(carNumber[i]);
		}
		System.out.println("]");
		if (!typeOfCar.equals("ordinary")) {
			System.out.printf("[%s]\n", typeOfCar);
		}
	}
	
	public static boolean checkTypeOfCar() {
		for (int i = 0; i <= 3; i++) {
			if (typeOfCar.contains(CAR_TYPE[i])) {
				//System.out.println("5부제 대상 차량이 아닙니다");
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkHoliday(HoliDay[] holidays) {
		LocalDate todayDate = LocalDate.now();
		//LocalDate todayDate = LocalDate.of(2021, 8, 15);
		LocalDate holiday;
		for (int i = 0; i < holidays.length; i++) {
			holiday = LocalDate.of(todayDate.getYear(), holidays[i].month, holidays[i].day);
			if (todayDate.isEqual(holiday)) {
				return true;
			}
		}
		return false;
	}
	
	public static void checkCarEndNumber(NoDriving day) {
		if (carNumber[3] == day.endCarNum[0] || carNumber[3] == day.endCarNum[1]) {
			System.out.println("오늘 당신의 차량은 5부제 대상입니다");
		}
	}
	
	
	public static void checkNoDrivingDay() {
		yoursCarNumber();

		Calendar today = Calendar.getInstance();
		//today.set(2021, 7, 15);
		int todayWhatDay = today.get(Calendar.DAY_OF_WEEK);
		
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy년 M월 d일 EEEEE");
		System.out.println(f1.format(today.getTime()));
		
		if (checkHoliday(holidays)) {
			System.out.println("오늘은 공휴일 입니다");
			return;
		} 
		
		if (todayWhatDay == Calendar.SATURDAY || todayWhatDay == Calendar.SUNDAY 
				|| checkTypeOfCar()) {
			return;
		} else {
			switch(todayWhatDay) {
			case Calendar.MONDAY:
				checkCarEndNumber(monday);
				break;
			case Calendar.TUESDAY:
				checkCarEndNumber(tuesday);
				break;
			case Calendar.WEDNESDAY:
				checkCarEndNumber(wednesday);
				break;
			case Calendar.THURSDAY:
				checkCarEndNumber(thursday);
				break;
			case Calendar.FRIDAY:
				checkCarEndNumber(friday);
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {

		checkNoDrivingDay();
		
	}
}






