package myobj.item;

public class Tofu extends Item {

	int cookTime;
	
	public Tofu(String name, int price) {
		super(name, price);
		cookTime = 30;
	}
	
	public void use() {
		System.out.printf("%s�κθ� �缭 %d�е��� �丮�� �߽��ϴ�.\n", name, cookTime);
	}
	
	public static void main(String[] args) {
		new Tofu("Ǯ����", 3000).info();
		new Tofu("��", 300).use();
	}
}
