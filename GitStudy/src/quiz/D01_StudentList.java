package quiz;

import java.util.ArrayList;
import java.util.Random;

import myobj.school.Student2;

public class D01_StudentList {

	/*
		�л� Ŭ������ ��ҷ� ���� ArrayList�� �����ϰ� �л��� 30�� �߰��غ�����
		1. �� �л��� ������ �������� �����˴ϴ�
		2. ������ ��/��/�� �ۿ� �����ϴ�
		3. 30���� ����� ������ּ���
		4. 30���� ���� ������ ���� �л��� �̸��� ������ ������ּ���
		5. �̸��� ������ ���� �����˴ϴ�
			�л�000000
			�л�000001
			�л�000002
			...
	*/
	public static void main(String[] args) {
		
//		ArrayList<Student> school = new ArrayList<>();
//		
//		int topScore;
//		for (int i = 0; i < 30; i++) {
//			school.add(new Student());
//			System.out.println("�̸�\t\t����\t���\n");
//			System.out.println(school.get(i).printScoreCard());
//			System.out.println("--------------------------------");
//		}
//		
//		System.out.println();
//		System.out.println("- - - - �ְ� ���� �л� - - - -");
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
		
		System.out.println("- - - - �ְ� ���� �л� - - - -");
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
		return String.format("�л�" + "%06d\t%d\t%.2f", studentNum++, getTotal(), getAvg());
	}
	
}

