package theory;
import quiz.*;

import quiz.advance.AbcQuiz;
import quiz.basic.AbcTest;

public class B02_Import {
	/*
	    # import
	    - �ٸ� ��Ű���� ���ǵǾ��ִ� Ŭ������ ����ϱ� ���ؼ���
	              �ش� Ŭ������ ��Ȯ�� ��θ� import �ؾ� �Ѵ�.
	    - ���� ��Ű���� �����ϴ� Ŭ������ import ���̵� ����� �� �ִ�
	 */

	public static void main(String[] args) {
		
		// ���� default package�� �ڿ�
		A00_Hello.main(null);
		A01_Escape.main(null);
		A02_Variable.main(null);
		
		// �ٸ� ��Ű��(quiz)�� �ڿ��� ����ϱ� ���ؼ��� import�� �ʿ��ϴ�
		A01_PrintQuiz.main(null);
		A03_Introduce.main(null);
		
		// ���� : quiz���� advance���� AbcQuiz Ŭ������ ����غ�����
		AbcQuiz.main(null);
		
		// ����� : quiz�ؿ� basic�̶�� ��Ű���� ���� �� AbcTest Ŭ������ ���� �� �ҷ��ͼ� ����غ�����
		//		  (������� �� ��Ÿ���� �޼��� �ƹ��ų�)
		AbcTest.main(null);
		
		//Scanner sc = new Scanner(System.in); // Ctrl + Shift + O
		
	}
	
}
