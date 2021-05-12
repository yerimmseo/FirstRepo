package myobj.onecard;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayGame {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<PlayerDeck> players;
	Deck deck;
	int turn;
	int numOfPlayers;
	int eatCard;
	
	public PlayGame() {
		players = new ArrayList<>();
		deck = new Deck();
	}
	
	public void addPlayer(int num) {
		for (int i = 0; i < num; i++) {
			players.add(new PlayerDeck(deck));
		}
		numOfPlayers = players.size();
	}
	
	public void firstDraw() {
		for (PlayerDeck p : players) {
			p.firstDivide();
		}
	}
	
	public void cardDraw(int pn) {
		while (true) {
			System.out.print("ī�带 �������� (Y/N)");
			String respond = sc.nextLine().toUpperCase();
			
			if (respond.equals("Y")) {
				System.out.println("ī�带 �̾ҽ��ϴ�");
				players.get(pn).draw();
				System.out.println(players.get(pn));
				//break;
			} else if (respond.equals("N")) {
				System.out.println("ī�带 ���� �ʾҽ��ϴ�");
				System.out.println(players.get(pn));
				break;
			} else {
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է����ּ���");
				continue;
			}
		}
	}
	
	public void cardPlace(int player_number) {
		int num;
		PlayerDeck player = players.get(player_number);
		while (true) {
			System.out.print("�� ī���� ��ȣ�� �Է��ϼ���. ���̻� �� ī�尡 ���ٸ�(b) >>");
			try {
				num = sc.nextInt();
				if (player.placeCard(num)) {
					sc.nextLine();
					break;
				}
				System.out.println(player);
			} catch (InputMismatchException e) {
				String str = sc.nextLine().toUpperCase();
				if (str.equals("B")) {
//					if (player.placeCard == null) {
//						eatCardCheck(player_number);
					eatCardCheck(player_number);
//					}
					player.draw();
					System.out.println(player);
					break;
				}
				System.out.println("���ڰ� �ƴմϴ� �ٽ� �Է����ּ���");
				sc.nextLine();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("�ùٸ� �ε����� �ƴմϴ� �ٽ� �Է����ּ���");
			}
			
			
		}
	}
	
	public void eatCardCheck(int player_number) {
		if (eatCard != 0) {
			for (int i = 1; i < eatCard; i++) {
				players.get(player_number).draw();
			}
			eatCard = 0;
			if (deck.openCard.rank.getName().equals("JOKER")) {
				players.get(player_number).placeCard = null;
			}
			//deck.openCard = new Card(deck.openCard.suit, Card.RAN);
			players.get(player_number).placeCard = null;
		}
//		String openCard = deck.openCard.rank.getName();
//		if (openCard.equals("A") || openCard.equals("2") || openCard.equals("JOKER")) {
//			if (players.get(player_number).placeCard == null) {
//				for (int i = 1; i < eatCard; i++) {
//					players.get(player_number).draw();
//				}
//			}
//			deck.openCard = players.get(player_number).placeCard;
//		}
//		eatCard = 0;
//		if (openCard.equals("JOKER")) {
//			deck.openCard = players.get(player_number).placeCard;
//		}
	}
	
	public void suitChange() {
		while (true) {
			System.out.print("������ ���(�����̵�/Ŭ�ι�/��Ʈ/���̾Ƹ��) >> ");
			String change = sc.nextLine().trim();
			
			if (change.equals("�����̵�")) {
				System.out.println("�����̵�� ����Ǿ����ϴ�");
				deck.openCard = new Card(Card.SPADE, Card.RAN);
				break;
			} else if (change.equals("Ŭ�ι�")) {
				System.out.println("Ŭ�ι��� ����Ǿ����ϴ�");
				deck.openCard = new Card(Card.CLOVER, Card.RAN);
				break;
			} else if (change.equals("��Ʈ")) {
				System.out.println("��Ʈ�� ����Ǿ����ϴ�");
				deck.openCard = new Card(Card.HEART, Card.RAN);
				break;
			} else if (change.equals("���̾Ƹ��")) {
				System.out.println("���̾Ƹ��� ����Ǿ����ϴ�");
				deck.openCard = new Card(Card.DIAMOND, Card.RAN);
				break;
			} else {
				System.out.println("��ȿ�� ����� �ƴմϴ�.");
			}
		}
		
	}

	public void detailCheck(int player_number) {
		if (players.get(player_number).rankCheck() || players.get(player_number).suitCheck() 
				|| players.get(player_number).placeCard.rank.getName().equals("JOKER")) {
			if (players.get(player_number).placeCard.rank.getName().equals("K")) {
				System.out.println("�� �� �� �� �� �ֽ��ϴ�");
				cardPlace(player_number);
			} else if (players.get(player_number).placeCard.rank.getName().equals("J")) {
				System.out.println("���� ����� ���� �ǳʶݴϴ�");
				turn++;
				deck.openCard = new Card(deck.openCard.suit, Card.RAN);
				players.get(player_number).placeCard = null;
			} else if (players.get(player_number).placeCard.rank.getName().equals("Q")) {
				System.out.println("������ �ݴ�� �ٲߴϴ�"); // �̰� ����
			} else if (players.get(player_number).placeCard.rank.getName().equals("A")) {
				eatCard += 3;
				System.out.println("����ī�� ����[" + eatCard + "]");
			} else if (players.get(player_number).placeCard.rank.getName().equals("2")) {
				eatCard += 2;
				System.out.println("����ī�� ����[" + eatCard + "]");
			} else if (players.get(player_number).placeCard.rank.getName().equals("JOKER")) {
				eatCard += 7;
				System.out.println("����ī�� ����[" + eatCard + "]");
			} else if (players.get(player_number).placeCard.rank.getName().equals("7")) {
				System.out.println("���ϴ� ������� ������ �� �ִ�");
				suitChange();
				players.get(player_number).placeCard = null;
			}
		}
	}
	
	public void start(int num) {
		addPlayer(num);
		firstDraw();
		System.out.println(players);
		System.out.println("���� ���µ� ī�� >> [" + deck.firstOpenCard() + "]");
		
		while (true) {
			int player_number = turn % numOfPlayers;
			PlayerDeck player = players.get(player_number);
			
			System.out.println("player" + (player_number + 1) + "�� �� >> " + player);
			System.out.print("'player" + (player_number + 1) + "'�� ���� ");
			cardPlace(player_number);
			
			if (player.placeCard != null) {
				detailCheck(player_number);
			}
			if (player.userDeck.size() == 1) {
				System.out.println("[player" + (player_number + 1) + " ��ī��!]");
			}
			if (player.userDeck.size() == 0) {
				System.out.println("���� ��!");
				break;
			}
			turn++;
		}
	}
	
	
	@Override
	public String toString() {
		return players.toString();
	}
	
	
	public static void main(String[] args) {
		
		PlayGame game = new PlayGame();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�÷����� �÷��̾� �� >> ");
		int num = sc.nextInt();
		game.start(num);
		

		
		
	}

}
