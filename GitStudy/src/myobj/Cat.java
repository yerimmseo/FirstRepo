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
			System.out.println("�谡 �θ��ϴ�. �Ļ縦 �ź��߽��ϴ�.");
		}
	}

	public void Meow() {
		System.out.printf("%s�� ������ϴ�.\n", name);
	}
	
	public Cat() {
		System.out.println("������� ������ �Է����ּ���");
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
