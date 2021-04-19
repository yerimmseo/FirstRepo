package quiz;

public class D07_checkValidPhoneNumber {
	/*
		사용자로부터 핸드폰 번호를 입력받으면 올바른 전화번호인지 구분하는 프로그램을 만들어보세요
		
		앞의 3자리가 숫자
		두번째 숫자는 3자리 혹은 4자리
		세번째 숫자는 4자리
		4번째 또는 8번째 또는 9번째 문자는 '-'
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
//				System.out.println("잘못된 휴대폰 번호입니다.");
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
			System.out.println("[invalid] 길이가 올바르지 않음");
			return false;
		}
		
		for (int i = 0; i < len; i++) {
			char ch = phoneNumber.charAt(i);
			
			if (i < 3 && !checkNumeric(ch)) {
				System.out.println("[invalid] 맨 앞 3자리에 숫자 아닌 것이 있음");
				return false;
			} else if ((i == 3 || (i == 7 && len == 12) || (i == 8 && len == 13)) && ch != '-') {
				System.out.println("[invalid] 하이픈 자리가 올바르지 않음");
				return false;
			} else if (i > 3 && ((len == 12 && i < 7) || (len == 13 && i < 8)) && !checkNumeric(ch)) {
				System.out.println("[invalid] 가운데 자리에 숫자 아닌 것이 있음");
				return false;
			} else if (((i > 7 && len == 12) || (i > 8 && len == 13)) && !checkNumeric(ch)) {
				System.out.println("[invalid] 마지막 자리에 숫자 아닌 것이 있음");
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
//		D07_checkValidPhoneNumber check = new D07_checkValidPhoneNumber();
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("전화번호를 입력하세요 > ");
//		String[] phoneNumber = sc.nextLine().split("-");
//		
//		System.out.println(phoneNumber[0]);
//		System.out.println(phoneNumber[1]);
//		System.out.println(phoneNumber[2]);
//		
//		check.checkPhoneNumber(phoneNumber);
		
		if (checkValidPhoneNumber("010-134-a341")) {
			System.out.println("올바른 핸드폰 번호 입니다!");
		}
	}

}












