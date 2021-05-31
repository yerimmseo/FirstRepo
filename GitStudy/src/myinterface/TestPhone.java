package myinterface;

import myobj.remote.Iphone;

public class TestPhone {

	public static void main(String[] args) {
		test(new Iphone());
	}
	
	public static void test(Phone phone) {
		phone.call();
		phone.internet();
		phone.text();
		phone.kakao();
	}
	
}
