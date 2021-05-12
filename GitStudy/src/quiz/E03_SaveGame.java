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
	private Scanner sc;
	private int ran;
	private String name;
	private String user;
	private String com;
	
	private final static String[] computer = {"����", "����", "��"};
		
	public E03_SaveGame() {
		sc = new Scanner(System.in);
		System.out.print("����� �̸� �Է� >> ");
		name = sc.nextLine().trim();
	}
	
	public void game() {
		File saveFile = new File("./note/" + name + ".txt");
		
		System.out.println("[���������� ����!]");
		System.out.println("[�� ������ �׸��ϰ� ������ e �Է�]");
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
				
				if (!(user.equals("����") || user.equals("����") || user.equals("��"))) {
					System.out.println("�ٽ� �Է����ּ���");
					continue;
				}
				
				if (user.equals(com)) {
					System.out.println("��ǻ�� >> " + com);
					fout.write(("��ǻ�� >> " + com + "\n").getBytes());
					System.out.println("�����ϴ�.");
					fout.write("�����ϴ�.\n".getBytes());
				} else if ((user.equals("����") && com.equals("����"))
						|| (user.equals("����") && com.equals("��"))
						|| (user.equals("��") && com.equals("����"))) {
					System.out.println("��ǻ�� >> " + com);
					fout.write(("��ǻ�� >> " + com + "\n").getBytes());
					System.out.println("�̰���ϴ�.");
					fout.write("�̰���ϴ�.\n".getBytes());
				} else if ((user.equals("����") && com.equals("��"))
						|| (user.equals("����") && com.equals("����"))
						|| (user.equals("��") && com.equals("����"))) {
					System.out.println("��ǻ�� >> " + com);
					fout.write(("��ǻ�� >> " + com + "\n").getBytes());
					System.out.println("�����ϴ�.");
					fout.write("�����ϴ�.\n".getBytes());
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
