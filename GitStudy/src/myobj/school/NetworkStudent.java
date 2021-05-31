package myobj.school;

public class NetworkStudent extends Student {

	final static String[] subject_name = {"국어", "영어", "리눅스", "CCNA"};
	
	int linux;
	int ccna;
	
	public NetworkStudent(int sno) {
		super(sno);
		linux = getRandomScore();
		ccna = getRandomScore();
	}

	@Override
	public void printGradeCard() {
		System.out.printf("학번\t이름\t%s\t%s\t%s\t%s\t총점\t평균\n", subject_name[0],
				subject_name[1], subject_name[2], subject_name[3]);
		
		System.out.printf("%X\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\n",
				sno,
				name,
				kor,
				eng,
				linux,
				ccna,
				kor + eng + linux + ccna,
				(kor + eng + linux + ccna) / 4.0);
		
		System.out.println("--------------------------------------------------------------");
		
	}
	
}
