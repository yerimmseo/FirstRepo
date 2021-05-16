package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class E03_SaveGame {
	/*
		1. 컴퓨터와 진행하는 간단한 가위바위보 게임을 만들어보세요
		   - 처음 시작하면 이름을 입력함
		   - 프로그램 종료시 플레이어의 전적을 파일에 저장함(저장할 때 파일명은 이름.txt)
		   
		2. 프로그램 실행시 이름을 입력했을 때 해당 전적이 있다면
		   전적을 불러온 후 진행되도록 만들어보세요
	*/
	
//	private Scanner sc;
//	private int ran;
//	private String name;
//	private String user;
//	private String com;
//	private File saveFile;
//	private int win, lose, draw, total;
//	
//	private final static String[] computer = {"가위", "바위", "보"};
//		
//	public E03_SaveGame() {
//		sc = new Scanner(System.in);
//		System.out.print("사용자 이름 입력 >> ");
//		name = sc.nextLine().trim();
//		saveFile = new File("./data/" + name + ".txt");
//	}
//	
//	public void game() {
//		System.out.println("[가위바위보 시작!]");
//		System.out.println("[※ 게임을 그만하고 싶으면 '끝' 입력]");
//		try {
//			FileOutputStream fout = new FileOutputStream(saveFile, true);
//			
//			while (true) {
//				System.out.print(name + " >> ");
//				user = sc.nextLine().trim();
//				
//				ran = (int)(Math.random() * 3);
//				com = computer[ran];
//				
//				if (user.equals("끝")) {
//					break;
//				}
//				
//				if (!(user.equals("바위") || user.equals("가위") || user.equals("보"))) {
//					System.out.println("다시 입력해주세요");
//					continue;
//				}
//				
//				if (user.equals(com)) {
//					System.out.println("컴퓨터 >> " + com);
//					System.out.println("비겼습니다.");
//					draw++;
//					total++;
//				} else if ((user.equals("바위") && com.equals("가위"))
//						|| (user.equals("가위") && com.equals("보"))
//						|| (user.equals("보") && com.equals("바위"))) {
//					System.out.println("컴퓨터 >> " + com);
//					System.out.println("이겼습니다.");
//					win++;
//					total++;
//				} else if ((user.equals("바위") && com.equals("보"))
//						|| (user.equals("가위") && com.equals("바위"))
//						|| (user.equals("보") && com.equals("가위"))) {
//					System.out.println("컴퓨터 >> " + com);
//					System.out.println("졌습니다.");
//					lose++;
//					total++;
//				}
//			}
//			
//			System.out.println("총 게임 횟수 = " + total);
//			System.out.println("====================");
//			System.out.println("승리\t무승부\t패배");
//			System.out.println(win + "\t" + draw + "\t" + lose);
//			System.out.println("====================");
//			
//			fout.write("[지난 전적]\n".getBytes());
//			fout.write(("총 게임 횟수 = " + total + "\n").getBytes());
//			fout.write("====================\n".getBytes());
//			fout.write("승리\t무승부\t패배\n".getBytes());
//			fout.write((win + "\t" + draw + "\t" + lose + "\n").getBytes());
//			fout.write("====================\n".getBytes());
//			
//			fout.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void savePoint() {
//		if (saveFile.isFile()) {
//			try {
//				FileInputStream fin = new FileInputStream(saveFile);
//				InputStreamReader isr = new InputStreamReader(fin);
//				
//				int fileRead;
//				while ((fileRead = isr.read()) != -1) {
//					System.out.print((char)fileRead);
//				}
//				game();
//				
//				fin.close();
//				isr.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			game();
//		}
//	}
//	
//	public static void main(String[] args) {
//		E03_SaveGame game =  new E03_SaveGame();
//		game.savePoint();
//	}
//}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int win = 300;
		int lose = 300;
		
		System.out.print("먼저 이름을 입력해주세요 >> ");
		String userName = sc.nextLine();
		
		File save = new File("./data/" + userName + ".hz");
		
		if (save.exists()) {
			System.out.println("[System] 불러올 파일이 있습니다");
			
			try {
				FileInputStream fin = new FileInputStream(save);
				
				win = fin.read();
				lose = fin.read();
				
				System.out.printf("불러온 정보 - %d승 %d패\n", win, lose);
				
				fin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { 
			System.out.println("[System] 불러올 파일이 없습니다");
		}
		
		while (true) {
			int answer = (int)(Math.random() * 2);
			
			System.out.print("0, 1 > ");
			int user = sc.nextInt();
			
			if (user != -1 && user != 0 && user != 1) {
				System.out.println("똑바로 다시 입력해주세요!");
				continue;
			}
			
			if (user == -1) {
				System.out.println("플레이 해주셔서 감사합니다!");
				break;
			}
			
			if (user != answer) {
				System.out.println("졌습니다");
				lose++;
			} else {
				System.out.println("당첨!");
				win++;
			}
		}
		
		try {
			FileOutputStream fout = new FileOutputStream(save);
			
			fout.write(win);
			fout.write(lose);
			
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}











