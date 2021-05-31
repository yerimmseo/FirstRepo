package theory;

public class C11_AnonymousInnerClass {

	/*
		# 익명 내부 클래스
		- 클래스에 이름을 짓지 않고 구현한 다음 바로 사용하는 방식
		- 일회용이다
		
	*/
	
	public static void kick(Kickable somthing) {
		somthing.kick();
	}
	
	public static void main(String[] args) {
		kick(new Human());
		kick(new VendingMachine());
		kick(new Ball("메시"));
		kick(new Ball("기성용"));
		
		// # 지역 내부 클래스
		class Door extends Kickable {
			
			boolean open;
			
			void kick() {
				if (open) {
					System.out.println("문짝을 발로 차서 닫았습니다.");
					open = false;
				} else {
					System.out.println("문짝을 발로 걷어차서 열었습니다.");
					open = true;
				}
			}
		}
		
		Door door1 = new Door(), door2 = new Door(), door3 = new Door();
		
		kick(door1);
		kick(door1);
		kick(door1);
		kick(door2);
		kick(door3);
		kick(door3);
		
		// # 익명 클래스 (즉석에서 클래스를 상속한 인스턴스를 생성)
		// - 만들고 따로 저장하지 않기 때문에 다시는 사용할 수 없다 (일회용)
		kick(new Door() {
			@Override
			void kick() {
				System.out.println("튼튼한 금고문이 무거워서 꿈쩍도 하지 않았습니다.");
			}
		});
		
		kick(new Ball() {
			@Override
			void kick() {
				System.out.println("농구공을 발로 찼더니 멀리 나가지는 않고 아프기만 합니다.");
			}
		});
		
		// punch 메서드의 인자값으로 전달할 수 있는 익명 클래스로 2개와 지역 내부 클래스로 2개를 만들어서 전달해보세요
		class Tree extends Punchable {
			int count = 0;
			void punch() {
				System.out.println("나무를 쳤습니다.");
				count++;
				if (count == 5) {
					System.out.println("나무가 쓰러졌습니다.");
				}
			}
		}
		
		Tree tree1 = new Tree();
		tree1.punch();
		tree1.punch();
		tree1.punch();
		tree1.punch();
		tree1.punch();
		
		class Hole extends Punchable {
			int num = 1;
			@Override
			void punch() {
				System.out.printf("%d개 구멍을 냈습니다.\n", num);
				num++;
			}
		}
		
		Hole hole1 = new Hole();
		hole1.punch();
		hole1.punch();
		hole1.punch();
		hole1.punch();
		
		punch(new Air() {
			@Override
			void punch() {
				System.out.println("허공에 주먹을 휘둘렀습니다.");
			}
		});
		
		punch(new PunchMachine() {
			@Override
			void punch() {
				System.out.println("오락실에 가서 펀치기계를 쳤습니다.");
			}
		});
		
	}
	
	public static void punch(Punchable somthing) {
		somthing.punch();
	}
}

abstract class Punchable {
	abstract void punch();
}

class PunchMachine extends Punchable {
	@Override
	void punch() {
		System.out.println("오락실에 갔습니다.");
	}
}

class Air extends Punchable {
	@Override
	void punch() {
		System.out.println("주먹");
	}
}

abstract class Kickable {
	abstract void kick();
}

class Ball extends Kickable {
	
	String kicker;
	
	public Ball() {}
	
	public Ball(String kicker) {
		this.kicker = kicker;
	}
	
	@Override
	void kick() {
		if (kicker.equals("메시")) {
			System.out.println("슛을 멋있게 찼습니다.");
		} else if (kicker.equals("기성용")) {
			System.out.println("패스를 정확하게 찼습니다.");
		}
	}
}

class Human extends Kickable {
	
	@Override
	void kick() {
		System.out.println("사람을 발로 걷어찼습니다.");
	}
}

class VendingMachine extends Kickable {
	
	@Override
	void kick() {
		System.out.println("자판기를 걷어찼더니 음료수가 하나 나왔습니다.");
	}
}
