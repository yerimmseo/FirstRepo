package quiz;

import java.util.Scanner;

public class B14_Prime {
	
	/*
		사용자로 부터 숫자를 입력받으면
		1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해보세요
		
		※ 소수 : 1과 자기 자신으로만 나누어 떨어지는 수
		  ex: 7, 11, 13, 17 ...
	*/
	public static void main(String[] args) {
		
		System.out.print("소수 찾기 > ");
		int num = new Scanner(System.in).nextInt();
		
		// 1과 자기자신을 제외하고 검사를 진행 count가 발생하자마자 소수가 아님을 알 수 있다.
		for (int check = 2; check <= num; check++) {
			int count = 0;

			for (int div = 2; div <= Math.sqrt(check); div++) {
				if (check % div == 0) {
					count++;
					break; // 검사를 더 진행할 필요가 없다
				}
			}
			if (count == 0) {
				System.out.print(check + " ");
			}
		}
		
		
	}

}
