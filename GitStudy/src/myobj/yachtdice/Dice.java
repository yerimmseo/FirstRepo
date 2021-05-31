package myobj.yachtdice;

import java.util.Arrays;
import java.util.Random;

public class Dice {

	private int[] dice = new int[5];
	private int[] count = new int[6];
	private Random ran;
	
	public Dice() {
		ran = new Random();
		for (int i = 0; i < dice.length; i++) {
			dice[i] = getRandom();
		}
	}
	
	private int getRandom() {
		return (int)(Math.random() * 6 + 1);
	}
	
	public void throwDice() {
		for (int i = 0; i < dice.length; i++) {
			System.out.printf("%d ", dice[i]);
		}
		System.out.println();
	}
		
	public void checkDice() {
		for (int i = 0; i < dice.length; i++) {
			for (int j = 0; j <= count.length; j++) {
				if (dice[i] == j + 1) {
					count[j]++;
				}
			}
		}
		//System.out.println(Arrays.toString(count));
	}
	
	public void checkFullHouse() {
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count.length; j++) {
				if (count[i] == 2 && count[j] == 3) {
					System.out.println("Full House");
				}
			}
		}
	}
	
	public void checkLittleStraight() {
//		int check = 0;
//		for (int i = 0; i < count.length; i++) {
//			if (count[i] == 1) {
//				check++;
//			}
//		}
//		if (check == 4) {
//			for (int j = 0; j < dice.length; j++) {
//				
//			}
//		}
	}
	
	public void chechBigStraight() {
		int check = 0;
		int check2 = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 1) {
				check++;
			}
		}
		if (check == 5) {
			for (int j = 0; j < dice.length - 1; j++) {
				if (dice[j + 1] == dice[j] + 1) {
					check2++;
				}
			}
		}
		if (check2 == 4) {
			System.out.println("Big Straight!!");
		}
	}
	
	public void checkFourDice() {
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 4) {
				System.out.println("4 of a Kind");
			}
		}
	}
	
	public void checkYacht() {
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 5) {
				System.out.println("Yacht~");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Dice dice = new Dice();
		dice.throwDice();
		dice.checkDice();
		dice.checkFullHouse();
		dice.checkFourDice();
		dice.checkYacht();
		dice.chechBigStraight();
	}
	
}
