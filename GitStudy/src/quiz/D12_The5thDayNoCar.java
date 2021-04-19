package quiz;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class D12_The5thDayNoCar {

	/*
		���� 5���� the 5th-day-no-driving system
		  ����ȣ ������
		�� 1, 6
		ȭ 2, 7
		�� 3, 8
		�� 4, 9
		�� 5, 0
		�� ������ / �޹��� ���� ����
		�� �������� / �����, �ӻ�� �� ���Ƶ���, ���� ��
		
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
	
	public final static HoliDay newYear = new HoliDay("����", "01-01");
	public final static HoliDay samIlJeol = new HoliDay("������", "03-01");
	public final static HoliDay childrensDay = new HoliDay("��̳�", "05-05");
	public final static HoliDay memorialDay = new HoliDay("������", "06-06");
	public final static HoliDay liverationDay = new HoliDay("������", "08-15");
	public final static HoliDay foundationDay = new HoliDay("��õ��", "10-03");
	public final static HoliDay hangulDay = new HoliDay("�ѱ۳�", "10-09");
	public final static HoliDay christmas = new HoliDay("��ź��", "12-25");

	public final static String[] CAR_TYPE = {"����� ����", "�ӻ�� ����", "���� ���� ����", "����",
			"ordinary", "ordinary", "ordinary", "ordinary", "ordinary"};
	public final static HoliDay[] holidays = {newYear, samIlJeol, childrensDay, memorialDay,
			liverationDay, foundationDay, hangulDay, christmas};
	
	static int[] carNumber;
	static String typeOfCar;
	
	public static void yoursCarNumber() {
		carNumber = new int[4];
		typeOfCar = CAR_TYPE[(int)(Math.random() * CAR_TYPE.length)];
		
		System.out.print("[������ȣ: ");
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
				//System.out.println("5���� ��� ������ �ƴմϴ�");
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
			System.out.println("���� ����� ������ 5���� ����Դϴ�");
		}
	}
	
	
	public static void checkNoDrivingDay() {
		yoursCarNumber();

		Calendar today = Calendar.getInstance();
		//today.set(2021, 7, 15);
		int todayWhatDay = today.get(Calendar.DAY_OF_WEEK);
		
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy�� M�� d�� EEEEE");
		System.out.println(f1.format(today.getTime()));
		
		if (checkHoliday(holidays)) {
			System.out.println("������ ������ �Դϴ�");
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






