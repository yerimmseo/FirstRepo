package myobj.item;

/*
	�� Ŭ������ ��ӹ޾� �������� 3�� ��������
	�� ItemŬ������ �������� ����
*/


abstract public class Item {

	String name;
	int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// final�� ���� �޼���� �ڽ� Ŭ�������� �������̵带 ������Ų��
	final public void info() {
		System.out.printf("�̸�: %s\n", name);
		System.out.printf("����: %d��\n", price);
	}
	
	abstract public void use();
}

