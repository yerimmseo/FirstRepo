package theory;

public class B12_SwapValue {

	public static void main(String[] args) {
		
		int a = 10, b = 20;
		int tmp;
		
		System.out.printf("a : %d, b : %d\n", a, b);
		
		// tmp에 a를 잠시 보관
		tmp = a; 
		
		// a에 b를 넣음. (a가 덮어씌워짐)
		a = b;
		// 아까 보관해놨던 a값을 b에 넣음
		b = tmp;
		
		System.out.printf("a : %d, b : %d\n", a, b);
		
	}
	
}

