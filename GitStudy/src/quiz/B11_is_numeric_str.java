package quiz;

import java.util.Scanner;

public class B11_is_numeric_str {

	/*
		입력받은 문자열에 숫자만 포함되어 있으면 result가 1
		다른 문자가 포함되어 있다면 result가 0
	*/
	
	public static void main(String[] args) {
		
		System.out.print("문자 입력 > ");
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
