package quiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class D11_DiscountDay {

	/*
		� ī�信�� ¦����° ����� ���� ������縦 �����Ѵٰ� ������ ��
		
		�⵵�� �Է��ϸ� �ش� �⵵�� ��� ���� ��¥�� ����غ�����
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
					System.out.printf("%d�� %2d�� %2d�� [%d��°]\n", now.get(Calendar.YEAR),
							now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE), count);
				}
			}
		}
	}
	
	// �� Calendar Ŭ������ � �ʵ带 �����ϸ� ������ �ʵ嵵 ��Ȳ�� �°� �˾Ƽ� ������Ʈ �ȴ�
	public static void printAllEventDays(int year) {
		SimpleDateFormat eventFormat = new SimpleDateFormat("yyyy�� M�� d��");
		Calendar event = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		event.set(year, 0, 1, 0, 0, 0);
		
		//for (int i = 0; i < 12; i++) {
		int count = 1;
		while (event.get(Calendar.YEAR) == year) {
			//event.set(Calendar.MONTH, i);
			
			event.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY); // ����Ϸ� ����
			event.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2); // �̹� �� �ι�° ���Ϸ� ����
			
			System.out.printf(eventFormat.format(event.getTime()) + "\t[%d��° ���]\n", count++);
			
//			System.out.printf("%d/%d/%d\n", 
//					event.get(Calendar.YEAR),
//					event.get(Calendar.MONTH) + 1, 
//					event.get(Calendar.DATE));
			
			event.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4); // �̹� �� �׹�° ���Ϸ� ����
			
			System.out.printf(eventFormat.format(event.getTime()) + "\t[%d��° ���]\n", count++);
			
			// add() : ���ϴ� �ʵ带 ���ϴ� ��ġ��ŭ ���ϰų� �� �� �ִ�
			event.add(Calendar.MONTH, 1);
		}
	}
	
	public static void main(String[] args) {
		
		checkThursday(2020);
		
		int year = 2050;
		printAllEventDays(year);
	}
}








