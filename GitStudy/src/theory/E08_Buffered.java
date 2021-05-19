package theory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class E08_Buffered {
	
	public static void main(String[] args) {
		
		// 1. frankenstein.txt를 한 글자씩 모두 읽고 걸린 시간을 측정해보세요
		// 2. 한 글자씩 읽을때와 배열을 사용해서 읽을 때의 성능을 비교해보세요
		
		File novel = new File("./data/text/frankenstein.txt");
		
		long start = System.currentTimeMillis();
		long end = 0;
		
		try (FileReader in = new FileReader(novel)) {
			StringBuilder sb = new StringBuilder();
			int ch = -1;
			while ((ch = in.read()) != -1) {
				sb.append((char)ch);
			}
			end = System.currentTimeMillis();
			
			System.out.println("걸린 시간: " + (end - start) + "ms");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		long start2 = System.currentTimeMillis();
		
		try (FileReader in = new FileReader(novel)) {
			StringBuilder sb = new StringBuilder();
			
			char[] buff = new char[2048];
			int len = -1;
			while ((len = in.read(buff)) != -1) {
				sb.append(new String(buff, 0, len));
			}
			end = System.currentTimeMillis();
			System.out.println("걸린 시간2: " + (end - start2) + "ms");
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		start = System.currentTimeMillis();
		try (
				FileReader fin = new FileReader(novel);
				BufferedReader bin = new BufferedReader(fin, 4096)
			) {
//			BufferedReader bin = new BufferedReader(new FileReader(novel), 2048);
			
			StringBuilder sb = new StringBuilder();
			
			String line = null;
			while ((line = bin.readLine()) != null) {
				sb.append(line);
			}
			end = System.currentTimeMillis();
			System.out.println("걸린 시간3: " + (end - start) + "ms");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try (BufferedWriter bout = new BufferedWriter(new FileWriter(new File("./data/text/abc.txt")))) {
			bout.append("Hello, BufferedWriter!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
