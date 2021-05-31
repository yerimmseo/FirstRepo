package quiz;

import java.util.Scanner;

public class B17_CountRandomFruit {

	/*
		1. 사용자로부터 배열의 크기를 입력받는다
		2. 해당 크기만큼의 배열에 랜덤 과일 문자열을 저장한다
		   (랜덤으로 등장하는 과일: apple, banana, kiwi, orange, peach, strawberry, pineapple)
		3. 각 과일이 몇 번 등장했는지 모두 기록하고 출력해본다
	*/
	
	public static void main(String[] args) {
		
		String[] fruitset = new String[] { "apple", "banana", "kiwi", "orange", "peach",
				"strawberry", "pineapple" };
		int[] count = new int[fruitset.length];
		
		System.out.print("배열 크기 입력 > ");
		int size = new Scanner(System.in).nextInt();
		
		
		
		String[] fruit = new String[size];
		
		for (int i = 0; i < fruit.length; i++) {
			int mix = (int)(Math.random() * fruitset.length);
			fruit[i] = fruitset[mix];
			System.out.print(fruit[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < fruit.length; i++) {
			
			for (int j = 0; j < fruitset.length; j++) {
				if (fruit[i].equals(fruitset[j])) {
					count[j]++;
				}
			}
		}
		
		for (int i = 0; i < fruitset.length; i++) {
			System.out.printf("[%s]: %d번\n", fruitset[i], count[i]);
		}
		
	}
	
}

