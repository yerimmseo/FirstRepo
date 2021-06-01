package jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jdbc.model.Employee;

public class A04_DESC {
	
	public static void main(String[] args) {
		String sql = "SELECT * FROM employees";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			// ������ �������� ��Ÿ �����͵��� ������� ��
			ResultSetMetaData meta = rs.getMetaData();
			
			System.out.println("�÷��� ��ΰ�?" + meta.getColumnCount() + "��");
			
			for (int i = 1, len = meta.getColumnCount(); i <= len; ++i) {
				System.out.println("-----------------------------------------------");
				System.out.println(i + "��°�� �÷��� �̸���? " + meta.getColumnLabel(i));
				System.out.println(i + "��° �÷��� Ÿ����? " + meta.getColumnTypeName(i));
				System.out.println(i + "��° �÷��� ũ���? " + meta.getPrecision(i));
			}
			
//			Class<?> employee = Class.forName("jdbc.model.Employee");
//			
//			for (Method method : employee.getMethods()) {
//				System.out.println(method);
//			}
			
			while (rs.next()) {
				Employee e = new Employee(rs);
				
				System.out.print(e.getFirst_name());
				System.out.println(" " + e.getLast_name());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
