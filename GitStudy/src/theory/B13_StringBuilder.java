package theory;

public class B13_StringBuilder {

	// ���ڿ��� �ٽ� �����ϴ� ����� ���ִ� Ŭ����
	
	public static void main(String[] args) {
		
		// ex: ���ڿ��� �Ųٷ� ����� �����غ���
		
		String text = "Spring Framework";
		System.out.println(text);
		
		// String Ŭ������ ���������� �ſ� �������̴�.
		// String Ŭ������ ���� ������ �ϴ� ���� ��ȿ�����̴�.
		
		// System.currentTimeMillis() : ���� �ý��� �ð��� �и�������� ������
		
		long start_time = System.currentTimeMillis(); // String Ŭ���� ����
		int test_freq = 1000000;
		
		
		for (int test = 0; test < test_freq; ++test) {
			String reversed_text = "";
			
			for (int i = 0; i < text.length(); ++i) {
				reversed_text += text.charAt(text.length() - 1 - i);
			}
			//System.out.println(reversed_text);
		}
		
		
		long taken_time = System.currentTimeMillis() - start_time;
		System.out.println("���ۿ� �ɸ� �ð�1 : " + taken_time + "�и���");
		
		
		
		// �Ȱ��� ����� �ϴ��� �ξ� ������ ���ڿ��� �����ȴ�.
		start_time = System.currentTimeMillis();
		
		for (int test = 0; test < test_freq; ++ test) {
			StringBuilder reversed_text2 = new StringBuilder();
			
			for (int i = 0; i < text.length(); ++i) {
				char ch = text.charAt(text.length() - 1 - i);
				reversed_text2.append(ch);
			}
			//System.out.println(reversed_text2.toString());
		}
		
		taken_time = System.currentTimeMillis() - start_time;
		System.out.println("���ۿ� �ɸ� �ð�2 : " + taken_time + "�и���");
		
	}
	
}
