package myobj;

public class Brick {

	static int width = 100;
	static int height = 50;
	static String material;
	
	String color;
	int[] position;
	
	
	static void Brick(String material) {
		Brick.material = material;
	}
	static void Brick(int width, int height) {
		Brick.width = width;
		Brick.height = height;
	}
}
