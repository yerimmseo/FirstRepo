package myobj.item;

public class Candy extends Item {

	int healty;
	
	public Candy(String name, int price) {
		super(name,price);
		healty = 10;
	}
	
	public void use() {
		System.out.println("사탕을 먹어서 " + healty + "만큼 목건강이 좋아졌습니다.\n");
	}
	
	public static void main(String[] args) {
		
		new Candy("목캔디", 1500).info();
		
		new Candy("목캔디", 1500).use();
		
	}
	
}
