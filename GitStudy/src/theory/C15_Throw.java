package theory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Executable;

public class C15_Throw {
	
	/*
		# throw
		- 원하는 예외를 발생시킨다
		
		# throws
		- 해당 메서드에서 이러한 예외들을 발생시킨다는 것을 알린다
		- 해당 메서드를 호출하는 곳에 경고를 해줄 수 있다
		- 예외에 대한 처리를 호출하는 곳으로 전가한다
		
		# Exception 클래스를 상속받은 예외는 "반드시 처리해야하는 예외"가 된다
		- Exception은 예외처리를 하지 않으면 컴파일 에러를 발생시킨다
		- 예외처리가 된 경우에만 컴파일을 허용해준다
		
		# RuntimeException 클래스를 상속받은 예외는 "꼭 처리하지 않아도 되는 예외"가 된다
		- InputMismathException, ArrayIndexOutOfBoundsExecption .. 등
		- 예외처리를 하지 않아도 컴파일 에러는 발생하지 않는 예외들
	*/
	public static void main(String[] args) {
		
		C15_Throw instance = new C15_Throw();
		
		try {
			instance.dangerous_method2();
			instance.dangerous_method();
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 터짐: " + e.getMessage());
		}
		
		try {
			instance.checkEven(20);
			instance.checkOdd(14);
		} catch (NotEvenException e) {
			System.out.println("짝수 아님 익셉션 발생");
		} catch (NotOddException e) {
			System.err.println("홀수 아님 익셉션 발생");
		}
		
		System.out.println("프로그램이 정상 종료");
		
		//new C15_Throw().dangerous_method();
		//dangerous_method();
	}

	public void dangerous_method() throws FileNotFoundException {
//		int[] arr = new int[5];
//		arr[5] = 10;
		
		// 파일의 내용을 읽어오기 위한 준비과정 (꼭 처리해야 하는 예외가 발생)
		File f = new File("D:\\nameless.txt");
		FileReader reader = new FileReader(f);
	}
	
	public void dangerous_method2() {
		throw new ArrayIndexOutOfBoundsException("그냥 만들었음");
	}
	
	public void checkEven(int num) throws NotEvenException {
		if (num % 2 == 0) {
			System.out.println("짝수입니다");
		} else {
			throw new NotEvenException();
		}
		System.out.println("checkEven 메서드가 정상 종료 되었습니다.");
	}
	
	public void checkOdd(int num) {
		if (num % 2 == 1) {
			System.out.println("홀수입니다");
		} else {
			throw new NotOddException();
		}
		System.out.println("checkOdd 메서드가 정상 종료 되었습니다.");
	}
	
}

// 짝수가 아닐 때 발생시킬 예외 (예외처리 하지 않으면 컴파일 불가)
class NotEvenException extends Exception {
	public NotEvenException() {
		super("짝수가 아니어서 발생하는 예외");
	}
}

// 홀수가 아닐 때 발생시킬 예외 (예외처리 하지 않아도 빨간줄이 뜨지 않는 예외)
class NotOddException extends RuntimeException {
	public NotOddException() {
		super("홀수가 아니어서 발생하는 예외");
	}
}















