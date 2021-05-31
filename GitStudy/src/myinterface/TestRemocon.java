package myinterface;

import myobj.remote.AirConditionRemocon;
import myobj.remote.TelevisionRemocon;

// �������̽��� ���� ���յ��� ���� �ڵ带 �ۼ��� �� �ִ�
public class TestRemocon {

	public static void main(String[] args) {
		test(new AirConditionRemocon());
		test(new TelevisionRemocon());
	}
	
	public static void test(Remocon remocon) {
		remocon.power();
		remocon.up(1);
		remocon.down(1);
		remocon.change();
	}
	
}
