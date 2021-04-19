package quiz;

import java.util.Scanner;

public class B08_ConvertSecond {
	
	/*
		초를 입력받으면 년/일/시간/분/초로 변환하여 출력해보세요
		
		※ 필요없는 단위는 출력하지 말것
		ex: 0년 0일 5시간 0분 20초인 경우 0년 0일은 나오지 않아야 함
	*/
	
	public static void main(String[] args) {
		
		System.out.print("초를 입력하세요 > ");
		int second = new Scanner(System.in).nextInt();

		// 1년 : 60 * 60 * 24 * 365 초
		// 1일 : 60 * 60 * 24 초
		// 1시간 : 60 * 60 초
		// 1분 : 60 초
		final int SECOND_PER_YEAR = 60 * 60 * 24 * 365;
		final int SECOND_PER_DAY = 60 * 60 * 24;
		final int SECOND_PER_HOUR = 60 * 60;
		final int SECOND_PER_MINUTE = 60;

		
		int y = 0, d = 0, h = 0, m = 0, s = 0;
		int original = second;
		// 90,000,000초

		// 31,536,000
		y = second / SECOND_PER_YEAR;
		second %= SECOND_PER_YEAR;
		
		d = second / SECOND_PER_DAY;
		second %= SECOND_PER_DAY;
		
		h = second / SECOND_PER_HOUR;
		second %= SECOND_PER_HOUR;
		
		m = second / SECOND_PER_MINUTE;
		second %= SECOND_PER_MINUTE;
		
		s = second;
		
//		System.out.printf("'%d'초는 변환하면 '%d년 %d일 %d시간 %d분 %d초입니다."
//				, original, y, d, h, m, s);
		
		System.out.printf("'%d'초는 변환하면 ", original);
		
		boolean exist = false;
		
		if (y != 0) {
			System.out.print(y + "년 ");
			exist = true;
		}
		if (exist || d != 0) {
			System.out.print(d + "일 ");
			exist = true;
		}
		if (exist || h != 0) {
			System.out.print(h + "시간 ");
			exist = true;
		}
		if (exist || m != 0) {
			System.out.print(m + "분 ");
		}
		System.out.print(s + "초 입니다.");
	
	}

}










