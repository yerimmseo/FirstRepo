package theory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class E05_StreamToPrimitive {
	
	/*
		# DataInputStream/DataOutPutStream
		- Reader/Writer�� Stream�� ���ڷ� �ս��� �ٷ�� ���� Ŭ�������ٸ�
		  DataInputStream/DataOutputStream�� �⺻�� Ÿ������ �ս��� �ٷ�� ���� Ŭ������
	*/
	
	public static void main(String[] args) {
		
		File file = new File("./data/myData.data");
		
		try {
			FileOutputStream fout = new FileOutputStream(file);
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(9990);
			dout.writeInt(3000);
			dout.writeInt(850);
			dout.writeFloat(123.123F);
			dout.writeDouble(12345.12345678);
			dout.writeUTF("UTFŸ������ ����");
			dout.writeBoolean(false);
			
			// ����� ��Ʈ���� ���� �ֱٿ� ���� �� ���� ���ʴ�� �ݾ���� �Ѵ�
			// �� JAVA15 �������δ� dout�� �ݾƵ� fout�� �Բ� ������
//			OutputStreamWriter writer = new OutputStreamWriter(fout, Charset.forName("UTF-8"));
//			writer.append("�ȳ��ϼ���!");
//			writer.flush();
//			
//			writer.close();
			dout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		FileInputStream fin;
		DataInputStream din;
		try {
			fin = new FileInputStream(file);
			din = new DataInputStream(fin);
			
			// �� writeInt�� ��� ���� readInt�� �о�� �Ѵ�
			//   ���Ͽ� ��� ������� ������ �����͸� �ٽ� ������ �� �ִ�
			System.out.println("�Ʊ� �����ߴ� ù ��° int: " + din.readInt());
			System.out.println("�Ʊ� �����ߴ� �� ��° int: " + din.readInt());
			System.out.println("�Ʊ� �����ߴ� �� ��° int: " + din.readInt());
			System.out.println("float: " + din.readFloat());
			System.out.println("double: " + din.readDouble());
			System.out.println("UTF: " + din.readUTF());
			System.out.println("boolean: " + din.readBoolean());

			din.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
