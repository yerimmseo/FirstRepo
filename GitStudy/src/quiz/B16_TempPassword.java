package quiz;

public class B16_TempPassword {
	
	// 4자리의 랜덤 임시비밀번호를 생성하는 프로그램을 만들어보세요.
	// (비밀번호를 구성하는 문자는 영어 대문자와 숫자입니다) 
	
	public static void main(String[] args) {

		System.out.print("임시비밀번호 = ");
		for (int i = 0; i < 4; i++) {
			
			int password = (int)(Math.random() * 10 + 1);
			char alphabet = (char)(Math.random() * 26 + 65);
			int num = (int)(Math.random() * 10);
			
			if (password % 2 == 0) {
				System.out.print(alphabet);
			} else {
				System.out.print(num);
			}
		}
		
		//String tempPassword = "";
		StringBuilder tempPassword = new StringBuilder();
		int size = 4;
		
		for (int i = 0; i < size; ++i) {
			switch ((int)(Math.random() * 2)) {
			case 0:
				//tempPassword += (char)(Math.random() * 26 + 'A');
				tempPassword.append((char)(Math.random() * 26 + 'A'));
				break;
			case 1:
				tempPassword.append((char)(Math.random() * 10 + '0'));
				break;
			}
		}
		System.out.println("임시 비밀번호 : " + tempPassword.toString());
		
	}
}
