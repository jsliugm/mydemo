package com.ibatis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisDemo {
	static SqlMapClient sqlMapClient = null;
	static {
		Reader reader = null;
		try {
			reader = Resources
					.getResourceAsReader("com/ibatis/SqlMapConfig.xml");
			//BufferedReader br  = new BufferedReader(reader);
			//System.out.println(br.readLine());
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			// TODO: handle exception
		} 

	}

	public static void main(String[] args) throws SQLException {
		//List<Person> list = sqlMapClient.queryForList("selectAllPerson");
		//System.out.println(list.get(0).getName());
	}
}
