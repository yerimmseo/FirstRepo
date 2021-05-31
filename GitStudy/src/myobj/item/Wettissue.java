package myobj.item;

public class Wettissue extends Item{

	int count;
	
	public Wettissue(String name, int price) {
		super(name, price);
		count = 3;
	}
	
	public void use() {
		System.out.printf("��Ƽ���� %d�� ����ؼ� û�Ҹ� �߽��ϴ�.\n", count);
	}
	
	public static void main(String[] args) {
		new Wettissue("��귣��", 1000).info();
		new Wettissue("��������", 1500).use();
	}
	
}
