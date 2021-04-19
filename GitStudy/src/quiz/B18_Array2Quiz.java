package quiz;

import java.util.Arrays;

public class B18_Array2Quiz {

	public static void main(String[] args) {
		
		int[][] numArr = new int[][] {
			{ 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1 },
			{ 1, 1 },
			{ 1, 1, 1, 1, 1 }
		};

		// 1. numArr의 모든 값을 0 ~ 100 사이의 랜덤 정수로 바꿔보세요
		for (int i = 0; i < numArr.length; i++) {
			System.out.print("{");
			for (int j = 0; j < numArr[i].length; j++) {
				numArr[i][j] = (int)(Math.random() * 101);
				System.out.printf("%3d ", numArr[i][j]);
			}
			System.out.println("}");
		}
		
		// 2. numArr의 총합과 평균을 구해서 출력해보세요
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			count += numArr[i].length;
					
			for (int j = 0; j < numArr[i].length; j++) {
				sum += numArr[i][j];
			}
		}
		
		System.out.printf("총합: %d, 평균: %.2f\n", sum, (double)sum / count);
		
		// 3. numArr의 각 행의 합을 모두 구해서 출력해보세요
		int[] rowSum = new int[numArr.length];
		
		for (int i = 0; i < rowSum.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
				rowSum[i] += numArr[i][j];
			}
		}
		// Arrays.toString(): 배열 편하게 출력하기
		System.out.println("행의 합: " + Arrays.toString(rowSum));
		
		// 4. numArr의 각 열의 합을 모두 구해서 출력해보세요
		//  ※ row : 행, column : 열
		
		// 제일 긴 배열 찾기
		int longest = 0;
		for (int i = 0; i < numArr.length; i++) {
			longest = Math.max(longest, numArr[i].length);
		}
		
		int[] colSum = new int[longest];
//		
//		for (int i = 0; i < colSum.length; i++) {
//			for (int j = 0; j < numArr.length; j++) {
//				
//				if (numArr[j].length > i) {
//					colSum[i] += numArr[j][i];
//				}
//			}
//		}
//		System.out.println("열의 합: " + Arrays.toString(colSum));
		
		for (int i = 0; i < rowSum.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
				colSum[j] += numArr[i][j];
			}
		}
		System.out.println("열의 합: " + Arrays.toString(colSum));
		
		
//		int sum = 0, count = 0;
//		double avg = 0;
//		
//		for (int i = 0; i < numArr.length; i++) {
//			for (int j = 0; j < numArr[i].length; j++) {
//				int ran = (int)(Math.random() * 100 + 1);
//				numArr[i][j] = ran;
//			}
//		}
//		
//		for (int i = 0; i < numArr.length; i++) {
//			int sumRow = 0;
//			
//			for (int j = 0; j < numArr[i].length; j++) {
//				System.out.printf("%3d " , numArr[i][j]);
//				count++;
//				sum += numArr[i][j];
//				sumRow += numArr[i][j];
//			}
//			System.out.printf("\t[%d]", sumRow);
//			System.out.println();
//		}
//		
//		System.out.println("-----------------------------");
//		int[] sumColumn = new int[7];
//		for (int i = 0; i < numArr.length; i++) {
//			for (int j = 0; j < numArr[i].length; j++) {
//				sumColumn[j] += numArr[i][j];
//			}
//			System.out.println();
//			for (int k = 0; k < 7; k++) {
//				System.out.printf("%3d ", sumColumn[k]);
//			}
//			System.out.println();
//		}
//		
//		System.out.println("-----------------------------");
//		avg = sum / (double)count;
//		System.out.printf("총합: %d 평균: %.2f\n", sum, avg);
	}
	
	
}
