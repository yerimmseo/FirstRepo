package jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class A01_ConnectionPractice {
	
	/*
		����ڷκ��� �μ���ȣ�� �Է¹�����
		�ش� �μ��� ������� ��� ������ ��ȸ�Ͽ� �ֿܼ� ���� ���� ����غ�����
	*/
	
	// static ��� - �ش� Ŭ������ �� ���̶� ��޵Ǹ� static ����� ���ʷ� �� �� �����Ѵ�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� �Ϸ�.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	
	static Connection getConnection(String id, String password) {
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		String sql = "SELECT * FROM employees WHERE department_id=" + 50;
		
		try (
			Connection conn = getConnection("hr", "1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			System.out.println("EMPNO\t  FRIST_NAME\tLAST_NAME");
			while (rs.next()) {
				System.out.printf("%-10d%-13s\t%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("��ȸ�� �μ���ȣ �Է� >> ");
//		int departNum = sc.nextInt();
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
//			
//			PreparedStatement pstmt = conn.prepareStatement(
//					"SELECT * FROM employees WHERE department_id = " + departNum);
//			ResultSet rs = pstmt.executeQuery();
//			
//			System.out.println("emp_id\tfirst_name\tlast_name\temail\tphone_num\thire_date\tjob_id\tsalary\tdepartment_id");
//			while (rs.next()) {
//				System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s", rs.getString("employee_id"), 
//						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
//						rs.getString("phone_number"), rs.getString("hire_date"), rs.getString("job_id"),
//						rs.getString("salary"), rs.getString("department_id"));
//				System.out.println();
//			}
//			
//			rs.close();
//			pstmt.close();
//			conn.close();
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
