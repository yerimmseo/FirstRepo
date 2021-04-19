package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz2 {

	/*
		# 다음의 함수를 정의하고 올바르게 작동하는지 테스트 해보세요
		1. 최대값을 매개변수로 전달받으면 0부터 최대값 미만의 모든 값을
		   생성하여 반환하는 range함수를 만들어보세요 (최대값 미만)
		   
		   ex: range(10)의 결과 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		   
		2. 최소값과 최대값을 매개변수로 받으면, 
		   그 사이에 존재하는 모든 값을 포함한 int 배열을 생성하여 반환하는 
		   range함수를 만들어보세요 (최소값 이상, 최대값 미만)
		   
		   ex: range(5, 10)의 결과 -> [5, 6, 7, 8, 9]
		   
		3. 최소값과 최대값과 증가값을 매개변수로 받으면
		   최소값에서 시작하여 최대값까지 증가값 만큼 증가하는 int배열을 생성하여
		   반환하는 range함수를 만들어보세요 (최소값 이상, 최대값 미만)
		   
		   ex: range(50, 56, 5)의 결과 -> [50, 55]
		   ex: range(50, 55, 5)의 결과 -> [50]
	*/
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(range(10)));
		//System.out.println(range(10)[3]);
		System.out.println(Arrays.toString(range(5,10)));
		System.out.println(Arrays.toString(range(25, 10)));
		System.out.println(Arrays.toString(range(50, 70, 6)));
	}
	
	// 매개변수의 개수 혹은 타입이 다르면 같은 이름의 함수명을 사용할 수 있다
	// (함수의 오버로딩, function overloading)
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
			return null; // 잘못된 값일 때 return으로 함수를 빠르게 종료시키기 
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
