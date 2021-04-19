package quiz;

import java.util.Scanner;

public class B06_ScoreToGrade {
	/*
		������ �Է¹����� ������ �ش��ϴ� ����� ������ִ� ���α׷��� �ۼ��غ�����.
		
		90�� �̻� : A���
		80�� �̻� : B���
		70�� �̻� : C���
		60�� �̻� : D���
		�� �� : F���
		�� ��ȿ�� ������ 0 ~ 100�� �Դϴ�.
	*/
	public static void main(String[] args) {
		
		//int score = new Scanner(System.in).nextInt();
		Scanner sc = new Scanner(System.in);
		int score;
		
		System.out.print("������ �Է��ϼ��� > ");
		score = sc.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.println("�߸��� ������ �Է��ϼ̽��ϴ�.");
		} else {
			char grade = 'F';
			
			if (score >= 90) {
				grade = 'A';
			} else if (score >= 80) {
				grade = 'B';
			} else if (score >= 70) {
				grade = 'C';
			} else if (score >= 60) {
				grade = 'D';
			} 
			
			System.out.printf("����� ������ %d������ [%c]����Դϴ�.\n", score, grade);
		}
		
	}
	
}









