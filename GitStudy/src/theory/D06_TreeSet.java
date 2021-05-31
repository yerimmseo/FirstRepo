package theory;
import java.util.Comparator;
import java.util.TreeSet;

public class D06_TreeSet {

	/*
		# TreeSet
		- �ߺ����� ������ �� ����
		- �����͸� ������ �� Comparator�� �̿��� �̸� �����Ѵ�
		- ��ҷ� null�� ������� �ʴ´�
		- ó���� �����ؼ� �ֱ� ������ HashSet�� ���� ���� �ӵ��� ������
		- ������ TreeSet�� ������ �̸� �Ǿ��ֱ� ������ ���ĵ� ������ �����͸� ������ ���� ���� ������
	*/
	public static void main(String[] args) {
		TreeSet<Grape> grape_tree = new TreeSet<>(new �����з���_GNO����_��������());
		TreeSet<Grape> grape_tree2 = new TreeSet<>(new �����з���_�����˸���_��������());
		
		// �ش� ��ü ��ü�� �� ������ ��ü��� Comparator�� ������� ���� �� �ִ�
		TreeSet<String> word_tree = new TreeSet<>();
		TreeSet<Mango> mango_tree = new TreeSet<>();
		TreeSet<Mango> mango_tree2 = new TreeSet<>(new MangoCompareByMnoAsc());
		
		for (int i = 0; i < 5; i ++) {
			mango_tree.add(
					new Mango(
							"MANGO" + String.format("%05d", (int)(Math.random() * 100000)),
							10,
							10));
		}
//		mango_tree.add(new Mango("00123", 10, 10));
//		mango_tree.add(new Mango("09999", 10, 10));
//		mango_tree.add(new Mango("00013", 10, 10));
		
		grape_tree.add(new Grape().setGno("1").setFruit(37));
		grape_tree.add(new Grape().setGno("2").setFruit(31));
		grape_tree.add(new Grape().setGno("3").setFruit(40));
		grape_tree.add(new Grape().setGno("4").setFruit(37));
		
		grape_tree2.addAll(grape_tree);
		// ������ �����ָ� ������ ��
		//mango_tree.add(new Mango()); 
		
		System.out.println(grape_tree);
		System.out.println(grape_tree2);
		
		word_tree.add("cat");
		word_tree.add("pet");
		word_tree.add("pat");
		word_tree.add("fat");
		word_tree.add("bat");
		
		System.out.println(word_tree);
		System.out.println(mango_tree);
		
		// # TreeSet Ȱ��
		// descendingSet() : �̸� �����س��� ����� �ݴ� ������ Set �ν��Ͻ��� ��ȯ
		System.out.println(grape_tree.descendingSet());
		
		// headSet(toElement) : �� �պ��� ���ϴ� ��ұ��� �ڸ� Set�� ��ȯ
		System.out.println(grape_tree.headSet(new Grape().setGno("3")));
		
		// tailSet(toElement) : ���ϴ� ��Һ��� �� �ڱ��� �ڸ� Set�� ��ȯ
		System.out.println(grape_tree.tailSet(new Grape().setGno("3")));
		
		// subSet(fromElement, toElement) : ���ϴ� ��Һ��� �����ؼ� ���ϴ� ��ұ��� �ڸ� Set�� ��ȯ
		System.out.println(grape_tree.subSet(new Grape().setGno("3"), new Grape().setGno("1")));
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(5);
		int_tree.add(15);
		int_tree.add(75);
		int_tree.add(33);
		int_tree.add(21);
		int_tree.add(9);
		int_tree.add(1);
		
		System.out.println(int_tree);
		
		// ceiling(element) : ���ϴ� ���� ����� ��Ҹ� �÷��� ���� (������ ���� ����)
		System.out.println(int_tree.ceiling(20));
		System.out.println(int_tree.ceiling(21));
		System.out.println(int_tree.ceiling(22));
		
		// floor(element) : ���ϴ� ���� ����� ��Ҹ� ������ ���� (������ ���� ����)
		System.out.println(int_tree.floor(21));
		System.out.println(int_tree.floor(20));
		System.out.println(int_tree.floor(19));
		System.out.println(int_tree.floor(18));
		
		// higher(element) : ���ϴ� ���� ����� ��Ҹ� �÷��� ���� (������ �� ������)
		System.out.println(int_tree.higher(21));
		
		// lower(element) : ���ϴ� ���� ����� ��Ҹ� ������ ���� (������ �� ������)
		System.out.println(int_tree.lower(21));
		
		
		//-------------------------------------------------------------
		// ��������: ����Ʈ���� ���� 5�� �߰��ϰ� mno���� �������� ������ �ǵ��� ����� Ȯ��
		//        sysout���� ����� �� ���� ���� ���;� �� (���� �ּ�X)
		mango_tree2.add(new Mango("3", 10, 2));
		mango_tree2.add(new Mango("4", 10, 2));
		mango_tree2.add(new Mango("1", 10, 2));
		mango_tree2.add(new Mango("2", 10, 2));
		mango_tree2.add(new Mango("5", 10, 2));
		
		System.out.println(mango_tree2);
		
	}
	
}

class MangoCompareByMnoAsc implements Comparator<Mango> {
	@Override
	public int compare(Mango o1, Mango o2) {
		return o1.mno.compareTo(o2.mno);
	}
}

class MangoCompareBySweetAsc implements Comparator<Mango> {
	/*
		# Comparator�� ��Ģ
		- compare �޼����� ���� ���� 1�̸� o1�� o2�� ������ �ٲ۴�
		- compare �޼����� ���� ���� 0�̸� ���� ũ��� ����Ѵ�
	    - compare �޼����� ���� ���� -1�̸� o1�� o2�� ������ �״�� �����Ѵ�
		  
		  [3, 2, 3, 8, 99, 1, 5, 8, 9]
	*/
	@Override
	public int compare(Mango o1, Mango o2) {
		if (o1.sweet > o1.sweet) {
			return 1;
		} else if (o1.sweet < o2.sweet) {
			return -1;
		} else {
			return 0;
		}
	}
}

// Comparator : ���� �� ����ϴ� �� ���� Ŭ������ ����� �������̽�
// Comparable : �� ��ü�� �� ������ Ŭ�������� ǥ���ϴ� �������̽�
class Mango implements Comparable<Mango> {
	String mno;
	int sweet;
	int size;
	
	public Mango(String mno, int sweet, int size) {
		this.mno = mno;
		this.sweet = sweet;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return mno + "/" + "�絵(" + sweet + ")" + "/" + "ũ��(" +size + ")"; 
	}

	// this vs �Ű������� compare�޼��带 �����ϸ� �ȴ�
	@Override
	public int compareTo(Mango o) {
		return this.mno.compareTo(o.mno);
	}
}
