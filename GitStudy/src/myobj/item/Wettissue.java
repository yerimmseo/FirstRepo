package myobj.item;

public class Wettissue extends Item{

	int count;
	
	public Wettissue(String name, int price) {
		super(name, price);
		count = 3;
	}
	
	public void use() {
		System.out.printf("물티슈를 %d장 사용해서 청소를 했습니다.\n", count);
	}
	
	public static void main(String[] args) {
		new Wettissue("노브랜드", 1000).info();
		new Wettissue("아이좋아", 1500).use();
	}
	
}
