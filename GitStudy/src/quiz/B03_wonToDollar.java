package quiz;

import java.util.Scanner;

public class B03_wonToDollar {

	// 한국 돈을 입력하면 미국 달러로 환전해주는 프로그램을 만들어 보세요
	// (현재 환율은 구글 검색, 소수 둘째 자리까지 출력, 환전 수수료 1.75%)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// final이 함께 선언된 변수는 나중에 값을 변경할 수 없다
		final double WON_TO_DOLLAR = 0.00089;
		
		System.out.print("한국 돈을 입력해주세요. 달러로 바꿔드립니다. (수수료 1.75%) > ");
		int korMoney = sc.nextInt();
		
		double usd = korMoney * WON_TO_DOLLAR;
		double exchange_fee = usd * 0.0175;
		
		System.out.printf("%d원은 %.2f$ 입니다.", korMoney, usd * 0.9825);
		
	}
	
}
