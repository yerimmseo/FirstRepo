package myobj;

public class Cat {

	public double kilogram;
	public double full;
	public String name;
	public String color;

	
	public void Eat() {
		kilogram += 0.3;
		full += 30.6;
		
		if (full > 100) {
			full = 100;
			System.out.println("배가 부릅니다. 식사를 거부했습니다.");
		}
	}

	public void Meow() {
		System.out.printf("%s가 울었습니다.\n", name);
	}
	
	public Cat() {
		System.out.println("고양이의 정보를 입력해주세요");
	}
	
	public Cat(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public Cat(double full, double kilogram) {
		this.full = full;
		this.kilogram = kilogram;
	}
}
