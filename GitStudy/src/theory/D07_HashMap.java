package theory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class D07_HashMap {

	/*
		# Map
		- Key와 Value가 한 쌍을 이루는 자료구조
		- Key값을 통해 Value에 접근할 수 있다
		- Key는 중복을 허용하지 않는다
	*/
	public static void main(String[] args) {
		
		HashMap<String, Integer> record = new HashMap<>();
		
		// put(key, value)
		// - map에 데이터 추가
		// - 예전에 들어있던 값이 있으면 그 값을 리턴, 없으면 null을 리턴
		record.put("홍길동", 50000);
		record.put("박길동", 35000);
		record.put("고길동", 90000);
		
		// 이미 존재하는 키값에 put하면 값을 수정
		Integer previous_value = record.put("홍길동", 3500);
		
		System.out.println("이전에 들어있던 값: " + previous_value);
		System.out.println("지금 들어있는 값: " + record.get("홍길동"));
		
		// 연습문제 : "홍길동"에 저장되어있는 돈을 3000 증가시켜 보세요
		record.put("홍길동", record.get("홍길동") + 3000);
		
		System.out.println(record);
		
		// get(key) : key를 통해 value를 꺼냄
		System.out.println(record.get("박길동"));
		
		HashMap<String, Object> person = new HashMap<>();
		
		person.put("이름", "홍길동");
		person.put("나이", 35);
		person.put("좋아하는 것", new String[] {"놀기", "잠자기", "먹기" });
		person.put("싫어하는 것", new HashSet<>());
		
		//연습문제 : "싫어하는 것"에 데이터를 추가해보세요
		HashSet<String> dislike = ((HashSet)person.get("싫어하는 것"));
		
		//((HashSet<String>)person.get("싫어하는 것")).add("야근");
		dislike.add("야근");
		dislike.add("특근");
		dislike.add("출퇴근");
		
		System.out.println(person.get("나이"));
		System.out.println(((String[])person.get("좋아하는 것"))[0]);
		System.out.println(person.get("싫어하는 것"));
		
		/*  # 반복문으로 Map을 활용하기
			- keySet() : key들로만 이루어진 Set을 반환한다
			- values() : value들로만 이루어진 Set을 반환한다
			- entrySet() : Entry<key, value>로 이루어진 Set을 반환한다
		*/
		for (String key : person.keySet()) {
			Object value = person.get(key);
			
			// A instanceof B 연산자 : A가 B의 인스턴스인지를 판별한다. 업캐스팅된 상태에서도 판별된다 
			if (value instanceof String[]) {
				String[] arr = (String[])value;
				
				System.out.print(key + ": [");
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + ", ");
				}
				System.out.println("]");
			} else {
				System.out.println(key + ": " + value);
			}
		}
		
		// # values()
		System.out.println("values: " + person.values());
		
		// # entrySet()
		System.out.println("entrySet() 그냥 출력 : " + person.entrySet());
		for (Entry<String, Object> entry : person.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			
			System.out.println(key + "=" + value);
		}
		
	}
	
}
