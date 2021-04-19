package quiz;

import java.util.Scanner;

public class B14_Prime {
	
	/*
		����ڷ� ���� ���ڸ� �Է¹�����
		1���� �Է��� ���� ���̿� �����ϴ� �Ҽ��� ��� ����غ�����
		
		�� �Ҽ� : 1�� �ڱ� �ڽ����θ� ������ �������� ��
		  ex: 7, 11, 13, 17 ...
	*/
	public static void main(String[] args) {
		
		System.out.print("�Ҽ� ã�� > ");
		int num = new Scanner(System.in).nextInt();
		
		// 1�� �ڱ��ڽ��� �����ϰ� �˻縦 ���� count�� �߻����ڸ��� �Ҽ��� �ƴ��� �� �� �ִ�.
		for (int check = 2; check <= num; check++) {
			int count = 0;

			for (int div = 2; div <= Math.sqrt(check); div++) {
				if (check % div == 0) {
					count++;
					break; // �˻縦 �� ������ �ʿ䰡 ����
				}
			}
			if (count == 0) {
				System.out.print(check + " ");
			}
		}
		
		
	}

}
