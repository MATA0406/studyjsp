package mvcmem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudentDAO {
	private static StudentDAO instance = null;
	
	// DAO 객체 생성
	public static StudentDAO getInstance() {
		if(instance == null) {
			synchronized(StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		
		return instance;
	}
	
	// Connection 생성
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		}catch(NamingException e) {
			e.printStackTrace();
			System.out.println("NamingException: Connection 생성 실패");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: Connection 생성 실패");
		}
		
		return conn;
	}
	
	// ID체크 메소드 - 사용자가 입력한 id와 DB에 저장되어 있는 id를 비교하여 없다면 false를 리턴 있다면 true를 리턴
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next())
				result = false;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: ID체크 메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		
		return result;
	}
	
}
