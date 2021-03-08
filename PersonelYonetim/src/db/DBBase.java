package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.Sabitler;
import util.Util;

public class DBBase {
	private static ThreadLocal<Connection> conn = new ThreadLocal<Connection>();

	protected Connection getConnection() throws SQLException {
		if (conn.get() == null) {
			conn.set(DriverManager.getConnection(Util.getDBProp(Sabitler.DB_URL), Util.getDBProp(Sabitler.DB_USERNAME), Util.getDBProp(Sabitler.DB_PASSWORD)));
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
