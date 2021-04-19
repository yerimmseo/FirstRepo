package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_31Game {

	/*
		31게임을 만들어 보세요
		1. 컴퓨터와 사람이 번갈이가면서 숫자를 선택해야 한다.
		   (1, 2, 3밖에 선택할 수 없음)
		2. 컴퓨터는 랜덤으로 숫자를 선택한다
		3. 선공은 랜덤으로 결정한다
		4. 마지막에 31이상의 숫자를 만든 플레이어가 패배한다
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int PLAYER= 0, COMPUTER = 1;
		
		int sum = 0;
		int turn = (int)(Math.random() * 2);
		
		while (true) {
			
			if (turn == PLAYER) {
				
				int user;
				
				while (true) {
					System.out.print("당신의 턴 > ");
					user = sc.nextInt();
					if (user > 0 && user <= 3) {
						break;
					} else {
						System.out.println("잘못된 값입니다. [1, 2, 3]중에 선택해주세요");
					}
				}
				
				
				sum += user;
				
				System.out.printf("당신이 %d을 선택 [%d]\n", user, sum);
				turn = COMPUTER;
			} else if (turn == COMPUTER) {
				int com;
				if (sum % 4 == 0) {
					com = 2;
				} else if (sum % 4 == 1) {
					com = 1;
				} else if (sum % 4 == 2) {
					com = (int)(Math.random() * 3 + 1);
				} else {
					com = 3;
				}
				
				
				//int com = (int)(Math.random() * 3 + 1);
				sum += com;
				System.out.println("컴퓨터의 선택 > " + com);
				
				System.out.printf("컴퓨터가 %d을 선택 [%d]\n", com, sum);
				turn = PLAYER;
			}
			
			if (sum >= 31) {
				String winner = turn == PLAYER ? "플레이어" : "컴퓨터";
				System.out.printf("<< '%s'의 승리 >>\n", winner);
				break;
			}
		}
		
		System.out.println("게임이 끝났습니다!");

		
	}
}
