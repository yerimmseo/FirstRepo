package quiz;

import java.util.Scanner;

public class B05_ConditionQuiz2 {
		
	/*
	    [ �˸��� ���ǽ��� �������� ]
	    1. char�� ���� a�� 'q'�Ǵ� 'Q'�� �� true
	    2. char�� ���� b�� �����̳� ���� �ƴ� �� true
	    3. char�� ���� c�� ����('0' ~ '9')�� �� true
	    4. char�� ���� d�� ������(�빮�� �Ǵ� �ҹ���)�� �� true
	    
	    �� �����ڵ� ǥ ����
	    5. char�� ���� e�� �ѱ��� �� true
	    6. char�� ���� f�� �Ϻ����� �� true
	    
	    7. ����ڰ� �Է��� ���ڿ��� exit�϶� true 
	*/
	public static void main(String[] args) {
		
		char a = 'Q';
		char b = '1';
		char c = 'a';
		char d = '3';
		char e = '�P';
		char f;
		String user;
		
		System.out.println(a == 'q' || a == 'Q');
		System.out.println(b != ' ' && b != '	');
		System.out.println(c >= '0' && c <= '9');
		System.out.println((d >= 'a' && d <= 'z') || (d >= 'A' && d <= 'Z'));
		System.out.println(e >= '��' && e <= '�R');
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����ڰ� �Է��� ���� > ");
		user = sc.next();
		System.out.println(user.equals("exit"));
		
	}
	
}
