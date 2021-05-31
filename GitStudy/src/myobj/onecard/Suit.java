package myobj.onecard;

public class Suit {
	
	int value;
	char shape;
	String korName;
	String engName;
	
	public Suit(int value, char shape, String korName, String engName) {
		this.value = value;
		this.shape = shape;
		this.korName = korName;
		this.engName = engName;
	}
	
	public int getValue() {
		return value;
	}
	
	public char getShape() {
		return shape;
	}
	
	public String getKorName() {
		return korName;
	}
	
	public String getEngName() {
		return engName;
	}
	
	@Override
	public String toString() {
		return Character.toString(shape);
	}

}
