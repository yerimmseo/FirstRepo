package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A05_PrepareStatement {

	public static void main(String[] args) {
		// ����ڷκ��� 2���� ���� �Է¹޾� INSERT �Ѵٰ� ����
		String fname = "Kiwi";
		String fcolor = "Purple";
		
		// ���� ����� (SQL Injection)
		//String sql = "INSERT INTO fruits VALUES(fruits_seq.nextval, " + fname + "," + fcolor + ")";

		// PrepareStatement�� �غ��ų �������� ������ �ʿ��ϴٸ� �����ڸ��� ?�� ä���
		String sql = "INSERT INTO fruits VALUES(fruits_seq.nextval, ?, ?)";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			// ������ ���� ?�� ä�� �� �ִ�
			pstmt.setString(1, fname);
			pstmt.setString(2, fcolor);
			
			// ����
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
