package myobj.item;

public class Inventory {

	Item[] inventory;
	int size;
	
	public Inventory(int size) {
		inventory = new Item[size];
	}
	
	public boolean put(Item item) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				inventory[i] = item;
				return true;
			}
		}
		
		return false;
	}
	
	public void useAllItems() {
		for (Item item : inventory) {
			if (item != null) {
				item.use();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Inventory inven1 = new Inventory(3);
		
		// ※ Item을 넣어야하는 자리에 Item을 상속받은 모든 것들이 들어갈 수 있다
		inven1.put(new Tofu("순", 3000));
		inven1.put(new ToothBrush("페리오", 5000));
		inven1.put(new Wettissue("노브랜드", 1000));
		
		inven1.useAllItems();
		
//		for (int i = 0; i < 4; i++) {
//			if (inven1.put(new Candy("리콜라", 3000))) {
//				System.out.println("아이템이 잘 들어가면 put()에서 true가 리턴됨");
//			} else {
//				System.out.println("아이템이 잘 들어가면 put()에서 false가 리턴됨");
//			}
//		}
//		inven1.put(new Tofu("순", 2000));
//		inven1.put(new ToothBrush("리콜라", 3000));
//		inven1.put(new Wettissue("리콜라", 3000));
	}
}










