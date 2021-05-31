package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class A02_CRUD {
	
	public static void main(String[] args) {
		/*
			JDBC���� SELECT�� ResultSet�� ��ȯ�Ѵ�
			�� ���� DML(INSERT, UPDATE, DELETE)�� ����� ���� ������ ��ȯ�Ѵ�.
			
			SELECT�� PreparedStatement�� executeQuery()�޼��带 ����ϰ�
			�������� executeUpdate() �޼��带 ����Ѵ�
		*/
		String sql = "INSERT INTO fruits(fid, fname, fcolor) "
				+ "VALUES(fruits_seq.nextval, 'Kiwi', 'ORANGE')";
		String sql2 = "SELECT * FROM fruits";
		
		try (
				Connection conn = DBConnecter.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		) {
			for (int i = 0; i < 10; ++i) {
				// INSERT, UPDATE, DELETE	
				int rows = pstmt.executeUpdate();
				//System.out.println(rows + "row(s) update");
			}
			
			// SELECT
			ResultSet rs = pstmt2.executeQuery();
			
			while (rs.next()) {
				System.out.printf("%d\t%s\t%s\n",
						rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
			System.out.println("����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
