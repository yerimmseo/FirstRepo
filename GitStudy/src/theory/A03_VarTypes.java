package theory;

public class A03_VarTypes {

	public static void main(String[] args) {
		
		/*
			# ���� Ÿ��
			- byte  (1byte)
				1byte -> 8bit
				
				0000 0000 (0) ~ 1111 1111 (255)
				�� ù ��° bit�� ��ȣ ��Ʈ�� ���ȴ�
				byteŸ���� ��� ���� 0000 0000 (0) ~ 0111 1111 (127)
				byteŸ���� ���� ���� 1000 0000 (-128) ~ 1111 1111 (-1)
				
			- short (2byte, signed)
				2byte -> 16bit : 65536���� (2^16)
				
				short�� ��� ���� 0 ~ 32767
				short�� ���� ���� -32768 ~ -1
				
			- char  (2byte, unsigned)
				2byte -> 16bit : 65536���� (2^16)
				
				��ȣ�� ���� ������ 0 ~ 65535�� ����� ������ �� �ִ� Ÿ��
				�ַ� ���� �ڵ带 �����ϴ� ���� ����Ѵ� (���� Ÿ��)
				
			- int   (4byte)
				4byte -> 32bit : 4,294,967,296���� (2^32)
				
				int�� ��� ���� 0 ~ 2,147,483,647
				int�� ���� ���� -2,147,483,648 ~ -1
				
			- long  (8byte)
				8byte -> 64bit : 18,446,744,073,709,551,616���� (2^64)
				...
		 */
		byte minByte = -128;
		byte maxByte = 127;
		System.out.println("byteŸ�Կ� ������ �� �ִ� ���� ū ���� " + maxByte + "�̰�, "
				+ "���� ���� ���� " + minByte + "�Դϴ�.");
		
		short minShort = -32768;
		short maxShort = 32767;
		System.out.println("shortŸ�Կ� ������ �� �ִ� ���� ū ���� " + maxShort + "�̰�, "
				+ "���� ���� ���� " + minShort + "�Դϴ�.");
		
		char minChar = 0;
		char maxChar = 65535;
		
		char ch = 65;
		System.out.println("charŸ�Կ� ����� ���� �⺻������ ���ڷ� ��µȴ�. " + ch);
		System.out.println("charŸ�Կ� ����� �ڵ尪�� Ȯ���ϰ� ������ (int)�� ���δ�. " + (int)ch);
		System.out.println("charŸ�Կ� ������ �� �ִ� ���� ū ���� " + (int)maxChar + "�̰�, "
				+ "���� ���� ���� " + (int)minChar + "�Դϴ�.");
		
		int minInt = -2_147_483_648;
		int maxInt = 2_147_483_647;
		System.out.println("intŸ�Կ� ������ �� �ִ� ���� ū ���� " + maxInt + "�̰�, "
				+ "���� ���� ���� " + minInt + "�Դϴ�.");
		
		// int�� ������ �Ѿ�� ���ڸ� ����� ���� L�� �ٿ��� �Ѵ� (�׳� ���ڸ� ���� ���� int)
		long _Long = 2_147_483_648L;
		System.out.println(_Long);
		
		/*
			# �Ǽ� Ÿ��
			- float  (4byte)
			- double (8byte)
			�Ǽ��� �ַ� �׷��� ��꿡 ���ȴ�.
			�ε��Ҽ��� ����� ����Ѵ�.
		 */
		// �׳� �Ҽ��� ���� ���� �⺻������ doubleŸ���̴�.
		// floatŸ���� �Ҽ��� �ڿ� F�� �ٿ��� �Ѵ�.
		float weight = 65.66F;
		double height = 177.77;
		
		/*
			# boolean Ÿ��
			���� ������ ǥ���ϴµ��� ���Ǵ� Ÿ��
			���� true�� false�ۿ� ����
		 */
		boolean hasFood = true;
		boolean over130cm = false;
			
		/*
			# ������ Ÿ�� (Ŭ���� Ÿ��)
			������ Ÿ���� �⺻�� Ÿ�Ե���� �ٸ��� �빮�ڷ� �����Ѵ�.
			- String : ���ڿ�
			- �� �� ��� Ŭ������ ...
		 */
		String helloMessage = "Hello, My name is John Doe.";
		String byeMessage = "Good bye. ";
				
		System.out.println(helloMessage);
		System.out.println("helloMessage");
		
		System.out.println(byeMessage + byeMessage + byeMessage);
		
	}

}
