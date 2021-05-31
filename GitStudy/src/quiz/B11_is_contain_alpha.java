package quiz;

import java.util.Scanner;

public class B11_is_contain_alpha {

	/*
		사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true, 없으면 false를 출력
	*/
	public static void main(String[] args) {
		
		System.out.print("문자 입력 > ");
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



