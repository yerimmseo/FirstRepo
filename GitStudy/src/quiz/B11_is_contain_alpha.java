package quiz;

import java.util.Scanner;

public class B11_is_contain_alpha {

	/*
		����ڰ� �Է��� ���ڿ��� ���ĺ��� ���ԵǾ� ������ true, ������ false�� ���
	*/
	public static void main(String[] args) {
		
		System.out.print("���� �Է� > ");
		String user = new Scanner(System.in).nextLine();
		boolean word = false;
		
		for (int i = 0; i < user.length(); i++) {
			if ((user.charAt(i) >= 'a' && user.charAt(i) <= 'z') || (user.charAt(i) >= 'A' && user.charAt(i) <= 'Z')) {
				word = true;
			}
		}
		System.out.println(word);
	}
	
}



