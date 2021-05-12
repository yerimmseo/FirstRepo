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
			System.out.print("카드를 뽑으려면 (Y/N)");
			String respond = sc.nextLine().toUpperCase();
			
			if (respond.equals("Y")) {
				System.out.println("카드를 뽑았습니다");
				players.get(pn).draw();
				System.out.println(players.get(pn));
				//break;
			} else if (respond.equals("N")) {
				System.out.println("카드를 뽑지 않았습니다");
				System.out.println(players.get(pn));
				break;
			} else {
				System.out.println("잘못 입력했습니다. 다시 입력해주세요");
				continue;
			}
		}
	}
	
	public void cardPlace(int player_number) {
		int num;
		PlayerDeck player = players.get(player_number);
		while (true) {
			System.out.print("낼 카드의 번호를 입력하세요. 더이상 낼 카드가 없다면(b) >>");
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
				System.out.println("숫자가 아닙니다 다시 입력해주세요");
				sc.nextLine();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("올바른 인덱스가 아닙니다 다시 입력해주세요");
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
			System.out.print("변경할 모양(스페이드/클로버/하트/다이아몬드) >> ");
			String change = sc.nextLine().trim();
			
			if (change.equals("스페이드")) {
				System.out.println("스페이드로 변경되었습니다");
				deck.openCard = new Card(Card.SPADE, Card.RAN);
				break;
			} else if (change.equals("클로버")) {
				System.out.println("클로버로 변경되었습니다");
				deck.openCard = new Card(Card.CLOVER, Card.RAN);
				break;
			} else if (change.equals("하트")) {
				System.out.println("하트로 변경되었습니다");
				deck.openCard = new Card(Card.HEART, Card.RAN);
				break;
			} else if (change.equals("다이아몬드")) {
				System.out.println("다이아몬드로 변경되었습니다");
				deck.openCard = new Card(Card.DIAMOND, Card.RAN);
				break;
			} else {
				System.out.println("유효한 모양이 아닙니다.");
			}
		}
		
	}

	public void detailCheck(int player_number) {
		if (players.get(player_number).rankCheck() || players.get(player_number).suitCheck() 
				|| players.get(player_number).placeCard.rank.getName().equals("JOKER")) {
			if (players.get(player_number).placeCard.rank.getName().equals("K")) {
				System.out.println("한 번 더 낼 수 있습니다");
				cardPlace(player_number);
			} else if (players.get(player_number).placeCard.rank.getName().equals("J")) {
				System.out.println("다음 사람의 턴을 건너뜁니다");
				turn++;
				deck.openCard = new Card(deck.openCard.suit, Card.RAN);
				players.get(player_number).placeCard = null;
			} else if (players.get(player_number).placeCard.rank.getName().equals("Q")) {
				System.out.println("순서를 반대로 바꿉니다"); // 이거 아직
			} else if (players.get(player_number).placeCard.rank.getName().equals("A")) {
				eatCard += 3;
				System.out.println("공격카드 누적[" + eatCard + "]");
			} else if (players.get(player_number).placeCard.rank.getName().equals("2")) {
				eatCard += 2;
				System.out.println("공격카드 누적[" + eatCard + "]");
			} else if (players.get(player_number).placeCard.rank.getName().equals("JOKER")) {
				eatCard += 7;
				System.out.println("공격카드 누적[" + eatCard + "]");
			} else if (players.get(player_number).placeCard.rank.getName().equals("7")) {
				System.out.println("원하는 모양으로 변경할 수 있다");
				suitChange();
				players.get(player_number).placeCard = null;
			}
		}
	}
	
	public void start(int num) {
		addPlayer(num);
		firstDraw();
		System.out.println(players);
		System.out.println("현재 오픈된 카드 >> [" + deck.firstOpenCard() + "]");
		
		while (true) {
			int player_number = turn % numOfPlayers;
			PlayerDeck player = players.get(player_number);
			
			System.out.println("player" + (player_number + 1) + "의 패 >> " + player);
			System.out.print("'player" + (player_number + 1) + "'의 차례 ");
			cardPlace(player_number);
			
			if (player.placeCard != null) {
				detailCheck(player_number);
			}
			if (player.userDeck.size() == 1) {
				System.out.println("[player" + (player_number + 1) + " 원카드!]");
			}
			if (player.userDeck.size() == 0) {
				System.out.println("게임 끝!");
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
		
		System.out.print("플레이할 플레이어 수 >> ");
		int num = sc.nextInt();
		game.start(num);
		

		
		
	}

}
