package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	// 파일에 있는 내용을 읽어서 연결을 생성해보세요
	static String driverName;
	static String url;
	static String id;
	static String password;
	
	static {
		try (
				FileReader fin = new FileReader("./dbinfo.txt");
				BufferedReader bin = new BufferedReader(fin);
		) {
			url = bin.readLine();
			id = bin.readLine();
			password = bin.readLine();
			System.out.println("[INFO] Initilize static variables");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			return null;
		}
	}

}