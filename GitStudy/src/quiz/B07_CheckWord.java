package quiz;

import java.util.Scanner;

public class B07_CheckWord {
	/*
		����ڷκ��� �ܾ �ϳ� �Է¹ް� ù ��° ���ڿ� ��������° ���ڰ�
		��ġ�ϸ� "OK"�� ���, �ƴ϶�� "NOT OK"�� ����غ�����
	*/
	// next() : ���� �ܾ StringŸ������ �޾ƿ���(����, \t ����)
	// ex) apple banana orange -> apple�� �����
	// nextLine() : ���� �� ���� StringŸ������ �޾ƿ��� (\n ����)

	public static void main(String[] args) {
		
		System.out.print("�ܾ �Է��ϼ��� > ");
		String word = new Scanner(System.in).nextLine();
		
		if (word.charAt(0) == word.charAt(word.length() - 1)) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
		
	}
	
}

