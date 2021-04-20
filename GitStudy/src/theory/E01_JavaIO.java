package theory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01_JavaIO {

	/*
		# Java IO (Input/Output)
		- �ڹٴ� ��Ʈ���̶�� ������ �̿��� ������� �ٷ��
		- �ڹ� ���α׷����� ������ ��� �����͵��� �Է��̶�� �θ��� (Input)
		- ���α׷��� �����ؼ� �������� ��� �����͵��� ����̶�� �θ��� (Output)
		
		# Stream
		- �����͵��� ������ ���
		- �Է� ���� �� �����͵��� ���α׷����� ������ ��θ� InputStream�̶�� �θ���
		- ����� �� �����͵��� ������ ��θ� OutputStram�̶�� �θ���
		- �����ʹ� Stream���� �̵��ϱ� ���ؼ��� �ش� �����͸� byte Ÿ������ ��ȯ�ؾ� �Ѵ�
	*/
	
	public static void main(String[] args) {
		
		FileOutputStream fout = null;
		try {
			/*
				# ���� ��ο� �����
				- ���ϴ� �ڿ������� ��θ� �Ѹ�(root)���� ��� ���� ���� �����ζ�� �Ѵ�
				  (C:\, d:\, E:\, http://, https://, ftp://, file://)
				  * ������ ��
				  - D:\Pictures\animals\penguin.jpg
				  - https://i.pingimg.com/736x/23/a0/a7/23a0a77b9....jpg
				
				- ���ϴ� �ڿ������� ��θ� ���� ��ġ���� ã�ư��� ���� ����ζ�� �Ѵ�
				  ����δ� �ݵ�� ./�� �����Ѵ�
				  
				  (./) : ���� ������ ����
				  (./)../ : ���� ����
				  
				  * ����� ��
				  - ./../../penguin.jpg
				  - ./../images/penguin.jpg
			*/
			
			// �� �ҽ����� ���� ��ġ(./)�� ������Ʈ�� root�̴�
			fout = new FileOutputStream("b.txt", true);
			
			for (int i = 0; i < 10; i++) {
				fout.write(String.format("������ ������ �� ���׿�..%d\n", i).getBytes());
			}
			
			// �� I/O Stream�� �������� close()�� ȣ������� �Ѵ� (�޸� ȸ��)
			//fout.close();
			
			System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã�� �ͼ���");
		} catch (IOException e) {
			System.out.println("�����͸� ���ٰ� ������ ������");
		} finally {
			try {
				if (fout != null) fout.close();
			} catch (IOException e) {}
		}
	}
}
