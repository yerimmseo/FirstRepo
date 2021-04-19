package quiz;

import java.util.Scanner;

public class B08_ConvertSecond {
	
	/*
		�ʸ� �Է¹����� ��/��/�ð�/��/�ʷ� ��ȯ�Ͽ� ����غ�����
		
		�� �ʿ���� ������ ������� ����
		ex: 0�� 0�� 5�ð� 0�� 20���� ��� 0�� 0���� ������ �ʾƾ� ��
	*/
	
	public static void main(String[] args) {
		
		System.out.print("�ʸ� �Է��ϼ��� > ");
		int second = new Scanner(System.in).nextInt();

		// 1�� : 60 * 60 * 24 * 365 ��
		// 1�� : 60 * 60 * 24 ��
		// 1�ð� : 60 * 60 ��
		// 1�� : 60 ��
		final int SECOND_PER_YEAR = 60 * 60 * 24 * 365;
		final int SECOND_PER_DAY = 60 * 60 * 24;
		final int SECOND_PER_HOUR = 60 * 60;
		final int SECOND_PER_MINUTE = 60;

		
		int y = 0, d = 0, h = 0, m = 0, s = 0;
		int original = second;
		// 90,000,000��

		// 31,536,000
		y = second / SECOND_PER_YEAR;
		second %= SECOND_PER_YEAR;
		
		d = second / SECOND_PER_DAY;
		second %= SECOND_PER_DAY;
		
		h = second / SECOND_PER_HOUR;
		second %= SECOND_PER_HOUR;
		
		m = second / SECOND_PER_MINUTE;
		second %= SECOND_PER_MINUTE;
		
		s = second;
		
//		System.out.printf("'%d'�ʴ� ��ȯ�ϸ� '%d�� %d�� %d�ð� %d�� %d���Դϴ�."
//				, original, y, d, h, m, s);
		
		System.out.printf("'%d'�ʴ� ��ȯ�ϸ� ", original);
		
		boolean exist = false;
		
		if (y != 0) {
			System.out.print(y + "�� ");
			exist = true;
		}
		if (exist || d != 0) {
			System.out.print(d + "�� ");
			exist = true;
		}
		if (exist || h != 0) {
			System.out.print(h + "�ð� ");
			exist = true;
		}
		if (exist || m != 0) {
			System.out.print(m + "�� ");
		}
		System.out.print(s + "�� �Դϴ�.");
	
	}

}










