package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCClose {
	public static void close(Connection conn, Statement pstmt) {

		//5단계 : 접속 해제
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
	}
}
