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
		������ ���۵Ǹ� �������� 4�ڸ��� ���ڰ� �����ȴ�
		1. �÷��̾�� 8���� �õ��� �� �� �ִ�
		2. �� �õ����� 4�ڸ��� ���ڸ� �Է��ϸ� ������ ���� �˷��ش�
		   ���ڿ� ��ġ�� �� ���� ��� - Strike
		   ���ڸ� ���� ��� - Ball
		   
		   ex: ������ 3456�� ��
		       >> 5634		4 Ball
		       >> 3789		1 Strike
		       >> 3654		1 Strike 3 Ball
		3. ���� �ð��� Ƚ���� ���� 1������ 30�������� ��ŷ�� ������ ���Ͽ� �����Ѵ�
		   (Ƚ���� ���ٸ� �ð��� �� ���� �ɸ� ����� ���� ��ŷ)
		4. ���ο� ������ ������ ������ ��ŷ�� ������ش�
		�� ���߰� ���� ������� ������� �˷��ֱ�
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
			System.out.printf("�̹� ����[%s]\n", answer);
		}
		
		fileInput();
		
		long startTime = System.currentTimeMillis();
		
		while (strike != 4 && trycount != 8) {
			strike = 0;
			ball = 0;
			
			while (true) {
				System.out.printf("�õ� %d >> ", trycount + 1);
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
					System.out.println("4�ڸ� ���ڸ� �Է��ϼž� �մϴ�.");
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
		
		System.out.println("���� ����!");
		
		System.out.print("���� �̸� �Է��ϼ��� >> ");
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
					String str = String.format("%d��\t%2d�� %2d��\t  %4s", rank_count, rank_min, rank_sec, playerName);
					rank.add(str);
				}
				Collections.sort(rank);
				
				System.out.println("===================================");
				System.out.println(" ����\t�õ� Ƚ��\t �ɸ� �ð�\t    �̸�");
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
