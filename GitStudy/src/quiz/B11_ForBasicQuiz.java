package quiz;

import java.util.Scanner;

public class B11_ForBasicQuiz {

	/*
		����ڰ� ���ڸ� �Է����� ��
		1. 10���� �Է��� ���ڱ����� �� ���� ���غ�����
		2. 1���� �Է��� ���� ������ 5�� ����� ��� ����غ�����
	*/
	public static void main(String[] args) {
		
//		// 1�� ������ ���� ���ڴ� 10, 2�� ������ ���� ���ڴ� 1
//		int start1 = 10, start2 = 1;
//		
//		System.out.print("���� �Է� > ");
//		int end1 = new Scanner(System.in).nextInt();
//		int end2 = end1;
//		int sum = 0;
//		
//		// ���� start���� end�� ���� ũ�ٸ�, �� ���� ��ȯ�Ѵ�
//		if (start1 > end1) {
//			int tmp = start1;
//			start1 = end1;
//			end1 = tmp;
//		}
//		
//		for (int i = start1; i <= end1; ++i) {
//			sum += i;
//		}
//		System.out.printf("10���� %d������ �� ���� %d�Դϴ�.\n", start1 > end1 ? end1 : start1, sum);
//		
//		System.out.println();
//		System.out.printf("### 1���� %d������ 5�� ����� ��� ###\n", start2 > end2 ? end2 : start2);
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
		
		System.out.print("���� �Է� > ");
		int user = new Scanner(System.in).nextInt();
		
		int sum = 0;
		
		for (int i = Math.min(start1, user); i <= Math.max(start1, user); i++) {
			sum += i;
		}
		System.out.printf("%d���� %d������ ���� %d�Դϴ�.\n", 
				Math.min(start1, user), Math.max(start1, user), sum);
		
		
		System.out.printf("[%d���� %d���� 5�� �����]\n", Math.min(start2, user),
				Math.max(start2, user));
		for (int i = Math.min(start2, user); i <= Math.max(start2, user); i++) {
			
			if (i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	
}
