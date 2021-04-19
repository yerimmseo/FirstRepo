package quiz;

import java.util.ArrayList;
import java.util.Random;

import myobj.school.Student2;

public class D01_StudentList {

	/*
		학생 클래스를 요소로 갖는 ArrayList를 생성하고 학생을 30명 추가해보세요
		1. 각 학생의 점수는 랜덤으로 설정됩니다
		2. 과목은 국/영/수 밖에 없습니다
		3. 30명의 평균을 출력해주세요
		4. 30명중 가장 총점이 높은 학생의 이름과 성적을 출력해주세요
		5. 이름은 다음과 같이 생성됩니다
			학생000000
			학생000001
			학생000002
			...
	*/
	public static void main(String[] args) {
		
//		ArrayList<Student> school = new ArrayList<>();
//		
//		int topScore;
//		for (int i = 0; i < 30; i++) {
//			school.add(new Student());
//			System.out.println("이름\t\t총점\t평균\n");
//			System.out.println(school.get(i).printScoreCard());
//			System.out.println("--------------------------------");
//		}
//		
//		System.out.println();
//		System.out.println("- - - - 최고 점수 학생 - - - -");
//		for (Student student : school) {
//			if (student.getTotal() == Student.maxScore) {
//				System.out.println(student.printScoreCard());
//			}
//		}
		
		ArrayList<Student2> students = new ArrayList<>();
		
		for (int i = 0; i < 30; i++) {
			students.add(new Student2());
			System.out.println(students.get(i).getTranscript());
		}
		
		System.out.println("- - - - 최고 점수 학생 - - - -");
		for (Student2 student : students) {
			if (student.getTotal() == Student2.BEST_TOTAL) {
				System.out.println(student.getTranscript());
			}
		}
	}
}

class Student {
	Random ran = new Random();
	
	static int studentNum;
	static int maxScore = 0;
	int kor;
	int eng;
	int mat;
	
	public Student() {
		kor = getRandomScore();
		eng = getRandomScore();
		mat = getRandomScore();
		maxScore = (int)(Math.max(getTotal(), maxScore));
	}
	
	int getRandomScore() {
		return (int)(ran.nextInt(101));
	}
	
	public int getTotal() {
		return kor + eng + mat;
	}
	
	public double getAvg() {
		return getTotal() / 3.0;
	}
	
	public String printScoreCard() {
		return String.format("학생" + "%06d\t%d\t%.2f", studentNum++, getTotal(), getAvg());
	}
	
}

