package theory;
import quiz.*;

import quiz.advance.AbcQuiz;
import quiz.basic.AbcTest;

public class B02_Import {
	/*
	    # import
	    - 다른 패키지에 정의되어있는 클래스를 사용하기 위해서는
	              해당 클래스의 정확한 경로를 import 해야 한다.
	    - 같은 패키지에 존재하는 클래스는 import 없이도 사용할 수 있다
	 */

	public static void main(String[] args) {
		
		// 같은 default package의 자원
		A00_Hello.main(null);
		A01_Escape.main(null);
		A02_Variable.main(null);
		
		// 다른 패키지(quiz)의 자원을 사용하기 위해서는 import가 필요하다
		A01_PrintQuiz.main(null);
		A03_Introduce.main(null);
		
		// 연습 : quiz밑의 advance밑의 AbcQuiz 클래스를 사용해보세요
		AbcQuiz.main(null);
		
		// 재시험 : quiz밑에 basic이라는 패키지를 만든 후 AbcTest 클래스를 만든 후 불러와서 사용해보세요
		//		  (사용했을 때 나타나는 메세지 아무거나)
		AbcTest.main(null);
		
		//Scanner sc = new Scanner(System.in); // Ctrl + Shift + O
		
	}
	
}
