package myobj;

public class Peach {

	public int size;
	int calorie;
	long lifetime;
	double sweet;
	String color;
	
	//public Peach() {}

	// �ٸ� ��Ű������ ���� ���� ���� public�� �ٿ��� �Ѵ�.
	public void eat() {
		size--;
		calorie -= 10;
	}
	
}
