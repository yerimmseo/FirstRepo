package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import myobj.MyScanner;

public class C13_InputRightThing {

	/*
		사용자로부터 숫자를 제대로 입력받을 때 까지 계속 입력받는 프로그램을 만들어보세요
		(잘못된 값이 입력되어도 강제종료 되지 않고, 올바른 값이 입력되면 출력 후 프로그램이 종료)
	*/
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		int num;
//		
//		while (true) {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("숫자만 입력하세요 > ");
//			try {
//				num = sc.nextInt();
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("잘못 입력함");
//			}
//		}
//		System.out.println("입력하신 숫자는 " + num);
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		while (true) {
//			try {
//				System.out.print("숫자 > ");
//				int num = sc.nextInt();
//				System.out.println("입력하신 값은 " + num + "입니다.");
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("잘못된 입력입니다.");
//				String stuck = sc.nextLine();
//				System.out.println("걸려있던 걸 뺌: " + stuck);
//			}
//		}
//		System.out.println("프로그램이 정상적으로 종료되었습니다.");

		
		int a = inputInt("숫자 > ");
		int b = inputInt("두번째 숫자 > ");
		int c = MyScanner.inputInt("세번째 숫자 > ");
		
		System.out.println("input함수로 입력받은 값: " + a);
		System.out.println("프로그램이 정상적으로 종료되었습니다.");
		
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
		
		//sc.close();// 더이상 쓰지 않을 스캐너를 삭제(System.in은 close를 하지 않는 것이 좋음)
		
		return num;
	}
}
