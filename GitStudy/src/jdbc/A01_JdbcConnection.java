package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A01_JdbcConnection {
	/*
		# JDBC
		- Java Database Connectivity
		- DB에 쿼리문을 전달하여 실행하고 결과를 받아오는 Java API
		- 어떤 DB와도 호환할 수 있도록 설계되어 있다
		- Java 부분의 소스는 어떤 DB를 사용하더라도 항상 일정하다
		- DB를 제작한 쪽에서 jdbc에서 요구하는 형식을 맞추어 개발하기 때문에
		  프로그래머들은 새로운 DB도 기존의 jdbc로 편리하게 사용할 수 있다
		  
		# OJDBC
		- 오라클 데이터베이스가 JDBC API와 소통하기 위해 만든 라이브러리
		- 오라클 DB가 설치된 폴더에 포함되어 있다
	*/
	public static void main(String[] args) {
		/*
			※ 어떤 회사 DB를 사용하더라도 거쳐야 하는 똑같은 절차들
		*/
		try {
			// 1. Class.forName(driverName)으로 해당 DB사의 jdbc드라이버를 로드한다. (생략가능)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver가 존재함.");
			
//			Class.forName("jdbc.A01_JdbcConnection");
//			System.out.println("방금 만든 클래스도 존재함.");
			
			// 2. DriverManager 클래스를 통해 DB와의 연결을 생성한다
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
			System.out.println("연결 생성됨");
			
			// 3. 생성된 연결을 통해 전송할 쿼리문을 생성한다
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
			
			// 4. 생성된 쿼리문을 DB로 보낸다
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 받아온 결과를 마음대로 사용한다
			while (rs.next()) {
				System.out.println(rs.getString("first_name") + "/" + rs.getString("salary"));
			}
			
			// 6. 다 썼으면 연결을 잘 끊어준다 (가장 나중에 연 순서대로 닫는다)
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}









