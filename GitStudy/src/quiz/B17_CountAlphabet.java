package quiz;

import java.util.Scanner;

public class B17_CountAlphabet {
	
	/*
		����ڷκ��� ������ �ϳ� �Է¹ް�
		�ش� ���忡 � ���ĺ��� ��� �����ߴ��� ��� ��� ����غ�����
		(��ҹ��� ���о��� ����)
	*/
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("������ �Է��ϼ��� > ");
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
//				System.out.printf("[%c]�� %d�� �����߽��ϴ�.\n", 'a' + i, num[i]);
//			}
//		}
		
		String text = "Everythin is alright";
		System.out.println(text);
		// # ���ڿ��� ���� �빮�� �Ǵ� �ҹ��ڷ� ��ȯ�ϱ�
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
				System.out.printf("[%c]�� %d�� �����߽��ϴ�.\n", 'A' + i, count[i]);
			}
		}
				
	}

}
