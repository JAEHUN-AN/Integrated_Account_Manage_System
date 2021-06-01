package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		Connection conn = null;
		try {
			//1�ܰ� ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2�ܰ� : DB ���� �� ���ᰴü ���
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
