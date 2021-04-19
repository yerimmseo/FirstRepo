package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 제네릭을 설정해둔 클래스는 인스턴스 생성시 원하는 타입을 고를 수 있게 된다
// 고르지 않으면 Object로 설정된다
public class D02_JiphapQuiz<T> {
	
	/*
		1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set타입으로 반환하는 메서드
		2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set타입으로 반환하는 메서드
		3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set타입으로 반환하는 메서드
	*/
	
	public Set<T> union(Collection<? extends T> a, Collection<? extends T> b){
		Set<T> union_set = new HashSet(a);
		union_set.addAll(b);
		return union_set;
//		a.addAll(b);
//		return new HashSet<>(a);
	}
	
	public static int plus(int a, int b) {
		a += b;
		return a;
	}
	
	public static Set intersection(Collection a, Collection b) {
//		Set gyo = union(a, b);
//		gyo.retainAll(a);
//		gyo.retainAll(b);
//		return gyo;
		Set inter_set = new HashSet<>(a);
		inter_set.retainAll(b);
		return inter_set;
	}
	
	// 1 2 3 4 
	// 3 4 5 6
	
	// 1 2 3 4 5 6
	// 3 4
	
	// 1234 - 3456 -> 12
	
	// A - B
	// B - A
	public static Set diff(Collection a, Collection b) {
//		Set cha = union(a, b);
//		Set gyo = intersection(a, b);
//		cha.removeAll(gyo);
//		return cha;
		Set diff_set = new HashSet<>(a);
		diff_set.removeAll(b);
		return diff_set;
	}
	
	public static void main(String[] args) {
		// 소문자로 시작하는 타입들(기본형)은 매개변수로 전달할 때 값을 복사하여 전달한다
		int int_a = 20;
		int int_b = 30;
		
		System.out.println(plus(int_a, int_b));
		System.out.println("plus 후 int_a의 값: " + int_a);
		
		// 대문자로 시작하는 타입들(참조형)은 매개변수로 전달할 때 주소를 복사하여 전달한다
		List<String> a = new ArrayList<>();
		Set<String> b = new HashSet<>();
		Set<String> c = new HashSet<>();
		
		a.add("apple");
		a.add("orange");
		a.add("pineapple");
		a.add("strawberry");
		a.add("watermelon");
		
		b.add("apple");
		b.add("orange");
		b.add("peach");
		b.add("kiwi");
		
		c.add("cow");
		c.add("cat");
		c.add("crack");
		c.add("pineapple");
		c.add("apple");
		
//		System.out.println(a);
//		System.out.println(b);
		
		D02_JiphapQuiz<String> jiphap_tools = new D02_JiphapQuiz<String>();
		D02_JiphapQuiz<Integer> jiphap_tools2 = new D02_JiphapQuiz<Integer>();
		
		System.out.println("union 실행하기 전의 a : " + a);
		System.out.println(jiphap_tools.union(a, b));
		System.out.println("\nunion 실행한 후의 a : " + a);
		System.out.println(jiphap_tools.union(a, c));
		
		System.out.println(intersection(a, b));
		System.out.println(intersection(intersection(a, b), c));
		System.out.println(diff(a, b));
	}

}















