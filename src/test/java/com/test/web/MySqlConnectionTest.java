package com.test.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MySqlConnectionTest {

	/*//driver connection test
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1/mydb";//연결 확인할 db 주소와 스키마명
	private static final String user = "root";//db user
	private static final String pwd = "1234";//db password
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(driver);
		try(Connection con = DriverManager.getConnection(url, user, pwd)) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection()throws Exception{
		try(Connection con = ds.getConnection()) {
			System.out.println(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
