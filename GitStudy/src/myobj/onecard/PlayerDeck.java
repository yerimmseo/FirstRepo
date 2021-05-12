package myobj.onecard;

import java.util.LinkedList;

public class PlayerDeck {
	
	LinkedList<Card> userDeck;
	Card placeCard;
	Deck deck;
	
	public PlayerDeck(Deck deck) {
		userDeck = new LinkedList<>();
		this.deck = deck;
	}
	
	public LinkedList<Card> firstDivide() {
		for (int i = 0; i < 7; i++) {
			userDeck.add(deck.draw());
		}
		return userDeck;
	}
	
	public LinkedList<Card> draw() {
		if (deck.deck.size() != 0) {
			userDeck.add(deck.draw());
		}
		return userDeck;
	}

	public boolean suitCheck() {
		if (deck.openCard.suit.equals(placeCard.suit)) {
			deck.openCard = placeCard;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean rankCheck() {
		if (deck.openCard.rank.equals(placeCard.rank)) {
			deck.openCard = placeCard;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean placeCard(int index) {
		if (placeCard == null) {
			placeCard = userDeck.get(index - 1);
			if (rankCheck() || suitCheck() || placeCard.rank.getName().equals("JOKER")) {
				System.out.println("���µ� ī�� >> [" + placeCard + "]");
				userDeck.remove(index - 1);
				return true;
			} else {
				System.out.println("�� �� ���� ī���Դϴ�.");
				return false;
			}
		} else {
			if (deck.openCard.rank.getName().equals("A")) {
				placeCard = userDeck.get(index - 1);
				if (!(placeCard.rank.getName().equals("A") || placeCard.rank.getName().equals("JOKER"))) {
					placeCard = null;
					System.out.println("�� �� ���� ī���Դϴ�.");
					return false;
				}
			}
			if (deck.openCard.rank.getName().equals("2")) {
				placeCard = userDeck.get(index - 1);
				if (!(placeCard.rank.getName().equals("A") || placeCard.rank.getName().equals("2") 
						|| placeCard.rank.getName().equals("JOKER"))) {
					placeCard = null;
					System.out.println("�� �� ���� ī���Դϴ�.");
					return false;
				}
			}
			if (deck.openCard.rank.getName().equals("JOKER")) {
				placeCard = userDeck.get(index - 1);
				if (!(placeCard.rank.getName().equals("JOKER"))) {
					System.out.println("�� �� ���� ī���Դϴ�.");
					placeCard = null;
					return false;
				}
			}
			
			placeCard = userDeck.get(index - 1);
			if (rankCheck() || suitCheck() || placeCard.rank.getName().equals("JOKER")) {
				System.out.println("���µ� ī�� >> [" + placeCard + "]");
				userDeck.remove(index - 1);
				return true;
			} else {
				System.out.println("�� �� ���� ī���Դϴ�.");
				return false;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return userDeck.toString();
	}
	
	
}
