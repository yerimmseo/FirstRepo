package quiz;

import java.util.Scanner;

public class B03_GuessAge {

	// ����ڷκ��� �¾ �ؿ� ������ �⵵�� �Է¹�����
	// �� ����� �ѱ� ���̸� ����Ͽ� �� ������ �˷��ִ� ���α׷��� ��������
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����� �¾ �ظ� �Է��ϼ��� > ");
		int bornYear = sc.nextInt();
		System.out.print("������ �⵵�� �Է��ϼ��� > ");
		int thisYear = sc.nextInt();
		
		int age = thisYear - bornYear + 1;
		System.out.println("����� �ѱ� ���̴� " + age + "�� �Դϴ�.");
		
	}
	
}
