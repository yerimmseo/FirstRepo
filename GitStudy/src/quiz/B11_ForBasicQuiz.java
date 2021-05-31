package quiz;

import java.util.Scanner;

public class B11_ForBasicQuiz {

	/*
		사용자가 숫자를 입력했을 때
		1. 10부터 입력한 숫자까지의 총 합을 구해보세요
		2. 1부터 입력한 숫자 사이의 5의 배수만 모두 출력해보세요
	*/
	public static void main(String[] args) {
		
//		// 1번 문제의 시작 숫자는 10, 2번 문제의 시작 숫자는 1
//		int start1 = 10, start2 = 1;
//		
//		System.out.print("숫자 입력 > ");
//		int end1 = new Scanner(System.in).nextInt();
//		int end2 = end1;
//		int sum = 0;
//		
//		// 만약 start값이 end값 보다 크다면, 두 값을 교환한다
//		if (start1 > end1) {
//			int tmp = start1;
//			start1 = end1;
//			end1 = tmp;
//		}
//		
//		for (int i = start1; i <= end1; ++i) {
//			sum += i;
//		}
//		System.out.printf("10부터 %d까지의 총 합은 %d입니다.\n", start1 > end1 ? end1 : start1, sum);
//		
//		System.out.println();
//		System.out.printf("### 1부터 %d사이의 5의 배수만 출력 ###\n", start2 > end2 ? end2 : start2);
//		
//		if (start2 > end2) {
//			int tmp = start2;
//			start2 = end2;
//			end2 = tmp;
//		}
//		for (int i = start2; i <= end2; ++i) {
//			if (i % 5 == 0) {
//				System.out.print(i + " ");
//			}
//		}
		
		int start1 = 10, start2 = 1;
		
		System.out.print("숫자 입력 > ");
		int user = new Scanner(System.in).nextInt();
		
		int sum = 0;
		
		for (int i = Math.min(start1, user); i <= Math.max(start1, user); i++) {
			sum += i;
		}
		System.out.printf("%d부터 %d까지의 합은 %d입니다.\n", 
				Math.min(start1, user), Math.max(start1, user), sum);
		
		
		System.out.printf("[%d부터 %d까지 5의 배수는]\n", Math.min(start2, user),
				Math.max(start2, user));
		for (int i = Math.min(start2, user); i <= Math.max(start2, user); i++) {
			
			if (i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	
}
