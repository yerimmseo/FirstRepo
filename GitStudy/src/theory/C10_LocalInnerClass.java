package theory;

public class C10_LocalInnerClass {

	/*
		# 지역 내부 클래스
		- 메서드 내부에서 선언하여 사용하는 클래스
		- 메서드가 끝나면 해당 클래스도 수명이 다한다
	*/
	public static void main(String[] args) {
		
		// 지역 내부 클래스 (메서드가 끝나면 이 클래스도 사라지게 된다)
		class Apple {
			String size;
			String color;
			String insect;
		}
		
		Apple a = new Apple();
		AppleBox.Apple a2 = new AppleBox("고구마 박스").new Apple();
		
		// 내부 지역 클래스가 업캐스팅 되어있는 상태
		Fruit2 banana = getBanana();

		banana.eat();
		//banana.banana만가지고있는고유의기능(); 사용할 수 없다 (업캐스팅된 상태이기 때문에)
	}
		
public static Fruit2 getBanana() {
	
		
	class Banana extends Fruit2 {
		int fruit;
		int[] color;
			
		public Banana(int fruit) {
			this.fruit = fruit;
		}
			
		void eat() {
			System.out.println("열매가 " + fruit + "개 열린 바나나는 맛있었습니다.");
		}
		void banana만가지고있는고유의기능() {
			System.out.println("엄청난 기능");
			}
		}
		return new Banana(20);
	}
}

abstract class Fruit2 {
	abstract void eat();
}
