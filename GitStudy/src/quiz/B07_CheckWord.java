package quiz;

import java.util.Scanner;

public class B07_CheckWord {
	/*
		사용자로부터 단어를 하나 입력받고 첫 번째 글자와 마지막번째 글자가
		일치하면 "OK"를 출력, 아니라면 "NOT OK"를 출력해보세요
	*/
	// next() : 다음 단어를 String타입으로 받아오기(공백, \t 기준)
	// ex) apple banana orange -> apple만 저장됨
	// nextLine() : 다음 한 줄을 String타입으로 받아오기 (\n 기준)

	public static void main(String[] args) {
		
		System.out.print("단어를 입력하세요 > ");
		String word = new Scanner(System.in).nextLine();
		
		if (word.charAt(0) == word.charAt(word.length() - 1)) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
		
	}
	
}

