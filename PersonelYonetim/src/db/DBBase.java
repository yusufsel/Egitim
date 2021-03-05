package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.Util;

public class DBBase {
	private static ThreadLocal<Connection> conn = new ThreadLocal<Connection>();

	protected Connection getConnection() throws SQLException {
		if (conn.get() == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			}
			conn.set(DriverManager.getConnection(Util.getDBProp("url"), Util.getDBProp("username"), Util.getDBProp("password")));
			conn.get().setAutoCommit(false);
		}
		return conn.get();
	}

	public static void closeConnection() {
		try {
			commit();
			conn.get().close();
			conn.remove();
		} catch (Exception e) {
		}
	}

	public static void commit() {
		try {
			conn.get().commit();
		} catch (Exception e) {
		}
	}

	public static void rollback() {
		try {
			conn.get().rollback();
		} catch (Exception e) {
		}
	}

	protected void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
		}
	}

	protected void close(ResultSet rs, Statement stmt) {
		try {
			rs.close();
		} catch (Exception e) {
		} finally {
			close(stmt);
		}
	}

}
