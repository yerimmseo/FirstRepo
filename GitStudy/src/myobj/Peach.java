package myobj;

public class Peach {

	public int size;
	int calorie;
	long lifetime;
	double sweet;
	String color;
	
	//public Peach() {}

	// 다른 패키지에서 쓰고 싶을 떄는 public을 붙여야 한다.
	public void eat() {
		size--;
		calorie -= 10;
	}
	
}
