package quiz;

import java.util.Scanner;

public class B11_Reverse {
	// ����ڰ� ������ �Է��ϸ� �� ������ �Ųٷ� ����غ�����
	
	public static void main(String[] args) {
		
		System.out.print("���� �Է� > ");
		String user = new Scanner(System.in).nextLine();
		
		for (int i = user.length() - 1; i >= 0; i--) {
			System.out.print(user.charAt(i));
		}
		
	}

}
