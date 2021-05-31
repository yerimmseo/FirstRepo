package quiz;

import java.util.Scanner;

public class B17_CountRandomFruit {

	/*
		1. ����ڷκ��� �迭�� ũ�⸦ �Է¹޴´�
		2. �ش� ũ�⸸ŭ�� �迭�� ���� ���� ���ڿ��� �����Ѵ�
		   (�������� �����ϴ� ����: apple, banana, kiwi, orange, peach, strawberry, pineapple)
		3. �� ������ �� �� �����ߴ��� ��� ����ϰ� ����غ���
	*/
	
	public static void main(String[] args) {
		
		String[] fruitset = new String[] { "apple", "banana", "kiwi", "orange", "peach",
				"strawberry", "pineapple" };
		int[] count = new int[fruitset.length];
		
		System.out.print("�迭 ũ�� �Է� > ");
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
			System.out.printf("[%s]: %d��\n", fruitset[i], count[i]);
		}
		
	}
	
}

