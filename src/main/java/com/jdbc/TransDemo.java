package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransDemo {
	public static void main(String[] args) {
		Connection conn=null;
		//conn.
		try {
			//conn = JdbcDemo.getConnection();
			conn.setAutoCommit(false);
			String sql = "update tbl_common t set t.num1=1000109 where t.id=103";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
