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

		// 1. numArr�� ��� ���� 0 ~ 100 ������ ���� ������ �ٲ㺸����
		for (int i = 0; i < numArr.length; i++) {
			System.out.print("{");
			for (int j = 0; j < numArr[i].length; j++) {
				numArr[i][j] = (int)(Math.random() * 101);
				System.out.printf("%3d ", numArr[i][j]);
			}
			System.out.println("}");
		}
		
		// 2. numArr�� ���հ� ����� ���ؼ� ����غ�����
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			count += numArr[i].length;
					
			for (int j = 0; j < numArr[i].length; j++) {
				sum += numArr[i][j];
			}
		}
		
		System.out.printf("����: %d, ���: %.2f\n", sum, (double)sum / count);
		
		// 3. numArr�� �� ���� ���� ��� ���ؼ� ����غ�����
		int[] rowSum = new int[numArr.length];
		
		for (int i = 0; i < rowSum.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
				rowSum[i] += numArr[i][j];
			}
		}
		// Arrays.toString(): �迭 ���ϰ� ����ϱ�
		System.out.println("���� ��: " + Arrays.toString(rowSum));
		
		// 4. numArr�� �� ���� ���� ��� ���ؼ� ����غ�����
		//  �� row : ��, column : ��
		
		// ���� �� �迭 ã��
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
//		System.out.println("���� ��: " + Arrays.toString(colSum));
		
		for (int i = 0; i < rowSum.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
				colSum[j] += numArr[i][j];
			}
		}
		System.out.println("���� ��: " + Arrays.toString(colSum));
		
		
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
//		System.out.printf("����: %d ���: %.2f\n", sum, avg);
	}
	
	
}
