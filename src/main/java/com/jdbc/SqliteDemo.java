package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteDemo {
	static final String url = "jdbc:sqlite:test.db";
	static final String driver ="org.sqlite.JDBC";
	public static Connection getConn(){
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void createTable(String sql){
		
	}
	public static void main(String[] args) {
		Connection conn = getConn();
		String sql = "create table person(name varchar2(100),age int)";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
