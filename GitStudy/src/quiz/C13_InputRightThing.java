package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import myobj.MyScanner;

public class C13_InputRightThing {

	/*
		����ڷκ��� ���ڸ� ����� �Է¹��� �� ���� ��� �Է¹޴� ���α׷��� ��������
		(�߸��� ���� �ԷµǾ �������� ���� �ʰ�, �ùٸ� ���� �ԷµǸ� ��� �� ���α׷��� ����)
	*/
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		int num;
//		
//		while (true) {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("���ڸ� �Է��ϼ��� > ");
//			try {
//				num = sc.nextInt();
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("�߸� �Է���");
//			}
//		}
//		System.out.println("�Է��Ͻ� ���ڴ� " + num);
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		while (true) {
//			try {
//				System.out.print("���� > ");
//				int num = sc.nextInt();
//				System.out.println("�Է��Ͻ� ���� " + num + "�Դϴ�.");
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("�߸��� �Է��Դϴ�.");
//				String stuck = sc.nextLine();
//				System.out.println("�ɷ��ִ� �� ��: " + stuck);
//			}
//		}
//		System.out.println("���α׷��� ���������� ����Ǿ����ϴ�.");

		
		int a = inputInt("���� > ");
		int b = inputInt("�ι�° ���� > ");
		int c = MyScanner.inputInt("����° ���� > ");
		
		System.out.println("input�Լ��� �Է¹��� ��: " + a);
		System.out.println("���α׷��� ���������� ����Ǿ����ϴ�.");
		
	}
	
	public static int inputInt(String message) {
		int num;
		
		while (true) {
			try {
				System.out.print(message);
				num = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		}
		
		//sc.close();// ���̻� ���� ���� ��ĳ�ʸ� ����(System.in�� close�� ���� �ʴ� ���� ����)
		
		return num;
	}
}
