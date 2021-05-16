package theory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class E04_StreamToChar {
	
	/*
		# Reader/Writer
		- InputStream�� OutputStream�� �����͸� ����Ʈ ������ �а� ����
		- ����Ʈ ������ �����͸� ����ϱ� ������ ���ϴ� Ÿ�������� �籸���� �ʿ��ϴ�
		- Reader�� Writer�� �����͸� ���� ������ �а� ���� Ŭ�������̴�
		- InputStream/OutputStream�� Reader/Writer�� �� �� �� ���μ� ����Ѵ�
		
		# abstract class Reader
		- BufferedReader, InputStreamReader, FileReader ... ����
		  ��� Reader Ŭ������ ��ӹ޾� ������ Ŭ�������̴�
		- Stream���� ���� �����͸� ���ڷ� �籸���Ͽ� ���α׷��Ӱ� ����ϱ� ���ϰ� ���ش�
		- ���ڷ� ��ġ�ų� ����Ʈ�� ��ȯ�� �� ����� ���ڵ� Ÿ���� ������ �� �ִ�
	*/
	public static void main(String[] args) {
		//System.out.println(Charset.availableCharsets());
		try {
			InputStreamReader in = new InputStreamReader(
					new FileInputStream(new File("./note/Git ��� ����.txt")), 
					Charset.forName("MS949"));
			
			int ch;
			while ((ch = in.read()) != -1) {
				System.out.print((char)ch);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			//FileWriter fw = new FileWriter(new File("abc"), Charset.forName("abc"));
			
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream("./data/output.py"),
					Charset.forName("UTF-8"));
			
			out.append("print('hello, python')\n");
			out.append("if True:\n");
			out.append("\tprint('that\\'s true')");
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








