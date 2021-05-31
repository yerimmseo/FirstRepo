package quiz;

import java.util.Scanner;

public class B11_Palindrome {
	/*
		����ڷκ��� �ܾ �ϳ� �Է¹ް� �ش� �ܾ ȸ���̶�� "PALINDROME"�� ���
		ȸ���� �ƴ϶�� "NOT PALINDROME"�� ����غ�����
		
		�� ȸ��? MOM, BOB, ABBA, MADAM ó�� �¿� ��Ī�� �ܾ�
	*/
	public static void main(String[] args) {
		
		System.out.print("�ܾ� �Է� > ");
		String word = new Scanner(System.in).next();
		String result = "PALINDROME";
		
		for (int i = 0; i < word.length() / 2; i++) {
			
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				result = "NOT PALINDROME";
				break;
			}
			
		}
		System.out.printf("[%s]�� ����� %s�Դϴ�.\n", word, result);	
	}

}
