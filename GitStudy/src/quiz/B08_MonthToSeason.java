package quiz;

import java.util.Scanner;

public class B08_MonthToSeason {
	
	/*
		����ڷκ��� ���� �Է¹����� �ش��ϴ� ������ ����غ�����
		(switch-case���� �̿�)
	*/
	public static void main(String[] args) {

		System.out.print("���� �Է��ϼ��� > ");
		int month = new Scanner(System.in).nextInt();
		String season;
		
		switch (month) {
		case 12: case 1: case 2:
			season = "�ܿ�";
			break;
		case 3: case 4: case 5:
			season = "��";
			break;
		case 6: case 7: case 8:
			season = "����";
			break;
		case 9: case 10: case 11:
			season = "����";
			break;
		default:
			season = "�߸��� ����";
			break;
		}
		
		System.out.printf("%d���� [%s]�Դϴ�.\n", month, season);
	}
	
}
