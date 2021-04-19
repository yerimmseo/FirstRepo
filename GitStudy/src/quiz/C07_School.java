package quiz;

import myobj.school.MachineLearningStudent;
import myobj.school.NetworkStudent;
import myobj.school.ProgrammingStudent;
import myobj.school.Student;

public class C07_School {
	
	/*
		1. 각 반의 정원은 30명이다
		2-1. 프로그래밍 반 학생은 각자의 국어, 영어, 수학, 프로그래밍 언어 점수가 있다
		2-2. 네트워크 반 학생은 각자의 국어, 영어, 리눅스, CCNA 점수가 있다
		2-3. 머신러닝 반 학생은 각자의 국어, 영어, 수학, 통계학, 프로그래밍 언어 점수가 있다
		3. 모든 학생의 점수와 이름을 랜덤으로 생성한다
		   학번은 중복없이 순차적으로 생성된다. (또는 중복없이 랜덤)
		4. 성적표 메서드를 통해 각 학생의 [이름/총점/평균점수]를 볼 수 있다
	*/
	
	int sno;
	
	public C07_School() {
		sno = 100000;
		
		Student[] program = new Student[30];
		Student[] network = new Student[30];
		Student[] machine_leaning = new Student[30];
		
		for (int i = 0; i < program.length; i++) {
			program[i] = new ProgrammingStudent(sno++);
			program[i].printGradeCard();
		}
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println();
		
		sno = 200000;
		for (int i = 0; i < network.length; i++) {
			network[i] = new NetworkStudent(sno++);
			network[i].printGradeCard();
		}
		
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println();
		
		sno = 300000;
		for (int i = 0; i < machine_leaning.length; i++) {
			machine_leaning[i] = new MachineLearningStudent(sno++);
			machine_leaning[i].printGradeCard();
		}
	}
	
	public static void main(String[] args) {
//		Student stu = new ProgrammingStudent();
//		stu.printGradeCard();
		
		new C07_School();

	}
	
}
	
	
//-----------------------------------------------------------------------------
//	public static void main(String[] args) {
//		
//		Class pro = new ProgrammingClass();
//		pro.grade();
//		pro.gradeCard();
//		
//		System.out.println("===================================================");
//		
//		Class net = new NetworkClass();
//		net.grade();
//		net.gradeCard();
//		
//		System.out.println("===================================================");
//		
//		Class mach = new MachineLearning();
//		mach.grade();
//		mach.gradeCard();
//		
//	}
//
//}
//
//class Class {
//	
//	static int number = 30;
//	static int[] student = new int[number];
//	
//	double subj = 4.0;
//	int[] kor = new int[number];
//	int[] eng = new int[number];
//	int[] mat = new int[number];
//	int[] programming = new int[number];
//	int[] total = new int[number];
//	double[] avg = new double[number]; 
//	
//	String[] name = new String[number];
//	
//	void grade() {
//		for (int i = 0; i < student.length; i++) {
//			name[i] = " " + (char)(Math.random() * 26 + 'A');
//			kor[i] = (int)(Math.random() * 100 + 1);
//			eng[i] = (int)(Math.random() * 100 + 1);
//			mat[i] = (int)(Math.random() * 100 + 1);
//			programming[i] = (int)(Math.random() * 100 + 1);
//		}
//	}
//	
//	void gradeCard() {
//		for (int i = 0; i < student.length; i++) {
//			total[i] = kor[i] + eng[i] + mat[i] + programming[i];
//			avg[i] = Math.round((total[i] / subj) * 100 / 100.0);
//		}
//		System.out.println("이름 " + Arrays.toString(name));
//		System.out.println("총점:" + Arrays.toString(total));
//		System.out.println("평균:" + Arrays.toString(avg));
//	}
//}
//
//class ProgrammingClass extends Class {
//	
//	String className = "프로그래밍";
//	
//	public ProgrammingClass() {
//		super();
//		System.out.printf("%s반 입니다.\n", this.className);
//	}
//}
//
//class NetworkClass extends Class {
//	
//	String ClassName = "네트워크";
//	
//	public NetworkClass() {
//		super();
//		System.out.printf("%s반 입니다.\n", ClassName);
//	}
//
//}
//
//class MachineLearning extends Class {
//	
//	String ClassName = "머신러닝";
//	
//	int[] statistics = new int [number];
//	
//	public MachineLearning() {
//		super();
//		System.out.printf("%s반 입니다.\n", ClassName);
//		subj = 5;
//	}
//	
//	@Override
//	void grade() {
//		for (int i = 0; i < student.length; i++) {
//			kor[i] = (int)(Math.random() * 100 + 1);
//			eng[i] = (int)(Math.random() * 100 + 1);
//			mat[i] = (int)(Math.random() * 100 + 1);
//			programming[i] = (int)(Math.random() * 100 + 1);
//			statistics[i] = (int)(Math.random() * 100 + 1);
//		}	
//	}
//	
//	void gradeCard() {
//		for (int i = 0; i < student.length; i++) {
//			name[i] = " " + (char)(Math.random() * 26 + 'A');
//			total[i] = kor[i] + eng[i] + mat[i] + programming[i] + statistics[i];
//			avg[i] = Math.round((total[i] / subj) * 100 / 100.0);
//		}
//		System.out.println("이름 " + Arrays.toString(name));
//		System.out.println("총점:" + Arrays.toString(total));
//		System.out.println("평균:" + Arrays.toString(avg));
//	}
//}



