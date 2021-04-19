package quiz;

public class A03_Introduce {

	public static void main(String[] args) {
		
		String banner = "========== 출력 결과 ==========";
		String name = "홍길동", tel = "010-1234-1234";
		int age = 20;
		double height = 178.5, weight = 75;
		String blood = "AB";
		boolean takeBus = false;
		
		System.out.println(banner);
		System.out.println();
		System.out.println("이름\t: " + name);
		System.out.println("나이\t: " + age);
		System.out.println("Tel\t: " + tel);
		System.out.println("키\t: " + height);
		System.out.println("몸무게\t: " + weight);
		System.out.println("혈액형\t: " + blood);
		System.out.println("버스를 타고 왔는가 : " + takeBus);
		
	}
}
