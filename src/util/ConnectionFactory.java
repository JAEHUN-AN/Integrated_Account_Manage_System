package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		Connection conn = null;
		try {
			//1단계 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2단계 : DB 접속 및 연결객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.111:1521:oracle19";
			String user = "TESTORACLE";
			String pw = "oracle19";
			
			conn = DriverManager.getConnection(url,user,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
