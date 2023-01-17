package com.jweb.sbb.utility;

import java.sql.Connection;
import java.sql.DriverManager;

//DB연결의 클래스화
public class DBOpen {
	//오라클 DB 연결 메소드
	public Connection getConnection() {
		Connection con = null;
		
		try {
			
			String url 		= ""; //gradle로 추가
			String user 	= "admin";
			String password = "Pp199209019209";
			String driver 	="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			System.out.print("자율운영DB 연결 실패 "+e);
		} //try end
		
		return con;
	} //getConnection end
	
}//class end
