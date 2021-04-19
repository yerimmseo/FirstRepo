package quiz;

import myobj.yachtdice.Dice;

public class C08_FiveDice {

	/*
		랜덤으로 5개의 주사위를 굴린 다음에 결과를 통해 다음을 구분하는 클래스를 만들어보세요
		1. 풀하우스 (같은 눈이 2개 + 3개) (11666/22333/63663) (주사위 눈이 점수)
		2. 스몰 스트레이트 (1234/2345/3456) (15점)
		3. 라지 스트레이트 (12345/23456/45623) (30점)
		4. 4 다이스 (같은 숫자 4개) (주사위 눈이 점수)
		5. 5 다이스 (같은 숫자 5개) (50점)
		
		※ Yacht Dice를 검색해보세요
		
		# 메서드
		(1) 모든 주사위를 던지는 메서드
		(2) 원하는 주사위를 제외하고 나머지를 던지는 메서드
		(3) 주사위를 새로 던질 때 마다 위의 1,2,3,4,5 중 해당하는 것이 있는지 체크하는 메서드
	*/
	
	public static void main(String[] args) {
		
		Dice dice = new Dice();
		dice.throwDice();
		dice.checkDice();
		dice.checkFullHouse();
	}
}