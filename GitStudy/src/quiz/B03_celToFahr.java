package quiz;

import java.util.Scanner;

public class B03_celToFahr {
	// 사용자로부터 섭씨 온도를 입력받으면
	// 화씨 온도로 변환하여 출력해주는 프로그램을 만들어보세요
	// (변환 공식은 구글 검색, 출력은 소수 첫째 자리 까지)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨(℃)온도를 입력하세요 > ");
		double cel = sc.nextDouble();
		double fahr = (cel * 9/5) + 32;
		
		System.out.printf("%.1f℃는 %.1f℉입니다.", cel, fahr);
		
	}

}

