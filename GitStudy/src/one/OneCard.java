package one;

public class OneCard {
	
	OneCardDeck deck;
	
	public OneCard() {
		deck = new OneCardDeck();
		
		for (int i = 0; i < 100; ++i) {
			Card c = deck.draw();
			deck.submitCard(c);
			
			System.out.println("--------------------------");
			System.out.println("��� ������ ī��: " + c);
			System.out.println("���̺� �������� ī��: " + deck.tableCard());
			System.out.println("���� ���̺� ����: " + deck.table);
			System.out.println("���� ī����� ����: " + deck.cards);
		}
	}
	
	public static void main(String[] args) {
		new OneCard();
		
	}

}
