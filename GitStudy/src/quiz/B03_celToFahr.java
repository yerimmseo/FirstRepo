package quiz;

import java.util.Scanner;

public class B03_celToFahr {
	// ����ڷκ��� ���� �µ��� �Է¹�����
	// ȭ�� �µ��� ��ȯ�Ͽ� ������ִ� ���α׷��� ��������
	// (��ȯ ������ ���� �˻�, ����� �Ҽ� ù° �ڸ� ����)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����(��)�µ��� �Է��ϼ��� > ");
		double cel = sc.nextDouble();
		double fahr = (cel * 9/5) + 32;
		
		System.out.printf("%.1f�ɴ� %.1f���Դϴ�.", cel, fahr);
		
	}

}

