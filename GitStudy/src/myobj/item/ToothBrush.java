package myobj.item;

public class ToothBrush extends Item {

	int clean;
	
	public ToothBrush(String name, int price) {
		super (name, price);
		clean = 80;
	}

	public void use() {
		System.out.printf("%s칫솔로 이를 닦아서 %d퍼센트 깨끗해졌습니다.\n", name, clean);
	}
	
	public static void main(String[] args) {
		new ToothBrush("페리오", 5500).info();
		new ToothBrush("오랄비", 5500).use();
	}
	
}
