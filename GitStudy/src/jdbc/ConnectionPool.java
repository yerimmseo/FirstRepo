package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	/*
		DB�� DML�� ������ ������ ���ο� ������ �����ϴ� ���� ���ҽ��� ���� ����ȴ�
		
		������ �̸� ������ �����صΰ�, ��������� ���� Ŀ�ؼ��� �����ִ� ����� Ŀ�ؼ� Ǯ�̶�� �Ѵ�
	*/
	List<JdbcConnection> pool;
	
	public ConnectionPool(int size) {
		pool = new ArrayList<>(size);
		
		for (int i = 0; i < size; ++i) {
			pool.add(new JdbcConnection());
		}
	}
	
	public JdbcConnection getConnection() {
		for (JdbcConnection jconn : pool) {
			if (!jconn.using()) {
				return jconn;
			}
		}
		return null;
	}
	
}
