package theory;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class D11_Calendar {

	/*
		# Date, Calendar, Time
		- 자바로 날짜와 시간 다루는 클래스
	*/
	public static void main(String[] args) {
		
		// 시스템의 유닉스 타임을 가져오는 메서드
		// ※ 유닉스 타임 - 1970년 1월 1일 이후로 시간이 몇 밀리초나 흘렀는지 센 것
		System.out.println("1970년 1월 1일 이후로.. " +
				System.currentTimeMillis() + "밀리초 흘렀습니다.");
		
		System.out.println("1970년 1월 1일 이후로.. " + 
				System.currentTimeMillis() / 1000 + "초 흘렀습니다.");
		
		System.out.println("1970년 1월 1일 이후로.. " + 
				System.currentTimeMillis() / 1000 / 60 + "분 흘렀습니다.");
		
		System.out.println("1970년 1월 1일 이후로.. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 + "시간 흘렀습니다.");
		
		System.out.println("1970년 1월 1일 이후로.. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 / 24 + "일 흘렀습니다.");
		
		System.out.println("1970년 1월 1일 이후로.. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365 + "년 흘렀습니다.");
		
		
		/* 
			Date 
			- Date 클래스 내부의 메서드들은 요즘 버전에서는 거의 업데이트가 중단되어 있다
			- 시간을 계산할 때는 다른 클래스를 사용할 것을 권장한다
			- Date 클래스는 주로 시간 인스턴스를 보관하는 용도로만 사용한다
		*/
		Date now = new Date();
		System.out.println(now);
		
		
		/*
			Calendar
			- 달력을 표현한 클래스
			- 날짜를 쉽게 계산할 수 있는 기능들이 모여있다
			- 시간을 가져올 때 생성자가 아닌 getInstance()라는 스태틱 메서드를 사용한다
			- getInstance() 메서드에 경도를 나타내는 TimeZone을 전달할 수 있다
			
			TimeZone
			- 여러 지역의 시차를 보관하고 있는 클래스
			- getAvailableIDs() 스태틱 메서드를 통해 사용할 수 있는 타임존들을 볼 수 있다
		*/
		
		for (String zoneID : TimeZone.getAvailableIDs()) {
			System.out.println(zoneID);
		}
		
		// Date 타입으로 변환하면 시차가 사라진다
		Calendar korea = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println("한국 현재 시간: " + korea.get(Calendar.HOUR));
		
		// Calendar에 저장된 시간 중 필요한 값을 get() 메서드를 통해 꺼낼 수 있다
		int year = korea.get(Calendar.YEAR);
		int month = korea.get(Calendar.MONTH); // Calendar 클래스는 month만 0으로 시작한다
		int date = korea.get(Calendar.DATE);
		
		// Calendar에 저장된 시간을 set() 메서드를 통해 수정할 수 있다
		korea.set(Calendar.HOUR_OF_DAY, 15);
		
		int hour = korea.get(Calendar.HOUR);
		int hourOfDay = korea.get(Calendar.HOUR_OF_DAY);
		
		int minute = korea.get(Calendar.MINUTE);
		int second = korea.get(Calendar.SECOND);
		int millisec = korea.get(Calendar.MILLISECOND);
		
		korea.set(Calendar.YEAR, -50);
		
		// Calendar.ERA가 필드 상수이고, GregorianCalendar.AD와 .BC가 상수이다
		int era = korea.get(Calendar.ERA);
		
		// Calendar.AM_PM이 필드 상수이고, Calendar.AM과 Calendar.PM은 상수이다
		int am = korea.get(Calendar.AM_PM);
		
		//korea.set(Calendar.DATE, 14);
		
		int doy = korea.get(Calendar.DAY_OF_YEAR);
		int dom = korea.get(Calendar.DAY_OF_MONTH);
		int dow = korea.get(Calendar.DAY_OF_WEEK);
		int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		System.out.println("DOY(올해가 시작되고 지난 날짜): " + doy);
		System.out.println("DOM(이번 달 시작하고 지난 날짜): " + dom);
		System.out.println("DOW(이번 주 시작하고 지난 날짜, 요일): " + dow);
		System.out.println("DOWIM(이번 달의 몇 번째 해당 요일인가): " + dowim);
		
		System.out.println("Calendar.SUNDAY: " + Calendar.SUNDAY);
		System.out.println("Calendar.MONDAY: " + Calendar.MONDAY);
		System.out.println("Calendar.TUESDAY: " + Calendar.TUESDAY);
		System.out.println("Calendar.WEDNESDAY: " + Calendar.WEDNESDAY);
		System.out.println("Calendar.THURSDAY: " + Calendar.THURSDAY);
		System.out.println("Calendar.FRIDAY: " + Calendar.FRIDAY);
		System.out.println("Calendar.SATURDAY: " + Calendar.SATURDAY);
		
		
		System.out.printf("%s: %d/%d/%d\n", 
				korea.getTimeZone().getID(), year, month + 1, date);
		System.out.printf("hour(12H): %d, hourOfDay(24H): %d\n", hour, hourOfDay);
		System.out.printf("%d:%d.%03d\n", minute, second, millisec);
		
		System.out.println(era == GregorianCalendar.AD ? "AD" : "BC");
		System.out.println(era != GregorianCalendar.BC ? "AD" : "BC");
		
		System.out.println(am == Calendar.AM ? "AM" : "PM");
		System.out.println(am != Calendar.PM ? "AM" : "PM");
		
		
		Calendar hawaii = Calendar.getInstance(TimeZone.getTimeZone("US/Hawaii"));
		System.out.println("뉴욕 현재 시간: " + hawaii.get(Calendar.HOUR));
		
	}
	
}
