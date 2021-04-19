package theory;
import java.util.Scanner;

public class C06_Polymorphism {

	/*
		# ��ü�� ������
		- ��ü�� �پ��� ���¸� ���� �� �ִ�
		- ����� ����̱⵵ �ϰ� �����̱⵵ �ϴ�
		- ������ ���������� ����� �ƴϴ�
		
		# �ڽ� Ŭ������ �θ� Ŭ������ �� �� �ִ� (��ĳ����)
		- �ڽ� Ŭ���� Ÿ���� �θ� Ŭ���� Ÿ���� �Ǵ� ���� ��ĳ�����̶�� �Ѵ�
		- ��ĳ������ �� ��ä�� �ڽ� Ŭ�������� �����ϴ� �͵��� ��� �ؾ������
		- �������̵�� �޼���� �ڽ� Ŭ�������� ������ ������ ����ȴ�
		
		# �θ� Ŭ������ �ڽ� Ŭ������ �� �� ���� (�ٿ� ĳ����)
		- ������ ���������� ��ĳ������ �Ǿ��� �ν��Ͻ��� �ٽ� ���� Ÿ�������� �ٿ�ĳ������ �����ϴ�
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
		police.arrest("�谭��");
		
		// Person���� ��ĳ���� �� Police�� ü���� �� �� ����
		Person person = police; 
		Person person2 = new Person("����ġ", 20, 30);
		//Person.arrest();
		person.sayHi();
		
		// �ٿ� ĳ������ �̿��� ���� ��� �ٽ� ����ϱ�
		
		// ���� �����̾��� �ν��Ͻ��� �ٿ�ĳ������ ����
		((Police)person).arrest("��Ҹ�");
		
		// ������ �ƴϾ��� �ν��Ͻ��� �ٿ�ĳ������ �Ұ���
		((Police)person2).arrest("�赵��");
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

// ���� ���� �θ� Ŭ���� (�����, �����, �ҽ�)
class MainMaterial {}
class SubMaterial {}
class Sauce {}

// ����Ḧ ��ӹ��� Ŭ������
class Fish extends MainMaterial {}
class Meat extends MainMaterial {}
// ����Ḧ ��ӹ��� Ŭ������ ��ӹ��� Ŭ����
class PigMeat extends Meat {}

// ����Ḧ ��ӹ��� Ŭ������
class Vege extends SubMaterial {}
class Fruit extends SubMaterial {}

// �ҽ��� ��ӹ��� Ŭ������
class Salsa extends Sauce {}
class Balsamic extends Sauce {}









