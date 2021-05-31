package myobj.item;

public class ToothBrush extends Item {

	int clean;
	
	public ToothBrush(String name, int price) {
		super (name, price);
		clean = 80;
	}

	public void use() {
		System.out.printf("%sĩ�ַ� �̸� �۾Ƽ� %d�ۼ�Ʈ �����������ϴ�.\n", name, clean);
	}
	
	public static void main(String[] args) {
		new ToothBrush("�丮��", 5500).info();
		new ToothBrush("������", 5500).use();
	}
	
}
