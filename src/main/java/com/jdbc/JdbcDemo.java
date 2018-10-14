package com.jdbc;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class JdbcDemo {

    private Connection connection;

    @Before
    public void initConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@docker4dev:1521:xe", "system", "oracle");
    }

    @Test
    public void testInsert() throws SQLException, UnsupportedEncodingException {
        PreparedStatement ps = connection.prepareStatement("insert into tt(name)values(?)");
        ps.setString(1, genTestString(4000));
        ps.executeUpdate();
    }

    public String genTestString(int count)  {
        boolean stopFlag = true;
        StringBuffer result = new StringBuffer();
        int length=0;
        while (stopFlag) {
            result.append("a");
            try {
                length = result.toString().getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (length >= count) {
                stopFlag = false;
            }
        }
        if(length>count){
            return result.substring(0,result.length()-1);
        }
        return result.toString();
    }

    public void iMain() throws Exception {
        //Connection conn = getConnection();
        // String sql = "select * from person";
        // PreparedStatement pstmt = conn.prepareStatement(sql);
        // ResultSet rs = pstmt.executeQuery();
        /*
		 * while(rs.next()) { //Long id = rs.getLong(1);
		 * System.out.println(rs.getString("name")); }
		 */
        InputStream is = getInputStream("C:\\Documents and Settings\\Administrator\\桌面\\abc.xls");
        byte[] bts = new byte[1024];
        connection.setAutoCommit(false);
        String sql = "insert into person(id,xls) values(seq_person.nextval,empty_blob()) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
        String sql1 = "select xls from person for update";
        ResultSet rs = pstmt.executeQuery(sql1);
        Blob blob = null;
        while (rs.next()) {
            blob = rs.getBlob(1);
        }
        OutputStream out = blob.setBinaryStream(0);
        while (is.read(bts) > 0) {
            out.write(bts);
        }
        connection.commit();
        is.close();
        // out.close();
        rs.close();
        pstmt.close();
        connection.close();
    }

    public void rMain() throws Exception {

        String sql1 = "select xls from person ";
        PreparedStatement pstmt = connection.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            InputStream is = rs.getBinaryStream(1);
            FileOutputStream fos = new FileOutputStream("c:\\test" + Math.random() + ".xls");
            byte[] b = new byte[1024];
            while (is.read(b) > 0) {
                fos.write(b);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //rMain();

    }

    public static InputStream getInputStream(String path) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fis;
    }

}
