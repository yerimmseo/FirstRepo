package myobj.onecard;

public class Card {
	final public static Rank ACE = new Rank(0, "A");
	final public static Rank TWO = new Rank(1, "2");
	final public static Rank THREE = new Rank(2, "3");
	final public static Rank FOUR = new Rank(3, "4");
	final public static Rank FIVE = new Rank(4, "5");
	final public static Rank SIX = new Rank(5, "6");
	final public static Rank SEVEN = new Rank(6, "7");
	final public static Rank EIGHT = new Rank(7, "8");
	final public static Rank NINE = new Rank(8, "9");
	final public static Rank TEN = new Rank(9, "10");
	final public static Rank JACK = new Rank(10, "J");
	final public static Rank QUEEN = new Rank(11, "Q");
	final public static Rank KING = new Rank(12, "K");
	final public static Rank TOP_ACE = new Rank(13, "A");
	final public static Rank JOKER = new Rank(14, "JOKER");
	final public static Rank RAN = new Rank(15, "?");
	
	
	final public static Suit SPADE = new Suit(0, '♠', "스페이드", "Spade");
	final public static Suit CLOVER = new Suit(1, '♣', "클로버", "Clover");
	final public static Suit HEART = new Suit(2, '♡', "하트", "Heart");
	final public static Suit DIAMOND = new Suit(3, '◇', "다이아몬드", "Diamond");
	final public static Suit JOKER_SHAPE = new Suit(4, '◑', "조커", "Joker");
	
	final public static Rank[] RANKS = {
			ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	};
	
	final public static Suit[] SUITS = { SPADE, CLOVER, HEART, DIAMOND };
	
	Rank rank;
	Suit suit;
	
	public Card() {
		
	}
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return String.format("%s%s", suit, rank);
	}

}
