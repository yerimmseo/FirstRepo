package theory;

public class A04_VarNaming {

	public static void main(String[] args) {
		
		/*
		  	# 우리가 변수를 사용해야 하는 이유
		  	1. 값을 한번에 변경할 수 있다
		  	   - 값을 일일이 찾아다니면서 변경할 필요가 없어진다
		  	2. 값에 의미를 부여할 수 있다
		  	   - 변수의 이름을 통해 해당 값의 용도를 쉽고 빠르게 파악할 수 있다
		  	   - 변수의 이름을 잘 짓는 것이 매우 중요하다
		 */
		
		
		int apple_count = 15;
		int apple_price = 493;
		final int APPLE_CALORIE = 110;
		int apple_gram = 50;
		
		System.out.println("사과의 개수 : " + apple_count);
		System.out.println("사과의 총 가격 : " + apple_count * apple_price + "원");
		System.out.println("사과의 개당 칼로리 : " + APPLE_CALORIE + "kcal");
		System.out.println("사과의 총 칼로리 : " + apple_count * APPLE_CALORIE + "kcal");
		System.out.println("사과의 개당 무게 : " + apple_gram + "g");
		System.out.println("사과의 총 무게 : " + apple_gram * apple_count + "g");
		
		/*
		  	# 변수 작명 규칙 (권장 사항)
		  	(1) 두 단어 이상을 이어붙인 변수명을 사용할 때 _를 활용한다 (snake_case)
		  		ex: apple_count, minsu_age, sujin_grade
		  	(2) 두 단어 이상을 이어붙인 변수명을 사용할 때 대문자를 활용한다 (camelCase)
		  		ex: appleCount, minsuAge, sujinGrade
		  	(3) 변수명 첫 글자는 소문자를 사용한다
		  	(4) 클래스명 첫 글자는 대문자를 사용한다
		  	(5) 프로그램 내에서 값이 변하지 않을 변수(상수)는 모두 대문자를 사용한다
		  		ex: APPLE_PRICE, APPLE_GRAM
		  	(6) 변수에 들어있는 값을 추측할 수 있는 적절한 단어를 사용하자
		  	
		  	# 변수 작명 규칙 (필수)
		  	(1) 변수의 첫 번째 글자는 숫자가 될 수 없다
		  		ex: 1st, 2nd, 4pple
		  	(2) 변수명 사이에는 공백을 사용할 수 없다
		  	(3) 특수문자는 _와 $만 사용할 수 있다
		  	(4) 이미 자바에서 사용하고 있는 키워드는 변수명으로 사용할 수 없다
		  		(Eclipse에서는 이미 사용하고 있는 키워드를 보라색으로 보여준다)
		  		ex: byte, float, double, int, final, public, static, void ...
		 */

	}
}
