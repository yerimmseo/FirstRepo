package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz2 {

	/*
		# ������ �Լ��� �����ϰ� �ùٸ��� �۵��ϴ��� �׽�Ʈ �غ�����
		1. �ִ밪�� �Ű������� ���޹����� 0���� �ִ밪 �̸��� ��� ����
		   �����Ͽ� ��ȯ�ϴ� range�Լ��� �������� (�ִ밪 �̸�)
		   
		   ex: range(10)�� ��� [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		   
		2. �ּҰ��� �ִ밪�� �Ű������� ������, 
		   �� ���̿� �����ϴ� ��� ���� ������ int �迭�� �����Ͽ� ��ȯ�ϴ� 
		   range�Լ��� �������� (�ּҰ� �̻�, �ִ밪 �̸�)
		   
		   ex: range(5, 10)�� ��� -> [5, 6, 7, 8, 9]
		   
		3. �ּҰ��� �ִ밪�� �������� �Ű������� ������
		   �ּҰ����� �����Ͽ� �ִ밪���� ������ ��ŭ �����ϴ� int�迭�� �����Ͽ�
		   ��ȯ�ϴ� range�Լ��� �������� (�ּҰ� �̻�, �ִ밪 �̸�)
		   
		   ex: range(50, 56, 5)�� ��� -> [50, 55]
		   ex: range(50, 55, 5)�� ��� -> [50]
	*/
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(range(10)));
		//System.out.println(range(10)[3]);
		System.out.println(Arrays.toString(range(5,10)));
		System.out.println(Arrays.toString(range(25, 10)));
		System.out.println(Arrays.toString(range(50, 70, 6)));
	}
	
	// �Ű������� ���� Ȥ�� Ÿ���� �ٸ��� ���� �̸��� �Լ����� ����� �� �ִ�
	// (�Լ��� �����ε�, function overloading)
	public static int[] range(int min, int max, int add) {
		int size;
		if ((max - min) % add == 0) {
			size = (max - min) / add;
		} else {
			size = (max - min) / add + 1;
		}
		//int size = (int)Math.ceil((max - min) / (double)add);
		
		int[] numArr = new int[size];

		int index = 0;
		for (int i = min; i < max; i += add) {
			numArr[index++] = i;
		}
		return numArr;
	}
	
	public static int[] range(int min, int max) {
		if (min >= max) {
			return null; // �߸��� ���� �� return���� �Լ��� ������ �����Ű�� 
		}
		
		int diff = max - min;
		int index = 0;
		int[] numArr = new int[diff];
		for(int i = min; index < numArr.length; i++) {
			numArr[index++] = i;
		}
		return numArr;		
	}
	
	public static int[] range(int end) {
		int[] numArr = new int[end];
		for (int i = 0; i < end; i++) {
			numArr[i] = i;
		}
		return numArr;
	}
}
