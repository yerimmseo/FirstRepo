package quiz;

import java.util.Random;
import java.util.Scanner;


public class B16_GuessNumberGame {

	public static void main(String[] args) {
		
		/*
			게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다
			1. 플레이어는 8번의 시도를 할 수 있다
			2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다
			   숫자와 위치가 다 맞을 경우 - Strike
			   숫자만 맞을 경우 - Ball
			   
			ex: 정답이 3456일 때
				>> 5634		4 Ball
				>> 3789		1 Strike
				>> 3654		1 Strike 3 Ball
				
			※ 맞추고 나면 몇번만에 맞췄는지 알려주기
		*/
		
		StringBuilder ranNum = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int size = 4;
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			ranNum.append((char)(Math.random() * 10 + '0'));
			
		}
		
		System.out.println(ranNum);
		
		System.out.println("[4자리 숫자 맞추기]");
		
		
		while (count < 8) {
			int ball = 0, strike = 0;
			String user;
			
			while (true) {
				System.out.print(">> ");
				user = sc.next();
				
				boolean vaild = true;
				
				if (user.length() != 4) {
					vaild = false;
				}
				
				for (int i = 0; vaild && i < 4; i++) {
					if (user.charAt(i) < '0' || user.charAt(i) > '9') {
						vaild = false;
					}
				}
				
				if (vaild) {
					break;
				} else {
					System.out.println("4자리 숫자만 입력하셔야 합니다.");
				}
			}
			count++;
			
			for (int i = 0; i < 4; i++) {

				if (ranNum.charAt(i) == user.charAt(i)) {
					strike++;
				} else {
					for (int j = 0; j < 4; j++) {
						if (ranNum.charAt(i) == user.charAt(j)) {
							ball++;
						}
					}
				}
			}
			
			if (strike != 0) {
				System.out.printf("%d Strike ", strike);
			}
			if (ball != 0) {
				System.out.printf("%d Ball", ball);
			}
			System.out.println();
			
			if (strike == 4) {
				System.out.printf("축하합니다! 당신은 %d번만에 정답을 맞췄습니다.", count);
				break;
			}
			
		}
		System.out.println("게임 종료.");
		System.out.println("정답은 [" + ranNum + "] 였습니다!");
		

	}

}
