package mvcmem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

	// zipcode 불러오는 메소드
	public Vector<ZipCodeVO> zipcodeRead(String dong){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from zipcode where dong like '"+dong+"%'");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipCodeVO tempZipCode = new ZipCodeVO();
				tempZipCode.setZipcode(rs.getString("zipcode"));
				tempZipCode.setSido(rs.getString(3));
				tempZipCode.setGugun(rs.getString("gugun"));
				tempZipCode.setDong(rs.getString("Dong"));
				tempZipCode.setRi(rs.getString("ri"));
				tempZipCode.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZipCode);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: zipcodeRead메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		return vecList;
	}

	// 회원가입 처리를 해줄 메소드
	public boolean memberInsert(StudentVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
			System.out.println("1111111");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			System.out.println("22222222222222");
			if(pstmt.executeUpdate() > 0) result = true;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: meberInser메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		System.out.println(result);
		return result;
	}

	// 로그인 체크
	public int loginCheck(String id, String pass) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					result = 1;
				}else {
					result = 0;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: loginCheck메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		System.out.println(result);
		return result;
	}

	// 정보 수정
	public boolean updateMember(StudentVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("4444444");
		try {
			conn = getConnection();
			System.out.println("2222222");
			pstmt = conn.prepareStatement("update student set pass=?,phone1=?,phone2=?,phone3=?,email=?,zipcode=?,address1=?,address2=? where id = ?");
			System.out.println("11111111111111");
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			System.out.println("2233333333");
			if(pstmt.executeUpdate() > 0) result = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: updateMember 메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		System.out.println(result);
		return result;
	}

	// 정보 불러오기
	public StudentVO getMember(String id) {
		StudentVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(id);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: meberInser메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		System.out.println(vo);
		return vo;
	}

	// 회원탈퇴
	public int deleteMember(String id, String pass) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(id);
		System.out.println(pass);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pass from student where id = ?");
			System.out.println("111111111222222333");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					pstmt = conn.prepareStatement("delete from student where id = ?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1;
				}else {
					result = 0;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: meberInser메소드 오류");
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle1) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle2) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle3) {}
		}
		System.out.println(result);
		return result;
	}
}
