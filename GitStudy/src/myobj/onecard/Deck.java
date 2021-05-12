package myobj.onecard;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	
	LinkedList<Card> deck;
	Card openCard;
	
	public Deck() {
		deck = new LinkedList<>();
		
		for (Suit suit : Card.SUITS) {
			for (Rank rank : Card.RANKS) {
				deck.add(new Card(suit, rank));
			}
		}
		deck.add(new Card(Card.JOKER_SHAPE, Card.JOKER));
		Collections.shuffle(deck);
		//System.out.println(deck);
		
	}
		
	public Card draw() {
		return deck.pop();
	}
	
	public Card firstOpenCard() {
		return openCard = deck.pop();
	}
	
	@Override
	public String toString() {
		return deck.toString();
	}

}
