package theory;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class E09_PrintWriter {
	/*
		# PrintWriter
		- Writer를 한 번 더 감싸서 편리한 기능(print 메서드들)까지 추가해놓은 클래스
		- printf(), println()등이 구현되어 있다
		
		# PrintStream
		- Stream을 한 번 더 감싸서 편리하게 print를 할 수 있는 클래스
	*/
	public static void main(String[] args) {
		
		try (
				FileOutputStream fout = new FileOutputStream(new File("./printwritertest.txt"));
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				PrintWriter out = new PrintWriter(bout);
		) {
			out.println(" /)/)");
			out.println("( ..)");
			out.println("( >♡)");
			out.println(123);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
