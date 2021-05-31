package theory;

public class D10_args {

	/*
		main 메서드 첫 번째 매개변수(args)의 역할
		- 프로그램 실행 시 사용자가 지정한 옵션을 main의 첫 번째 매개변수에 받는다
		- 사용자가 지정한 옵션에 따라 다르게 동작하는 프로그램을 만들 수 있다
		
	*/
	
	public static void main(String[] args) {
		
		System.out.println("args.length: " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
	}
	
}
