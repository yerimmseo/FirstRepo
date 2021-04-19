package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz {

	/*
		# ������ �Լ��� �����ϰ� �ùٸ��� �۵��ϴ��� �׽�Ʈ �غ�����
		1. ������ ���ڰ� ���ĺ��̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		2. ������ ���ڰ� 3�� ����̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		3. ���ڸ� �ϳ� �����ϸ� ���ڿ� "¦���Դϴ�" �Ǵ� "Ȧ���Դϴ�"�� ��ȯ�Ѵ� �Լ�
		4. ���ڸ� �����ϸ� �ش� ������ ��� ����� �迭���·� ��ȯ�ϴ� �Լ�
		5. ������ ������ �Ҽ���� true�� ��ȯ�ϰ� �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		6. ���ڸ� �����ϸ� �ش� ������ ���丮�� ����� ��ȯ�ϴ� �Լ�
		   factorial: (n)*(n-1)*(n-2) ... 3*2*1
	*/
	
	public static void main(String[] args) {
		
		System.out.println("1. " + contain_alphabet('0'));
		System.out.println("2. " + multiple_three(333));
		System.out.println("3. " + even_odd(552));
		System.out.println("4. " + Arrays.toString(divisor(30)));
		System.out.println("5. " + find_prime(47));
		System.out.println("6. " + factorial(5));
		
	}
	
	public static int factorial2(int num) {
		if (num == 2) {
			return 2;
		}
		return num * factorial(num - 1);
	}
	
	public static int factorial(int num) {
		int fac = 1;
		for (int i = num; i > 0; i--) {
			fac *= i;
		}
		return fac;
	}
	
	public static boolean find_prime(int num) {
//		boolean prime = false;
//		
//		for (int i = 2; i < num; i++) {
//			int count = 0;
//			for (int j = 2; j < Math.sqrt(num); j++) {
//				if (i % j == 0) {
//					count++;
//					break;
//				}
//			}
//			if (count == 0) {
//				prime = true;
//			}
//		}
//		return prime;
		
		double sqrt = Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] divisor(int num) {
		
//		int[] divisor = new int[num];
//		for (int i = 1; i <= num; i++) {
//			if (num % i == 0) {
//				divisor[i - 1] += i;
//			}
//		}
//		return divisor;
		boolean[] divide = new boolean[num];
		int count = 0;
		
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				divide[i - 1] = true;
				count++;
			}
		}
		
		int[] result = new int[count];
		int index = 0;
		
		for (int i = 0; i < divide.length; i++) {
			if (divide[i]) {
				result[index++] = i + 1;
			}
		}
		return result;
	}
	
	public static String even_odd(int num) {
		
//		if (num % 2 == 0) {
//			return "¦���Դϴ�.";
//		} else {
//			return "Ȧ���Դϴ�.";
//		}
		return num % 2 == 0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		
	}
	
	public static boolean multiple_three(int num) {
		
//		if (num % 3 == 0) {
//			return true;
//		} else {
//			return false;
//		}
		return num % 3 == 0;
	}
	
	
	public static boolean contain_alphabet(char alphabet) {
		
//		if ((alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z')) {
//			return true;
//		} else {
//			return false;
//		}
		return (alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z');
	}
}
