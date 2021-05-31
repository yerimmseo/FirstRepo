package quiz;

public class B15_WhileBasicQuiz {
	
	/*
		while���� �̿��Ͽ� ������ ���Ͻÿ�.
		1. 1���� 100���� 3�� ��� ����
		2. 200���� 1���� ���
		3. continue�� �̿��Ͽ� 300���� 500������ 7�� ����� ���
		4. 1���� 200������ ���� �� 2�� ����� �ƴϰ� 3�� ����� �ƴ� ���ڵ��� ����
	*/
	
	public static void main(String[] args) {
		
		int num = 0;
		int sum = 0;
		
		while (num++ < 100) {
			if (num % 3 == 0) {
				sum += num;
			}
		}
		System.out.println("1���� 100���� 3�ǹ�� ���� : " + sum);
		
		num = 200;
		
		while (num > 0) {
			System.out.println(num--);
		}
		
		num = 299;
		
		while (num++ < 500) {
			if (num % 7 != 0) {
				continue;
			}
			System.out.println("7�� ��� : " + num);
		}
		
		
		num = 0;
		sum = 0;
		
		while (num++ < 200) {
			if (num % 2 != 0 && num % 3 != 0) {
				sum += num;
			}
			
		}
		System.out.println("2�� ����� �ƴϰ� 3�� ����� �ƴ� ���� ��: " + sum);
		
	}

}
