package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class E05_GuessNumberGame {
	/*
		게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다
		1. 플레이어는 8번의 시도를 할 수 있다
		2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다
		   숫자와 위치가 다 맞을 경우 - Strike
		   숫자만 맞을 경우 - Ball
		   
		   ex: 정답이 3456일 때
		       >> 5634		4 Ball
		       >> 3789		1 Strike
		       >> 3654		1 Strike 3 Ball
		3. 맞춘 시간과 횟수를 통해 1위부터 30위까지의 랭킹을 생성해 파일에 저장한다
		   (횟수가 같다면 시간이 더 적게 걸린 사람이 상위 랭킹)
		4. 새로운 게임을 시작할 때마다 랭킹을 출력해준다
		※ 맞추고 나면 몇번만에 맞췄는지 알려주기
	*/
	
	StringBuilder answer_builder;
	Scanner input_scanner;
	String answer;
	int strike, ball, trycount;
	String input;
	File save;
	int rank_count;
	long rank_min;
	long rank_sec;
	LinkedList<String> rank;
	String playerName;
	
	public E05_GuessNumberGame() {
		answer_builder = new StringBuilder();
		input_scanner = new Scanner(System.in);
		save = new File("./data/GuessNumberGame.txt");
		rank = new LinkedList<>();
		
		for (int i = 0; i < 4; i++) {
			answer_builder.append((int)(Math.random() * 10));
		}
		answer = answer_builder.toString();
	}
	
	public void game() {
		final boolean DEBUGMODE = true;
		
		if (DEBUGMODE) {
			System.out.printf("이번 정답[%s]\n", answer);
		}
		
		fileInput();
		
		long startTime = System.currentTimeMillis();
		
		while (strike != 4 && trycount != 8) {
			strike = 0;
			ball = 0;
			
			while (true) {
				System.out.printf("시도 %d >> ", trycount + 1);
				input = input_scanner.nextLine();
				
				boolean valid = true;
				
				if (input.length() != 4) {
					valid = false;
				}
				
				for (int i = 0; valid && i < 4; i++) {
					if (input.charAt(i) < '0' || input.charAt(i) > '9') {
						valid = false;
					}
				}
				
				if (valid) {
					break;
				} else {
					System.out.println("4자리 숫자만 입력하셔야 합니다.");
				}
			}
			
			if (answer.equals(input)) {
				strike = 4;
			} else {
				for (int i = 0; i < 4; i++) {
					if (answer.charAt(i) == input.charAt(i)) {
						strike++;
					} else {
						for (int j = 0; j < 4; j++) {
							if (answer.charAt(i) == input.charAt(j)) {
								ball++;
								break;
							}
						}
					}
				}
			}
			System.out.printf("%d strike, %d ball!\n", strike, ball);
			trycount++;
		}
		
		long endTime = System.currentTimeMillis();
		long takeOfTime = endTime - startTime;
		
		rank_count = trycount;
		rank_sec = takeOfTime / 1000;
		rank_min = rank_sec / 60;
		
		System.out.println("게임 종료!");
		
		System.out.print("남길 이름 입력하세요 >> ");
		playerName = input_scanner.nextLine().trim();
		
		fileOutput();
	}
	
	public void fileOutput() {
		
		try {
			FileOutputStream fout = new FileOutputStream(save, true);
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(rank_count);
			dout.writeLong(rank_min);
			dout.writeLong(rank_sec);
			dout.writeUTF(playerName);
			
			dout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileInput() {
		if (save.exists()) {
			FileInputStream fin;
			DataInputStream din;
			try {
				fin = new FileInputStream(save);
				din = new DataInputStream(fin);
				
				while (din.available() > 0) {
					rank_count = din.readInt();
					rank_min = din.readLong();
					rank_sec = din.readLong();
					playerName = din.readUTF();
					String str = String.format("%d번\t%2d분 %2d초\t  %4s", rank_count, rank_min, rank_sec, playerName);
					rank.add(str);
				}
				Collections.sort(rank);
				
				System.out.println("===================================");
				System.out.println(" 순위\t시도 횟수\t 걸린 시간\t    이름");
				for (int i = 0; i < rank.size(); i++) {
					System.out.printf("%3d\t%s\n",i + 1, rank.get(i));
					if (i == 29) {
						break;
					}
				}
				System.out.println("===================================");
				
				din.close();
				fin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		E05_GuessNumberGame game = new E05_GuessNumberGame();
		game.game();
	}

		
}
