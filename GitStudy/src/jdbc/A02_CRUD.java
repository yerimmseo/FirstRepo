package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class A02_CRUD {
	
	public static void main(String[] args) {
		/*
			JDBC에서 SELECT는 ResultSet을 반환한다
			그 외의 DML(INSERT, UPDATE, DELETE)은 적용된 행의 개수를 반환한다.
			
			SELECT는 PreparedStatement의 executeQuery()메서드를 사용하고
			나머지는 executeUpdate() 메서드를 사용한다
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
			
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
