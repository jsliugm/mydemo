//package com.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
//
//public class ProxoolTest {
//	@BeforeClass
//	public static void init() throws Exception {
//		// Java应用中先要加载配置文件，否则谁知道你配置给谁用的
//		JAXPConfigurator.configure("src/proxool.xml", false);
//		// 1：注册驱动类，这次这个驱动已经不是Oracle的驱动了，是Proxool专用的驱动
//		Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
//	}
//
//	public Connection getConnection() throws Exception {
//		// 2：创建数据库连接，这个参数是一个字符串，是数据源的别名，在配置文件中配置的timalias，参数格式为：proxool.数据源的别名
//		Connection conn = DriverManager.getConnection("proxool.timalias");
//		return conn;
//	}
//
//	@Test
//	public void test1() throws Exception {
//		for (int i = 0; i < 100; i++) {
//			Connection conn = getConnection();
//			execute(conn);
//		}
//	}
//
//	public static void execute(Connection conn) {
//		String testSql = "select 1 from dual where 1=";
//		int count = 0;
//		try {
//			for (int i = 0; i < 20; i++) {
//				PreparedStatement ps = conn.prepareStatement(testSql + i);
//				ps.executeQuery();
//				count++;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println(count);
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	// @Test
//	public void test() throws Exception {
//		// Java应用中先要加载配置文件，否则谁知道你配置给谁用的
//		JAXPConfigurator.configure("src/proxool.xml", false);
//		String testsql = "select 1 from dual";
//		// 1：注册驱动类，这次这个驱动已经不是Oracle的驱动了，是Proxool专用的驱动
//		Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
//		// 2：创建数据库连接，这个参数是一个字符串，是数据源的别名，在配置文件中配置的timalias，参数格式为：proxool.数据源的别名
//		Connection conn = DriverManager.getConnection("proxool.timalias");
//		// 3：创建执行SQL的对象
//		Statement stmt = conn.createStatement();
//		// 4：执行SQL，并获取返回结果
//		ResultSet rs = stmt.executeQuery(testsql);
//		// 5：处理返回结果，此处打印查询结果
//		while (rs.next()) {
//			System.err.println(rs.getInt(1));
//		}
//		// 6：关闭数据库连接
//		conn.close();
//	}
//
//}
