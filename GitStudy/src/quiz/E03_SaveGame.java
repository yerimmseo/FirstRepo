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
		1. ��ǻ�Ϳ� �����ϴ� ������ ���������� ������ ��������
		   - ó�� �����ϸ� �̸��� �Է���
		   - ���α׷� ����� �÷��̾��� ������ ���Ͽ� ������(������ �� ���ϸ��� �̸�.txt)
		   
		2. ���α׷� ����� �̸��� �Է����� �� �ش� ������ �ִٸ�
		   ������ �ҷ��� �� ����ǵ��� ��������
	*/
	
//	private Scanner sc;
//	private int ran;
//	private String name;
//	private String user;
//	private String com;
//	private File saveFile;
//	private int win, lose, draw, total;
//	
//	private final static String[] computer = {"����", "����", "��"};
//		
//	public E03_SaveGame() {
//		sc = new Scanner(System.in);
//		System.out.print("����� �̸� �Է� >> ");
//		name = sc.nextLine().trim();
//		saveFile = new File("./data/" + name + ".txt");
//	}
//	
//	public void game() {
//		System.out.println("[���������� ����!]");
//		System.out.println("[�� ������ �׸��ϰ� ������ '��' �Է�]");
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
//				if (user.equals("��")) {
//					break;
//				}
//				
//				if (!(user.equals("����") || user.equals("����") || user.equals("��"))) {
//					System.out.println("�ٽ� �Է����ּ���");
//					continue;
//				}
//				
//				if (user.equals(com)) {
//					System.out.println("��ǻ�� >> " + com);
//					System.out.println("�����ϴ�.");
//					draw++;
//					total++;
//				} else if ((user.equals("����") && com.equals("����"))
//						|| (user.equals("����") && com.equals("��"))
//						|| (user.equals("��") && com.equals("����"))) {
//					System.out.println("��ǻ�� >> " + com);
//					System.out.println("�̰���ϴ�.");
//					win++;
//					total++;
//				} else if ((user.equals("����") && com.equals("��"))
//						|| (user.equals("����") && com.equals("����"))
//						|| (user.equals("��") && com.equals("����"))) {
//					System.out.println("��ǻ�� >> " + com);
//					System.out.println("�����ϴ�.");
//					lose++;
//					total++;
//				}
//			}
//			
//			System.out.println("�� ���� Ƚ�� = " + total);
//			System.out.println("====================");
//			System.out.println("�¸�\t���º�\t�й�");
//			System.out.println(win + "\t" + draw + "\t" + lose);
//			System.out.println("====================");
//			
//			fout.write("[���� ����]\n".getBytes());
//			fout.write(("�� ���� Ƚ�� = " + total + "\n").getBytes());
//			fout.write("====================\n".getBytes());
//			fout.write("�¸�\t���º�\t�й�\n".getBytes());
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
		
		System.out.print("���� �̸��� �Է����ּ��� >> ");
		String userName = sc.nextLine();
		
		File save = new File("./data/" + userName + ".hz");
		
		if (save.exists()) {
			System.out.println("[System] �ҷ��� ������ �ֽ��ϴ�");
			
			try {
				FileInputStream fin = new FileInputStream(save);
				
				win = fin.read();
				lose = fin.read();
				
				System.out.printf("�ҷ��� ���� - %d�� %d��\n", win, lose);
				
				fin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { 
			System.out.println("[System] �ҷ��� ������ �����ϴ�");
		}
		
		while (true) {
			int answer = (int)(Math.random() * 2);
			
			System.out.print("0, 1 > ");
			int user = sc.nextInt();
			
			if (user != -1 && user != 0 && user != 1) {
				System.out.println("�ȹٷ� �ٽ� �Է����ּ���!");
				continue;
			}
			
			if (user == -1) {
				System.out.println("�÷��� ���ּż� �����մϴ�!");
				break;
			}
			
			if (user != answer) {
				System.out.println("�����ϴ�");
				lose++;
			} else {
				System.out.println("��÷!");
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











