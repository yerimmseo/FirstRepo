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
	private Scanner sc;
	private int ran;
	private String name;
	private String user;
	private String com;
	
	private final static String[] computer = {"가위", "바위", "보"};
		
	public E03_SaveGame() {
		sc = new Scanner(System.in);
		System.out.print("사용자 이름 입력 >> ");
		name = sc.nextLine().trim();
	}
	
	public void game() {
		File saveFile = new File("./note/" + name + ".txt");
		
		System.out.println("[가위바위보 시작!]");
		System.out.println("[※ 게임을 그만하고 싶으면 e 입력]");
		try {
			FileOutputStream fout = new FileOutputStream(saveFile);
			
			while (true) {
				System.out.print(name + " >> ");
				user = sc.nextLine().trim();
				fout.write((name + " >> " + user + "\n").getBytes());
				
				ran = (int)(Math.random() * 3);
				com = computer[ran];
				
				if (user.equals("e")) {
					break;
				}
				
				if (!(user.equals("바위") || user.equals("가위") || user.equals("보"))) {
					System.out.println("다시 입력해주세요");
					continue;
				}
				
				if (user.equals(com)) {
					System.out.println("컴퓨터 >> " + com);
					fout.write(("컴퓨터 >> " + com + "\n").getBytes());
					System.out.println("비겼습니다.");
					fout.write("비겼습니다.\n".getBytes());
				} else if ((user.equals("바위") && com.equals("가위"))
						|| (user.equals("가위") && com.equals("보"))
						|| (user.equals("보") && com.equals("바위"))) {
					System.out.println("컴퓨터 >> " + com);
					fout.write(("컴퓨터 >> " + com + "\n").getBytes());
					System.out.println("이겼습니다.");
					fout.write("이겼습니다.\n".getBytes());
				} else if ((user.equals("바위") && com.equals("보"))
						|| (user.equals("가위") && com.equals("바위"))
						|| (user.equals("보") && com.equals("가위"))) {
					System.out.println("컴퓨터 >> " + com);
					fout.write(("컴퓨터 >> " + com + "\n").getBytes());
					System.out.println("졌습니다.");
					fout.write("졌습니다.\n".getBytes());
				}
			}
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void savePoint() {
		File saveFile = new File("./note/" + name + ".txt");
		
		if (saveFile.isFile()) {
			try {
				FileInputStream fin = new FileInputStream(saveFile);
				InputStreamReader isr = new InputStreamReader(fin);
				
				int fileRead = isr.read();
				while (fileRead != -1) {
					System.out.print((char)fileRead);
					fileRead = isr.read();
				}
				game();
				fin.close();
				isr.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			game();
		}
	}
	
	
	public static void main(String[] args) {
		E03_SaveGame game =  new E03_SaveGame();
		game.savePoint();
		
	}

}
