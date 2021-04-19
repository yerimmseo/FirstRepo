package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class D05_Poker {
	
	/*
		포커를 구현해보세요
	*/
	public static void main(String[] args) {
		
//		Coffee c = new Coffee(null, 1, 1, null);
//		
//		ArrayList<Integer> numbers = new ArrayList<>();
//		
//		
//		numbers.add(1);
//		numbers.add(3);
//		numbers.add(5);
//		numbers.add(7);
//		numbers.add(9);
//		
//		HashSet<Integer> answer = new HashSet<>();
//		
//		answer.add(3);
//		answer.add(5);
//		answer.add(7);
//		
//		System.out.println("numbers가 answer를 전부 포함하고 있는가? " + numbers.containsAll(answer));
		
		Card cd1 = new Card();
		cd1.makeCard();
		cd1.check();
		
		Card cd2 = new Card();
		cd2.makeCard();
		cd2.check();
		
		Card cd3 = new Card();
		cd3.makeCard();
		cd3.check();
	}

}

class Card {
	
	private static String[] shape = {"♠", "◆", "♥", "♣"};
	private static String[] numberList = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	private Random ran;
	private HashSet<String> card;
	private ArrayList<String> card_list;
	private int[] numberCheck;
	private int[] shapeCheck;
	private int kindShape;
	
	public Card() {
		ran = new Random();
		card = new HashSet<>();
	}
	
	public void check() {
		checkNum();
		checkShape();
		kindShape();
		
		if (kindShape == 1 && checkRoyal()) {
			System.out.println("Royal Flush!!!");
		} else if (kindShape == 1 && checkStraight()) {
			System.out.println("Straight Flush!!!");
		} else if (numContains(4)) {
			System.out.println("Four of a kind!");
		} else if (numContains(2) && numContains(3)) {
			System.out.println("Full House!");
		} else if (kindShape == 1) {
			System.out.println("Flush");
		} else if (checkRoyal() || checkStraight()) {
			System.out.println("Straight");
		} else if (numContains(3)) {
			System.out.println("Three Of a kind");
		} else if (checkTwoPair()) {
			System.out.println("Two Pair");
		} else if (numContains(2)) {
			System.out.println("One Pair");
		} else {
			checkHighCard();
		}
	}
	
	private boolean checkRoyal() {
		if (numberCheck[0] > 0 && numberCheck[9] > 0 && numberCheck[10] > 0 && numberCheck[11] > 0
				&& numberCheck[12] > 0) {
			return true;
		}
		return false;
	}
	
	private boolean checkStraight() {
		for (int i = 0; i < 9; i++) {
			if (numberCheck[i] > 0 && numberCheck[i + 1] > 0 && numberCheck[i + 2] > 0 && numberCheck[i + 3] > 0
					&& numberCheck[i + 4] > 0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkTwoPair() {
		int checkPair = 0;
		for (int i = 0; i < numberCheck.length; i++) {
			if (numberCheck[i] == 2) {
				checkPair++;
			}
		}
		if (checkPair == 2) {
			return true;
		}
		return false;
	}
	
	private void checkHighCard() {
		String highNum = null;
		for (int i = 0; i < numberCheck.length; i++) {
			if (numberCheck[i] > 0) {
				highNum = numberList[i];
			}
		}
		if (numberCheck[0] == 1) {
			highNum = numberList[0];
		}
		System.out.println("No Pair.. High Card: " + highNum);
	}
	
	private boolean numContains(int num) {
		for (int i = 0; i < numberCheck.length; i++) {
			if (numberCheck[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	private void kindShape() {
		kindShape = 0;
		for (int i = 0; i < shapeCheck.length; i++) {
			if (shapeCheck[i] > 0) {
				kindShape++;
			}
		}
		System.out.println("카드 종류 " + kindShape);
	}
	
	private void checkNum() {
		numberCheck = new int[numberList.length];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < numberList.length; j++) {
				if (card_list.get(i).contains(numberList[j])) {
					numberCheck[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(numberCheck));
	}
	
	private void checkShape() {
		shapeCheck = new int[shape.length];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < shape.length; j++) {
				if (card_list.get(i).contains(shape[j])) {
					shapeCheck[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(shapeCheck));
	}
	
	public void makeCard() {
		while (card.size() < 5) {
			card.add(shape[ran.nextInt(shape.length)] + numberList[ran.nextInt(numberList.length)]);
		}
		card_list = new ArrayList<>(card);
		System.out.println(card_list);
	}
}











