package quiz;

public class B15_WhileBasicQuiz {
	
	/*
		while문을 이용하여 다음을 구하시오.
		1. 1부터 100까지 3의 배수 총합
		2. 200부터 1까지 출력
		3. continue를 이용하여 300부터 500사이의 7의 배수만 출력
		4. 1부터 200까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합
	*/
	
	public static void main(String[] args) {
		
		int num = 0;
		int sum = 0;
		
		while (num++ < 100) {
			if (num % 3 == 0) {
				sum += num;
			}
		}
		System.out.println("1부터 100까지 3의배수 총합 : " + sum);
		
		num = 200;
		
		while (num > 0) {
			System.out.println(num--);
		}
		
		num = 299;
		
		while (num++ < 500) {
			if (num % 7 != 0) {
				continue;
			}
			System.out.println("7의 배수 : " + num);
		}
		
		
		num = 0;
		sum = 0;
		
		while (num++ < 200) {
			if (num % 2 != 0 && num % 3 != 0) {
				sum += num;
			}
			
		}
		System.out.println("2의 배수도 아니고 3의 배수도 아닌 수의 합: " + sum);
		
	}

}
