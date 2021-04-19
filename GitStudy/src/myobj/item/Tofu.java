package myobj.item;

public class Tofu extends Item {

	int cookTime;
	
	public Tofu(String name, int price) {
		super(name, price);
		cookTime = 30;
	}
	
	public void use() {
		System.out.printf("%s두부를 사서 %d분동안 요리를 했습니다.\n", name, cookTime);
	}
	
	public static void main(String[] args) {
		new Tofu("풀무원", 3000).info();
		new Tofu("순", 300).use();
	}
}
