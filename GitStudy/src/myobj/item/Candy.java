package myobj.item;

public class Candy extends Item {

	int healty;
	
	public Candy(String name, int price) {
		super(name,price);
		healty = 10;
	}
	
	public void use() {
		System.out.println("������ �Ծ " + healty + "��ŭ ��ǰ��� ���������ϴ�.\n");
	}
	
	public static void main(String[] args) {
		
		new Candy("��ĵ��", 1500).info();
		
		new Candy("��ĵ��", 1500).use();
		
	}
	
}
