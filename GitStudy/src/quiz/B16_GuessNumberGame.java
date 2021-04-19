package quiz;

import java.util.Random;
import java.util.Scanner;


public class B16_GuessNumberGame {

	public static void main(String[] args) {
		
		/*
			������ ���۵Ǹ� �������� 4�ڸ��� ���ڰ� �����ȴ�
			1. �÷��̾�� 8���� �õ��� �� �� �ִ�
			2. �� �õ����� 4�ڸ��� ���ڸ� �Է��ϸ� ������ ���� �˷��ش�
			   ���ڿ� ��ġ�� �� ���� ��� - Strike
			   ���ڸ� ���� ��� - Ball
			   
			ex: ������ 3456�� ��
				>> 5634		4 Ball
				>> 3789		1 Strike
				>> 3654		1 Strike 3 Ball
				
			�� ���߰� ���� ������� ������� �˷��ֱ�
		*/
		
		StringBuilder ranNum = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int size = 4;
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			ranNum.append((char)(Math.random() * 10 + '0'));
			
		}
		
		System.out.println(ranNum);
		
		System.out.println("[4�ڸ� ���� ���߱�]");
		
		
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
					System.out.println("4�ڸ� ���ڸ� �Է��ϼž� �մϴ�.");
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
				System.out.printf("�����մϴ�! ����� %d������ ������ ������ϴ�.", count);
				break;
			}
			
		}
		System.out.println("���� ����.");
		System.out.println("������ [" + ranNum + "] �����ϴ�!");
		

	}

}
