package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A03_JdbcTransaction {

	public static void main(String[] args) {
		String sql = "UPDATE fruits SET fcolor='BLUE' WHERE fname='Kiwi'";
		
		try (
				Connection conn = DBConnecter.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			// JDBC�� ó�� ������ �����ϸ� �⺻������ AutoCommit�� Ȱ��ȭ �Ǿ��ִ�.
			// Ʈ�������� ���� �����ϱ� ���ؼ��� �ڵ� Ŀ���� ��Ȱ��ȭ �ؾ��Ѵ�.
			conn.setAutoCommit(false);
			
			int rows = pstmt.executeUpdate();
			
			System.out.println(rows + "���� ������Ʈ �Ǿ����ϴ�.");
			
			if (rows % 2 == 0) {
				conn.commit();
				System.out.println("Ŀ�� �Ϸ�.");
			} else {
				conn.rollback();
				System.out.println("�ѹ� �Ϸ�.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
