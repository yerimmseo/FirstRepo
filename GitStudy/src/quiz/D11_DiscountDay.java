package quiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class D11_DiscountDay {

	/*
		어떤 카페에서 짝수번째 목요일 마다 할인행사를 진행한다고 가정할 때
		
		년도를 입력하면 해당 년도의 모든 할인 날짜를 출력해보세요
	*/
	
	public static void checkThursday(int whatYear) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.YEAR, whatYear);
		int count = 0;
		
		for (int month = 0; month <= now.getActualMaximum(Calendar.MONTH); month++) {
			now.set(Calendar.MONTH, month);
			
			for (int date = 1; date <= now.getActualMaximum(Calendar.DATE); date++) {
				now.set(Calendar.DATE, date);
				
				if (now.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY 
						&& now.get(Calendar.DAY_OF_WEEK_IN_MONTH) % 2 == 0) {
					count++;
					System.out.printf("%d년 %2d월 %2d일 [%d번째]\n", now.get(Calendar.YEAR),
							now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE), count);
				}
			}
		}
	}
	
	// ※ Calendar 클래스는 어떤 필드를 변경하면 나머지 필드도 상황에 맞게 알아서 업데이트 된다
	public static void printAllEventDays(int year) {
		SimpleDateFormat eventFormat = new SimpleDateFormat("yyyy년 M월 d일");
		Calendar event = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		event.set(year, 0, 1, 0, 0, 0);
		
		//for (int i = 0; i < 12; i++) {
		int count = 1;
		while (event.get(Calendar.YEAR) == year) {
			//event.set(Calendar.MONTH, i);
			
			event.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY); // 목요일로 변경
			event.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2); // 이번 달 두번째 요일로 변경
			
			System.out.printf(eventFormat.format(event.getTime()) + "\t[%d번째 행사]\n", count++);
			
//			System.out.printf("%d/%d/%d\n", 
//					event.get(Calendar.YEAR),
//					event.get(Calendar.MONTH) + 1, 
//					event.get(Calendar.DATE));
			
			event.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4); // 이번 달 네번째 요일로 설정
			
			System.out.printf(eventFormat.format(event.getTime()) + "\t[%d번째 행사]\n", count++);
			
			// add() : 원하는 필드를 원하는 수치만큼 더하거나 뺄 수 있다
			event.add(Calendar.MONTH, 1);
		}
	}
	
	public static void main(String[] args) {
		
		checkThursday(2020);
		
		int year = 2050;
		printAllEventDays(year);
	}
}








