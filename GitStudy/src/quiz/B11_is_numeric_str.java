package quiz;

import java.util.Scanner;

public class B11_is_numeric_str {

	/*
		�Է¹��� ���ڿ��� ���ڸ� ���ԵǾ� ������ result�� 1
		�ٸ� ���ڰ� ���ԵǾ� �ִٸ� result�� 0
	*/
	
	public static void main(String[] args) {
		
		System.out.print("���� �Է� > ");
		String user = new Scanner(System.in).nextLine();
		
		int result = 1;
		
		for (int i = 0; i < user.length(); i++) {
			if (user.charAt(i) >= '0' && user.charAt(i) <= '9') {
				continue;
			}
			
			result = 0;
			break;
		}
		System.out.println(result);
		
	}
	
}
