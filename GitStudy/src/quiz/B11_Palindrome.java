package quiz;

import java.util.Scanner;

public class B11_Palindrome {
	/*
		사용자로부터 단어를 하나 입력받고 해당 단어가 회문이라면 "PALINDROME"을 출력
		회문이 아니라면 "NOT PALINDROME"을 출력해보세요
		
		※ 회문? MOM, BOB, ABBA, MADAM 처럼 좌우 대칭인 단어
	*/
	public static void main(String[] args) {
		
		System.out.print("단어 입력 > ");
		String word = new Scanner(System.in).next();
		String result = "PALINDROME";
		
		for (int i = 0; i < word.length() / 2; i++) {
			
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				result = "NOT PALINDROME";
				break;
			}
			
		}
		System.out.printf("[%s]의 결과는 %s입니다.\n", word, result);	
	}

}
