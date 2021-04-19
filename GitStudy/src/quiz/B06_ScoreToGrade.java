package quiz;

import java.util.Scanner;

public class B06_ScoreToGrade {
	/*
		점수를 입력받으면 점수에 해당하는 등급을 출력해주는 프로그램을 작성해보세요.
		
		90점 이상 : A등급
		80점 이상 : B등급
		70점 이상 : C등급
		60점 이상 : D등급
		그 외 : F등급
		※ 유효한 점수는 0 ~ 100점 입니다.
	*/
	public static void main(String[] args) {
		
		//int score = new Scanner(System.in).nextInt();
		Scanner sc = new Scanner(System.in);
		int score;
		
		System.out.print("점수를 입력하세요 > ");
		score = sc.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.println("잘못된 점수를 입력하셨습니다.");
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
			
			System.out.printf("당신의 점수는 %d점으로 [%c]등급입니다.\n", score, grade);
		}
		
	}
	
}









