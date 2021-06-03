package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jdbc.model.Department;
import jdbc.model.Employee;
import jdbc.model.Location;

public class A07_Join {

	public static void main(String[] args) {
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		config.setUsername("hr");
		config.setPassword("1234");

		HikariDataSource ds = new HikariDataSource(config);
		
		// 이름에 en이 들어가는 모든 사원의 이름/고용일/부서번호/부서명/도시를 
		// 모델 클래스를 이용해 저장한 후 출력해보세요
		String name = "en";
		String sql = "SELECT first_name, hire_date, department_id, department_name, city FROM employees "
				+ "INNER JOIN departments USING ( department_id ) "
				+ "INNER JOIN locations USING ( location_id ) "
				+ "WHERE first_name LIKE ?";

		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {

			pstmt.setString(1, String.format("%%%s%%", name));
			
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			
			Employee employee = new Employee();
			Department department = new Department();
			Location location = new Location();
			
			System.out.println("FIRST_NAME\tDID\tDNAME\t\tCITY");
			while (rs.next()) {
				employee.setFirst_name(rs.getString(1));
				// java.sql.Date to java.util.Date
				employee.setHire_date(rs.getDate(2));
				employee.setDepartment(department);
				department.setLocation(location);
				employee.getDepartment().setDepartment_id(rs.getInt(3));
				employee.getDepartment().setDepartment_name(rs.getString(4));
				employee.getDepartment().getLocation().setCity(rs.getString(5));
				
				// Date to Instant
				Instant instant = Instant.ofEpochMilli(employee.getHire_date().getTime());
				
				// Instant to localDateTime
				System.out.println(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
				
				System.out.printf("%-10s\t%d\t%-10s\t%s\n", employee.getFirst_name(), employee.getDepartment().getDepartment_id(),
						employee.getDepartment().getDepartment_name(), employee.getDepartment().getLocation().getCity());
				System.out.println("고용일 " + employee.getHire_date());
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
