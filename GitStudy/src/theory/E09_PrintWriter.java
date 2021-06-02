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
		- Writer�� �� �� �� ���μ� ���� ���(print �޼����)���� �߰��س��� Ŭ����
		- printf(), println()���� �����Ǿ� �ִ�
		
		# PrintStream
		- Stream�� �� �� �� ���μ� ���ϰ� print�� �� �� �ִ� Ŭ����
	*/
	public static void main(String[] args) {
		
		try (
				FileOutputStream fout = new FileOutputStream(new File("./printwritertest.txt"));
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				PrintWriter out = new PrintWriter(bout);
		) {
			out.println(" /)/)");
			out.println("( ..)");
			out.println("( >��)");
			out.println(123);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
