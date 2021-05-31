package quiz;

import java.util.Scanner;

public class B15_Count369 {

	/*
		사용자로부터 정수를 하나 입력받고 해당 숫자까지 369게임이 진행된다면
		박수를 총 몇 번 쳐야하는지 세어보세요
	*/
	
	public static void main(String[] args) {
		
		
		
		// 문자열로 풀기
		
		// 정수를 문자열로 바꾸는 방법들
//		System.out.println("hello : " + 123);
//		System.out.println("" + 123);
//		System.out.println(Integer.toString(123));
		
		System.out.print("숫자 입력 > ");
		int user = new Scanner(System.in).nextInt();
		int count = 0;
		
//		for (int i = 1; i <= user; i++) {
//			String num_str = i + "";
//
//			System.out.print(i + ": ");
//			
//			for (int j = 0; j < num_str.length(); j++) {
//				char num_ch = num_str.charAt(j);
//				
//				if (num_ch == '3' || num_ch == '6' || num_ch == '9') {
//					count++;
//					System.out.print("짝");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("총 박수 횟수는 : " + count + "회");
		
		
		// 숫자로 풀기
		for (int i = 1; i <= user; i++) {
			System.out.print(i + " : ");
			
			int numShare = i / 10;
			int numRemainder = i % 10;
			
			if (numRemainder == 3 || numRemainder == 6 || numRemainder == 9) {
				count++;
				System.out.print("짝");
			}
			if (numShare % 3 == 0 && numShare != 0) {
				count++;
				System.out.print("짝");
			}
			System.out.println();
			
		}
		System.out.println("총 박수 횟수 : " + count + "회");		
		
	}
	
}
