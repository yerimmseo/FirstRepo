package theory;

public class D10_args {

	/*
		main �޼��� ù ��° �Ű�����(args)�� ����
		- ���α׷� ���� �� ����ڰ� ������ �ɼ��� main�� ù ��° �Ű������� �޴´�
		- ����ڰ� ������ �ɼǿ� ���� �ٸ��� �����ϴ� ���α׷��� ���� �� �ִ�
		
	*/
	
	public static void main(String[] args) {
		
		System.out.println("args.length: " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
	}
	
}
