package quiz;

import java.util.Scanner;

public class B17_CountAlphabet {
	
	/*
		사용자로부터 문장을 하나 입력받고
		해당 문장에 어떤 알파벳이 몇번 등장했는지 세어서 모두 출력해보세요
		(대소문자 구분없이 셀것)
	*/
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("문장을 입력하세요 > ");
//		String input = sc.nextLine();
//		
//		input = input.toLowerCase();
//		
//		char[] inputChar = input.toCharArray();
//		int[] num = new int[26];
//		//System.out.println(inputChar);
//		
//		for (int i = 0; i < inputChar.length; i++) {
//			
//			for (int j = 0; j < num.length; j++) {
//				
//				if (inputChar[i] == 'a' + j) {
//					num[j]++;
//				}
//			}
//			
//		}
//		for (int i = 0; i < num.length; i++) {
//			if (num[i] != 0) {
//				System.out.printf("[%c]는 %d번 등장했습니다.\n", 'a' + i, num[i]);
//			}
//		}
		
		String text = "Everythin is alright";
		System.out.println(text);
		// # 문자열을 쉽게 대문자 또는 소문자로 변환하기
		text = text.toUpperCase();
		//text.toLowerCase();
		int[] count = new int[26];
		
		for (int i = 0; i < text.length(); i++) {
			
			char ch = text.charAt(i);
			
			if (ch >= 'A' && ch <= 'Z') {
				count[ch - 'A']++;
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.printf("[%c]는 %d번 등장했습니다.\n", 'A' + i, count[i]);
			}
		}
				
	}

}
