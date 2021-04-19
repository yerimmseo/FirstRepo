package theory;
import java.util.Scanner;

public class B15_While {

	public static void main(String[] args) {
		
		/*
			# while
			- for문과 사용법이 약간 다른 반복문
			- 초기값과 증가값의 위치가 정해져 있지 않다
			- ()안의 조건이 참인 동안 {}안의 내용을 반복한다
		*/
		
		// # while문의 가장 기본적인 형태
		int i = 0;
		
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		
		// # while문은 증가값의 위치에 따라 결과가 달라질 수 있다
		i = 0;
		
		while (i++ < 10) {
			System.out.println("반복문2: " + i);
		}
		
		/*
			# while문과 사용하기 좋게끔 설계된 클래스들이 있다
			- has, next등의 수식어가 붙은 함수(메서드)를 가지고 있다
			- Scanner 등
		*/
		
		Scanner sc1 = new Scanner("apple banana orange");
		Scanner sc2 = new Scanner("1234 1588 1541 111 222 333 444 555");
		
		// Scanner.hasNext() - 다음 값이 있으면 true, 없으면 false
		while (sc1.hasNext()) {
			// Scanner.next() - 다음 하나의 값을 String타입으로 꺼낸다
			System.out.println(sc1.next());
		}
		
		while (sc2.hasNextInt()) {
			System.out.println(sc2.nextInt());
		}
		
		
		
	}
	
}









