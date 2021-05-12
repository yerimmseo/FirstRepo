package one;

import java.util.ArrayList;
import java.util.Collections;

public class OneCardDeck {
	
	ArrayList<Card> cards;
	ArrayList<Card> table;
	
	public OneCardDeck() {
		cards = new ArrayList<>();
		table = new ArrayList<>();
		
		// 하트 JOKER를 칼라 조커, 스페이드 JOKER 흑백조커
		for (Character suit : Card.SUITS) {
			for (String rank : Card.RANKS) {
				
				if (suit.equals('◇') && rank.equals("JOKER")) {
					continue;
				} else if (suit.equals('♣') && rank.equals("JOKER")) {
					continue;
				} else if (rank.equals("A")) {
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(3);
					cards.add(card);
				} else if (rank.equals("2")) {
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(2);
					cards.add(card);
				} else if (suit.equals('♡') && rank.equals("JOKER")) {
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(9);
				} else if (suit.equals('♠') && rank.equals("JOKER")) {
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(7);
					cards.add(card);
				} else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")
						|| rank.equals("7")) {
					Card card = new Card(suit, rank);
					card.setAttack(true);
					cards.add(card);
				} else {
					cards.add(new Card(suit, rank));
				}
			}
		}
		shuffle();
	}
	
	public Card tableCard() {
		if (table.size() == 0) {
			table.add(cards.remove(0));
		}
		
		return table.get(table.size() - 1);
	}
	
	public boolean submitCard(Card card) {
		Card tc = tableCard();
		
		boolean valid = false;
		
		if (tc.getRank().equals("JOKER")) {
			System.out.println("조커 뒤에는 무조건 추가됨(공격이 빠졌을 시)");
			table.add(card);
			valid = true;
		} else if (card.getRank().equals("JOKER")) {
			System.out.println("조커는 무조건 추가됨");
			table.add(card);
			valid = true;
		} else if (tc.getRank().equals(card.getRank())) {
			System.out.println("숫자가 맞아서 추가됨");
			table.add(card);
			valid = true;
		} else if (tc.getSuit().equals(card.getSuit())) {
			System.out.println("문양이 맞아서 추가됨");
			table.add(card);
			valid = true;
		}
		
		if (valid && card.isAttack()) {
			// 공격 카드에 대한 처리
			System.out.println("방금 내신 카드는 공격카드 입니다");
			return true;
		} else if (valid && card.isSpecial()) {
			// 특수 카드에 대한 처리
			System.out.println("방금 내신 카드는 특수카드 입니다");
			return true;
		}
		
		return false;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		if (cards.size() == 0) {
			for (int i = 0, len = table.size() - 1; i < len; ++i) {
				cards.add(table.remove(0));
			}
			shuffle();
			System.out.println("카드가 부족해서 테이블의 카드를 가져옴");
		}
		return cards.remove(0);
	}
}











