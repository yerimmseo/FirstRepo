package myobj;

public class Coffee {
	
	private static class CoffeeCode {
		int code;
		String name;
		
		private CoffeeCode(int code, String name){
			this.code = code;
			this.name = name;
		}
	}
	
	private static class OriginCode {
		int code;
		String name;
		
		private OriginCode(int code, String name) {
			this.code = code;
			this.name = name;
		}
	}

	//private static String[] coffee_names = {"아메리카노", "카페라떼", "카페모카", "카라멜 마끼아또"};
	//private static String[] origin_names = {"콜롬비아", "브라질", "에티오피아", "케냐", "인도"};
	
	public final static CoffeeCode AMERICANO = new CoffeeCode(0, "아메리카노");
	public final static CoffeeCode CAFE_LATTE = new CoffeeCode(1, "카페라떼");
	public final static CoffeeCode CAFE_MOCHA = new CoffeeCode(2, "카페모카");
	
	public final static OriginCode COLOMBIA = new OriginCode(0, "콜롬비아");
	public final static OriginCode KENYA = new OriginCode(1, "케냐");
	public final static OriginCode INDIA = new OriginCode(2, "인도");
	
	
	CoffeeCode coffee;
	int price;
	int caffeine;
	OriginCode origin;
	
	boolean hot;
	
	public Coffee(CoffeeCode coffee, int price, int caffeine, OriginCode origin) {
		this.coffee = coffee;
		this.price = price;
		this.caffeine = caffeine;
		this.origin = origin;
		this.hot = true;
	}
	
	public String getCoffeeName() {
		return coffee.name;
	}
	
	public int getCoffeeCode() {
		return coffee.code;
	}
	
	public String getOriginName() {
		return origin.name;
	}
	
	public static void main(String[] args) {
		//Coffee coffee = new Coffee(0, 1500, 10, 4);
		//coffee.origin_names = new String[] {"대한민국", "중국", "일본", "러시아"};
		Coffee coffee1 = new Coffee(Coffee.AMERICANO, 1800, 10, Coffee.COLOMBIA);
		Coffee coffee2 = new Coffee(Coffee.CAFE_LATTE, 2500, 20, Coffee.KENYA);
		Coffee coffee3 = new Coffee(Coffee.CAFE_MOCHA, 3500, 25, Coffee.INDIA);
		
		System.out.println(coffee1.getCoffeeName());
		System.out.println(coffee2.getCoffeeName());
		
		System.out.println(coffee1.getOriginName());
		System.out.println(coffee2.getOriginName());
	}

}

// outer class에는 protected와 private을 사용할 수 없다
class TodayCoffee {
	// inner class에는 모든 접근 제어자를 사용할 수 있다
	protected class InnerClass {
		
	}
	
	private class InnerClass2 {
		
	}
}

