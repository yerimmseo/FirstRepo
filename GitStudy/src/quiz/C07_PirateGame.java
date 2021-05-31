package quiz;

import java.util.Scanner;

import myobj.tong.Barrel;

public class C07_PirateGame {

	/*
		1. �÷��̾ ���ư��鼭 ���ϴ� ���� Į�� ���
		2. �߸��� ���� Į�� ������ ���� �������� ���ư��� ���ӿ� �й��Ѵ�
	*/
	Scanner sc;
	
	Barrel barrel;
	int mode;
	
	int turn;
	int numOfPlayer;
	int pvcMode;
	int playerTurn = 0, computerTurn = 1;
	
	public C07_PirateGame(int mode) {
		this.barrel = new Barrel(20);
		this.mode = mode;
		this.numOfPlayer = 2;
		this.sc = new Scanner(System.in);
	}
	
	public C07_PirateGame(int mode, int numOfPlayer) {
		this(mode); // this(); �⺻ ������ ���
		this.numOfPlayer = numOfPlayer;
	}
	
	public void start() {
		switch (this.mode) {
		case 0:
			pvp();
			System.out.println("������� ����");
			break;
		case 1:
			pvc();
			System.out.println("��ǻ�Ϳ� ����");
			break;
		case 2:
			System.out.println("���� �������� ���� ���");
			break;
		}
	}
	
	public void config(int mode) {
		this.mode = mode;
	}
	
	void pvp() {
		while (true) {
			System.out.println((turn + 1) + "��");
			System.out.print("Player'" + (turn % numOfPlayer + 1) + "'�� ���� > ");
			int slot = sc.nextInt();
			
			boolean fork_result = barrel.fork(slot);
			if (fork_result) {
				
				if (barrel.checkGameOver()) {
					System.out.println("��������� ���ư����ϴ�...");
					System.out.println("Player'" + (turn % numOfPlayer + 1) + "'�� �й�!");
					
					break;
				}
				turn++;
			}
			
		}
	}
	
	void pvc() {
		while (true) {
			int slot = 0;
			int com = 0;
			
			if (pvcMode == playerTurn) {
				System.out.print("Player�� ���� > ");
				slot = sc.nextInt();
				
				turn++;
				pvcMode = computerTurn;

			} else if (pvcMode == computerTurn) {
				com = (int)(Math.random() * 20);
				
				if (com == slot) {
					com = (int)(Math.random() * 20);
				}
				System.out.println("Computer�� ���� > " + com);
				
				turn++;
				pvcMode = playerTurn;
			}
			
			if (barrel.fork(slot) || barrel.fork(com)) {
				
				if (barrel.checkGameOver()) {
					System.out.println("��������� ���ư����ϴ�...");
					System.out.printf("%s�� �й�!\n", pvcMode == playerTurn ? "Computer" : "Player");
					
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		C07_PirateGame testGame = new C07_PirateGame(99);
		
		testGame.start();
		testGame.config(0);
		testGame.start();
		
		System.out.println("�׽�Ʈ ���� ��!");
		
//		Scanner sc = new Scanner(System.in);
//		char[][] gameBoard = new char[5][5];
//		final int USER1 = 1, USER2 = 2; 
//		
//		int pointX = (int)(Math.random() * gameBoard.length);
//		int pointY = (int)(Math.random() * gameBoard[0].length);
//		
//		System.out.printf("%d, %d\n", pointX, pointY);
//		
//		System.out.println("[���� start!]");
//		
//		System.out.print("USER1, USER2 �� ���� ���� �����ϳ���? ");
//		int turn = sc.nextInt();
//		
//		while (true) {
//			
//			if (turn == USER1) {
//				
//				System.out.printf("user1(��) ��ǥ �Է� > ");
//				int user1X;
//				int user1Y;
//				
//				while (true) {
//					user1X = sc.nextInt();
//					user1Y = sc.nextInt();
//					if ((user1X < 0 || user1X >= gameBoard.length) || (user1Y < 0 || user1Y >= gameBoard[0].length)) {
//						System.out.printf("��ǥ �ٽ� �Է��ϱ� > ");
//					} else {
//						break;
//					}
//				}
//				
//				gameBoard[user1X][user1Y] = 1;
//				
//				for (int i = 0; i < gameBoard.length; i++) {
//					for (int j = 0; j < gameBoard[i].length; j++) {
//						
//						switch(gameBoard[i][j]) {
//						case 0:
//							System.out.print('��');
//							break;
//						case 1:
//							System.out.print('��');
//							break;
//						case 2:
//							System.out.println('��');
//							break;
//						}
//						System.out.print(' ');
//					}
//					System.out.println();
//				}
//				
//				turn = USER2;
//				
//				if (pointX == user1X && pointY == user1Y) {
//					System.out.println("���� ��!!");
//					break;
//				}
//			} else {
//				
//				System.out.printf("user2(��) ��ǥ �Է� > ");
//				int user2X;
//				int user2Y;
//				
//				while (true) {
//					user2X = sc.nextInt();
//					user2Y = sc.nextInt();
//					if ((user2X < 0 || user2X >= gameBoard.length) || (user2Y < 0 || user2Y >= gameBoard[0].length)) {
//						System.out.printf("��ǥ �ٽ� �Է��ϱ� > ");
//					} else {
//						break;
//					}
//				}
//				
//				gameBoard[user2X][user2Y] = 2;
//				
//				for (int i = 0; i < gameBoard.length; i++) {
//					for (int j = 0; j < gameBoard[i].length; j++) {
//						
//						switch(gameBoard[i][j]) {
//						case 0:
//							System.out.print('��');
//							break;
//						case 1:
//							System.out.println('��');
//							break;
//						case 2:
//							System.out.print('��');
//							break;
//						}
//						System.out.print(' ');
//					}
//					System.out.println();
//				}
//				
//				turn = USER1;
//				
//				
//			}
//			
//			
//			
//			
//			
//		}
	}
	
}
