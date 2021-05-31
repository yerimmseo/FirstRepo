package theory;

public class C12_Interface {

	/*
		# �������̽� (Interface)
		- abstract class�� ����� ������ ���� �� ���ٴ� ������ ������ �� 
		- �������̽� ������ �޼���� �ڵ����� abstract public�� �ȴ�
		- �������̽��� ������ ������ �ڵ����� final static�� �ȴ�
		- �������̽��� ���� �޼��带 ������ �� default�� ���̸� �⺻ ������ ������ �� �ִ�
	*/
	public static void main(String[] args) {
		new OrangeTree().click();
	}
}

interface CanClick {
	default void click() {
		System.out.println("Ŭ�� �������̽��� �޷��ִ� Ŭ������ �⺻ ����. (�������̵带 ������ּ���)");
	}
}

interface CanPunch {
	int a = 1;
	void punch();
}

class OrangeTree implements CanClick, CanPunch {
	@Override
	public void punch() {
	}
}
