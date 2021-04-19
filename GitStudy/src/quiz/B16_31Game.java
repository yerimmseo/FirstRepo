package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_31Game {

	/*
		31������ ����� ������
		1. ��ǻ�Ϳ� ����� �����̰��鼭 ���ڸ� �����ؾ� �Ѵ�.
		   (1, 2, 3�ۿ� ������ �� ����)
		2. ��ǻ�ʹ� �������� ���ڸ� �����Ѵ�
		3. ������ �������� �����Ѵ�
		4. �������� 31�̻��� ���ڸ� ���� �÷��̾ �й��Ѵ�
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
					System.out.print("����� �� > ");
					user = sc.nextInt();
					if (user > 0 && user <= 3) {
						break;
					} else {
						System.out.println("�߸��� ���Դϴ�. [1, 2, 3]�߿� �������ּ���");
					}
				}
				
				
				sum += user;
				
				System.out.printf("����� %d�� ���� [%d]\n", user, sum);
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
				System.out.println("��ǻ���� ���� > " + com);
				
				System.out.printf("��ǻ�Ͱ� %d�� ���� [%d]\n", com, sum);
				turn = PLAYER;
			}
			
			if (sum >= 31) {
				String winner = turn == PLAYER ? "�÷��̾�" : "��ǻ��";
				System.out.printf("<< '%s'�� �¸� >>\n", winner);
				break;
			}
		}
		
		System.out.println("������ �������ϴ�!");

		
	}
}
