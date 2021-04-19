package theory;

public class B01_Operator1 {

	public static void main(String[] args) {
		/*
		   # 연산자 (Operator)
		   - 계산할 때 사용하는 것
		   - +, -, *, / ...
		 */
		// # 산술 연산자
		int a = 10, b = 7;
		double c = 7.0;
		
		System.out.println("+ : " + (a + b));
		System.out.println("- : " + (a - b));
		System.out.println("* : " + a * b);
		
		// 정수끼리 나누면 몫만 나온다
		System.out.println("/ : " + a / b);
		// 정수와 실수를 나누면 정확한 값을 계산한다
		System.out.println("/ : " + a / c);
		System.out.println("/(float) : " + a /(float)b);
		System.out.println("/(double) : " + a /(double)b);
		
		System.out.println("% : " + a % b); // 나머지
		
		System.out.println("제곱 : " + Math.pow(a, 3));
		System.out.println("제곱? : " + (a ^ b)); // ^는 제곱이 아니다
		
		System.out.println("제곱근 : " + Math.sqrt(49));
		System.out.println("절대값 : " + Math.abs(-25));
		System.out.println("소수 첫째 자리에서 반올림 : " + Math.round(3.335));
		/*
		    Math.round()는 소수 첫째 자리에서만 반올림 할 수 있다.
		 	반올림하고 싶은 자리를 소수 첫째 자리로 만들만큼 곱한 후 다시 나누는 방식을 통해
		 	원하는 자릿수에서 반올림 할 수 있다.
		 */
		System.out.println("소수 셋째 자리에서 반올림 : " + Math.round(3.335 * 100) / 100.0);
		
		System.out.println("올림 : " + Math.ceil(1.001));
		System.out.println("내림 : " + Math.floor(1.999));
		
		System.out.println("더 큰 숫자 남기기 : " + Math.max(1900, 1500));
		System.out.println("더 작은 숫자 남기기 : " + Math.min(1900, 1500));
		
		// # 비트 연산
		//   &, |, ^, >>, <<
		
		// a = 10, b = 7
		// -> a = 1010, b = 0111
		
		// a 1010
		// b 0111
		// ------ &
		//   0010 -> 2
		System.out.println("a & b : " + (a & b)); // AND 
		
		// a 1010
		// b 0111
		// ------ |
		//   1111 -> 15
		System.out.println("a | b : " + (a | b)); // OR
		
		// a 1010
		// b 0111
		// ------ ^
		//   1101 -> 13
		System.out.println("a ^ b : " + (a ^ b)); // XOR
		
		// 0000001000 << 2
		// 0000100000
		System.out.println(8 << 2); // SHIFT
		// 0000001000 >> 2
		// 0000000010
		System.out.println(8 >> 2); // SHIFT
		
	}
}










