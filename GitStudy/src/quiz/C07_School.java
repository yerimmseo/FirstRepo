package quiz;

import myobj.school.MachineLearningStudent;
import myobj.school.NetworkStudent;
import myobj.school.ProgrammingStudent;
import myobj.school.Student;

public class C07_School {
	
	/*
		1. �� ���� ������ 30���̴�
		2-1. ���α׷��� �� �л��� ������ ����, ����, ����, ���α׷��� ��� ������ �ִ�
		2-2. ��Ʈ��ũ �� �л��� ������ ����, ����, ������, CCNA ������ �ִ�
		2-3. �ӽŷ��� �� �л��� ������ ����, ����, ����, �����, ���α׷��� ��� ������ �ִ�
		3. ��� �л��� ������ �̸��� �������� �����Ѵ�
		   �й��� �ߺ����� ���������� �����ȴ�. (�Ǵ� �ߺ����� ����)
		4. ����ǥ �޼��带 ���� �� �л��� [�̸�/����/�������]�� �� �� �ִ�
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
//		System.out.println("�̸� " + Arrays.toString(name));
//		System.out.println("����:" + Arrays.toString(total));
//		System.out.println("���:" + Arrays.toString(avg));
//	}
//}
//
//class ProgrammingClass extends Class {
//	
//	String className = "���α׷���";
//	
//	public ProgrammingClass() {
//		super();
//		System.out.printf("%s�� �Դϴ�.\n", this.className);
//	}
//}
//
//class NetworkClass extends Class {
//	
//	String ClassName = "��Ʈ��ũ";
//	
//	public NetworkClass() {
//		super();
//		System.out.printf("%s�� �Դϴ�.\n", ClassName);
//	}
//
//}
//
//class MachineLearning extends Class {
//	
//	String ClassName = "�ӽŷ���";
//	
//	int[] statistics = new int [number];
//	
//	public MachineLearning() {
//		super();
//		System.out.printf("%s�� �Դϴ�.\n", ClassName);
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
//		System.out.println("�̸� " + Arrays.toString(name));
//		System.out.println("����:" + Arrays.toString(total));
//		System.out.println("���:" + Arrays.toString(avg));
//	}
//}



