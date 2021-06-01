package jdbc;

import java.sql.Connection;

public class JdbcConnection implements AutoCloseable  {
	private Connection conn;
	private boolean using;

	public JdbcConnection() {
		conn = DBConnector.getConnection();
	}

	public boolean using() {
		return using;
	}

	public Connection use() {
		using = true;
		return conn;
	}

	@Override
	public void close() throws Exception {
		using = false;
	}
}
