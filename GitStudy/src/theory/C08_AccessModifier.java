package theory;
import myobj.Coffee;
import myobj.DiffPackage;

public class C08_AccessModifier {
	/*
		# ���� ������ (Access Modifier)
		- �ٸ� Ŭ������ �ش� Ŭ������ �ڿ��� ����Ϸ��� �� �� ������ ��������� �����Ѵ�
		
		# ���� �����ڸ� ���� ������ �� �ִ� �Ÿ��� ����
		- ���� Ŭ���� ������ �ٸ� �ڿ� (���� ����� �Ÿ�)
		- ���� ��Ű�� ������ �ٸ� �ڿ�
		- �ٸ� ��Ű���� ������ ��ӹ��� �ڿ�
		- �ٸ� ��Ű�� �ڿ� (���� �� �Ÿ�)
		
		# ���� ������ ����
		- private
			�տ� private�� ���� �ڿ��� ���� Ŭ���� ���ο����� ������ �� �ְ� �ȴ� 
		- default (�ƹ��͵� �Ⱦ�)
			���� ��Ű�� ���ο����� �����Ӱ� ������ �� �ְ� �ȴ�.
			�ٸ� ��Ű�������� ������ �� ����.
		- protected
			�տ� protected�� ���� �ڿ���
				���� ��Ű�� ���ο����� �����Ӱ� ������ �� �ִ�.
				�ٸ� ��Ű�������� ��ӹ��� Ŭ������ ������ �� �ִ� �ڿ��� �ȴ�.
		- public
			�ٸ� ��Ű�������� �����Ӱ� ������ �� �ִ� �ڿ��� �ȴ�.
	*/
	public static void main(String[] args) {
		C08_SamePackage instance = new C08_SamePackage();
		
		instance.protected_method();
		instance.default_method();
		instance.default_method();
		
		myobj.DiffPackage instance2 = new DiffPackage();
		instance2.public_method();
		
		Coffee coffee1 = new Coffee(Coffee.AMERICANO, 1800, 10, Coffee.COLOMBIA);
		Coffee coffee2 = new Coffee(Coffee.CAFE_LATTE, 2500, 20, Coffee.KENYA);
		Coffee coffee3 = new Coffee(Coffee.CAFE_MOCHA, 3500, 25, Coffee.INDIA);
		
	}
}

class Snack {
	//private int size = 10;
	int size = 10;
	
	private void eat() {
		System.out.println(size - 1);
	}
}

class HoneyButterChip extends Snack {
	
	private void abc() {
		System.out.println(size);
	}
}

class Choco extends DiffPackage {
	
	public Choco() {
		// protected : ��ӹ����� �ٸ� ��Ű������ ��� ����
		this.protected_method();
	}
	
	void abc() {
		Snack s = new Snack();
		System.out.println(s.size);
	}
}
