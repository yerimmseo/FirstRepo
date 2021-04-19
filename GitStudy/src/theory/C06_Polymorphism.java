package theory;
import java.util.Scanner;

public class C06_Polymorphism {

	/*
		# 객체의 다형성
		- 객체는 다양한 형태를 지닐 수 있다
		- 사과는 사과이기도 하고 과일이기도 하다
		- 과일은 과일이지만 사과는 아니다
		
		# 자식 클래스는 부모 클래스가 될 수 있다 (업캐스팅)
		- 자식 클래스 타입이 부모 클래스 타입이 되는 것을 업캐스팅이라고 한다
		- 업캐스팅이 된 객채는 자식 클래스에만 존재하던 것들을 모두 잊어버린다
		- 오버라이드된 메서드는 자식 클래스에서 구현한 내용이 실행된다
		
		# 부모 클래스는 자식 클래스가 될 수 없다 (다운 캐스팅)
		- 하지만 예외적으로 업캐스팅이 되었던 인스턴스는 다시 원래 타입으로의 다운캐스팅이 가능하다
	*/
	
	public static void main(String[] args) {
		new Food(new PigMeat(), new Vege(), new Balsamic());
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str1 = new String();
		
		MainMaterial main_mat = new MainMaterial();
		MainMaterial main_mat2 = new Meat();
		
		Meat meat = new Meat();
		//Meat meat2 = new MainMaterial();
		
		doSomethingWithMainMaterial(new MainMaterial());
		doSomethingWithMainMaterial(new Meat());
		doSomethingWithMainMaterial(new Fish());
		doSomethingWithMainMaterial(new PigMeat());
		
		Police police = new Police();
		police.sayHi();
		police.arrest("김강도");
		
		// Person으로 업캐스팅 된 Police는 체포를 할 수 없다
		Person person = police; 
		Person person2 = new Person("전우치", 20, 30);
		//Person.arrest();
		person.sayHi();
		
		// 다운 캐스팅을 이용해 원래 기능 다시 사용하기
		
		// 원래 경찰이었던 인스턴스는 다운캐스팅이 가능
		((Police)person).arrest("김소매");
		
		// 경찰이 아니었던 인스턴스는 다운캐스팅이 불가능
		((Police)person2).arrest("김도적");
	}
	
	public static void doSomethingWithMainMaterial(MainMaterial mat) {
		
	}
}

class Food {
	
	MainMaterial mainMat;
	SubMaterial subMat;
	Sauce sauce;
	
	public Food(MainMaterial mainMat, SubMaterial subMat, Sauce sauce) {
		this.mainMat = mainMat;
		this.subMat = subMat;
		this.sauce = sauce;
	}
	
	public static void main(String[] args) {
		new Food(new PigMeat(), new Vege(), new Balsamic());
	}
	
}

class PorkCutlet {
	
	public PorkCutlet(PigMeat pig, SubMaterial subMat, Sauce sauce) {
		
	}
}

// 제일 높은 부모 클래스 (주재료, 부재료, 소스)
class MainMaterial {}
class SubMaterial {}
class Sauce {}

// 주재료를 상속받은 클래스들
class Fish extends MainMaterial {}
class Meat extends MainMaterial {}
// 주재료를 상속받은 클래스를 상속받은 클래스
class PigMeat extends Meat {}

// 부재료를 상속받은 클래스들
class Vege extends SubMaterial {}
class Fruit extends SubMaterial {}

// 소스를 상속받은 클래스들
class Salsa extends Sauce {}
class Balsamic extends Sauce {}









