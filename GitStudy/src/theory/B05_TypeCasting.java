package theory;

public class B05_TypeCasting {
	
	public static void main(String[] args) {
		
		/*
		   # 타입 캐스팅
		   - 타입이 자연스럽게 변하는 경우 (타입이 변하더라도 문제가 없을 때)
		   - 타입을 강제로 변환시켜야 하는 경우 (타입이 변하면 문제가 생길 때)
			
		   # 타입의 크기
		   - 정수 타입 : byte(1) < char, short(2) < int(4) < long(8)
		   - 실수 타입 : float(4) < double(8)
		   
		   ※ 정수 타입은 무조건 실수 타입 보다 표현범위가 작다
		*/
		
		// 1. 자연스러운 타입 캐스팅
		byte _byte = 127;
		short _short;
		int _int;
		long _long;
		float _float;
		
		_int = _byte;
		_int = 2100000000;
		_long = _int;
		_float = _long;
		
		System.out.println(_float);
		
		// 2. 값이 손상될 위험이 있는 타입 캐스팅
		_int = 50000;
		_short = (short)_int; // 값이 손상될 수도 있으므로 경고를 해준다.
		System.out.println(_short); 
		
		// 3. 같은 값이더라도 다르게 해석될 수 있는 타입의 경우 타입 캐스팅이 필요하다
		int a = 80;
		char ch = 'z';
		
		System.out.println((char)a);
		System.out.println(a);
		
		System.out.println((int)ch);
		System.out.println(ch);
		
		// ※ 코드표는 외울 필요가 없다 (char타입에 숫자를 사용할 이유가 없다)
		ch = 'M';
		
		System.out.println(ch > 'A');
		System.out.println(ch < 'Z');
		
		ch = '감';
		System.out.println(ch > '가');
		System.out.println(ch > '나');
		
		System.out.println((int)'가');
		
	}

}
