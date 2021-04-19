package theory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class D04_LinkedList {

	/*
		# 연결 리스트
		- ArrayList보다 삽입/삭제에 유리한 리스트
		- 데이터 중간에 삽입이 발생했을 때 ArrayList는 모든 데이터를 뒤로 밀어야하지만
		  연결 리스트는 연결된 노드만 바꾸기 때문에 훨씬 빠르다
		- ArrayList는 데이터 보관 및 읽기에 유리하고
		  LinkedList는 데이터 추가 수정 및 삭제에 유리하다
	*/
	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<>();
		
		// LinkedList의 add들
		animals.add("tiger");
		animals.add("lion");
		animals.add("horse");
		
		System.out.println(animals);
		
		animals.addFirst("turtle");
		animals.addLast("monkey");
		
		System.out.println(animals);
		
		// LinkedList의 get들
		System.out.println(animals.get(3));
		System.out.println(animals.getFirst());
		System.out.println(animals.getLast());
		
		// pop(), poll(): 리스트에서 맨 앞 데이터를 읽고 버린다
		while (animals.size() != 0) {
			System.out.println("pop! (poll!)" + animals.poll());
		}
		
		// pollLast(): 리스트의 맨 뒤 데이터를 읽고 버린다
		ArrayList<String> cage = new ArrayList<>();
		cage.add("rabbit");
		cage.add("hamster");
		cage.add("bird");
		cage.add("fish");
		
		animals.addAll(cage);
		
		while (animals.size() != 0) {
			System.out.println("뒤에서부터 꺼내기: " + animals.pollLast());
		}
		
		
		// 성능 테스트
		int testSize = 1000000;
		
		ArrayList<Integer> arr = new ArrayList<>(testSize);
		for (int i = 0; i < testSize; i++) {
			arr.add(i);
		}
		
		LinkedList<Integer> linked = new LinkedList<>();
		
		for (int i = 0; i < testSize; i++) {
			linked.add(i);
		}
		
		// 데이터 추가 성능 비교
		System.out.println("1. ArrayList Insertion Test");
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 5000; i++) {
			arr.add(50, 10);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
		
		
		System.out.println("2. LinkedList Insertion Test");
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 5000; i++) {
			arr.add(50, 10);
		}
		
		endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
	}
}











