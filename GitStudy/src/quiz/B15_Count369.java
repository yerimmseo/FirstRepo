package quiz;

import java.util.Scanner;

public class B15_Count369 {

	/*
		����ڷκ��� ������ �ϳ� �Է¹ް� �ش� ���ڱ��� 369������ ����ȴٸ�
		�ڼ��� �� �� �� �ľ��ϴ��� �������
	*/
	
	public static void main(String[] args) {
		
		
		
		// ���ڿ��� Ǯ��
		
		// ������ ���ڿ��� �ٲٴ� �����
//		System.out.println("hello : " + 123);
//		System.out.println("" + 123);
//		System.out.println(Integer.toString(123));
		
		System.out.print("���� �Է� > ");
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
//					System.out.print("¦");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("�� �ڼ� Ƚ���� : " + count + "ȸ");
		
		
		// ���ڷ� Ǯ��
		for (int i = 1; i <= user; i++) {
			System.out.print(i + " : ");
			
			int numShare = i / 10;
			int numRemainder = i % 10;
			
			if (numRemainder == 3 || numRemainder == 6 || numRemainder == 9) {
				count++;
				System.out.print("¦");
			}
			if (numShare % 3 == 0 && numShare != 0) {
				count++;
				System.out.print("¦");
			}
			System.out.println();
			
		}
		System.out.println("�� �ڼ� Ƚ�� : " + count + "ȸ");		
		
	}
	
}
