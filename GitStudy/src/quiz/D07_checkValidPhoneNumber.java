package quiz;

public class D07_checkValidPhoneNumber {
	/*
		����ڷκ��� �ڵ��� ��ȣ�� �Է¹����� �ùٸ� ��ȭ��ȣ���� �����ϴ� ���α׷��� ��������
		
		���� 3�ڸ��� ����
		�ι�° ���ڴ� 3�ڸ� Ȥ�� 4�ڸ�
		����° ���ڴ� 4�ڸ�
		4��° �Ǵ� 8��° �Ǵ� 9��° ���ڴ� '-'
	*/
	
//	public void checkPhoneNumber(String[] phoneNumber) {
//		String[] check = phoneNumber;
//		boolean result = true;
//		
//		for (int i = 0; i < check.length; i++) {
//			for (int j = 0; j < check[i].length(); j++) {
//				if (check[i].charAt(j) >= '0' && check[i].charAt(j) <= '9') {
//					continue;
//				}
//				System.out.println("�߸��� �޴��� ��ȣ�Դϴ�.");
//				result = false;
//				break;
//			}
//		}
//		
//		if (result && checkDigit(phoneNumber)) {
//			System.out.println(check[0] + "-" + check[1] + "-" + check[2]);
//		}
//	}
//	
//	public boolean checkDigit(String[] phoneNumber) {
//		for (int i = 0; i < phoneNumber.length; i++) {
//			if (phoneNumber[i].length() == 3 || phoneNumber[i].length() == 4) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	private static boolean checkNumeric(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	public static boolean checkValidPhoneNumber(String phoneNumber) {
		int len = phoneNumber.length();
		
		if (len != 12 && len != 13) {
			System.out.println("[invalid] ���̰� �ùٸ��� ����");
			return false;
		}
		
		for (int i = 0; i < len; i++) {
			char ch = phoneNumber.charAt(i);
			
			if (i < 3 && !checkNumeric(ch)) {
				System.out.println("[invalid] �� �� 3�ڸ��� ���� �ƴ� ���� ����");
				return false;
			} else if ((i == 3 || (i == 7 && len == 12) || (i == 8 && len == 13)) && ch != '-') {
				System.out.println("[invalid] ������ �ڸ��� �ùٸ��� ����");
				return false;
			} else if (i > 3 && ((len == 12 && i < 7) || (len == 13 && i < 8)) && !checkNumeric(ch)) {
				System.out.println("[invalid] ��� �ڸ��� ���� �ƴ� ���� ����");
				return false;
			} else if (((i > 7 && len == 12) || (i > 8 && len == 13)) && !checkNumeric(ch)) {
				System.out.println("[invalid] ������ �ڸ��� ���� �ƴ� ���� ����");
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
//		D07_checkValidPhoneNumber check = new D07_checkValidPhoneNumber();
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("��ȭ��ȣ�� �Է��ϼ��� > ");
//		String[] phoneNumber = sc.nextLine().split("-");
//		
//		System.out.println(phoneNumber[0]);
//		System.out.println(phoneNumber[1]);
//		System.out.println(phoneNumber[2]);
//		
//		check.checkPhoneNumber(phoneNumber);
		
		if (checkValidPhoneNumber("010-134-a341")) {
			System.out.println("�ùٸ� �ڵ��� ��ȣ �Դϴ�!");
		}
	}

}












