package quiz;

import java.util.Scanner;

public class B14_GCD {

	/*
		�� ���ڸ� �Է¹ް� �� ������ �ִ������� ���غ�����
		
		�� �ִ����� : �� ������ ����� �� ���� ū ����� 
	*/
	public static void main(String[] args) {
		
		System.out.print("ù��° ���� �Է� >>");
		int num1 = new Scanner(System.in).nextInt();
		
		System.out.print("�ι�° ���� �Է� >>");
		int num2 = new Scanner(System.in).nextInt();
		
		int gcd = 1;
		for (int i = 1; i <= Math.min(num1, num2); i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
			
		}
		System.out.println("�ִ� ����� " + gcd);
		
		
		
		// �� �� �� ���� ������ ��� ����� ���ϸ鼭, ���� ���ڵ� ���������� Ȯ��
//		int num1 = 30, num2 = 50;
//		int gcd = 1;
//		
//		int min = Math.min(num1, num2);
//		int max = Math.max(num1, num2);
//		
//		for (int i = min; i >= 1; i--) {
//			if (min % i == 0 && max % i == 0) {
//				gcd = i;
//				break;
//			}
//		}
//		System.out.println("�ִ� ����� " + gcd);
		
	}
	
}






