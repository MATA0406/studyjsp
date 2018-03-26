package ch12.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {
	 private static BoardDBBean instance = new BoardDBBean();
	 
	 // .jsp ���������� DB�������� BoardDBBean Ŭ������ �޼ҵ忡 ���� �� �ʿ�
	 public static BoardDBBean getInstance() {
		 return instance;
	 }
	 
	 private BoardDBBean() { }
	 
	 // Ŀ�ؼ� Ǯ�κ��� Connection ��ü�� �� : DB �������� �������� �����ϴ� �޼ҵ忡�� ���
	 private Connection getConnection() throws Exception{
		 Context initCtx = new InitialContext();
		 Context envCtx = (Context)initCtx.lookup("java:comp/env");
		 DataSource ds = (DataSource)envCtx.lookup("jdbc/myOracle");
		 return ds.getConnection();
	 }
	 
	 // board ���̺� ���� �߰�(insert��) <- writePro.jsp���� ���
	 public int insertArticle(BoardDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;
		int number = 0;
		String sql = "";

		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				number = rs.getInt(1) + 1; // ���� �� ��ȣ�� ���� ū �۹�ȣ +1
			} else { // ù��° ���̶�� �ǹ�
				number = 1;
				article.setNum(1);
			}

			System.out.println(number);
			if (num != 0) { // ��� - ���� �� ��ȣ�� ����
				sql = "update board set re_step=re_step+1 where ref=? and re_step >?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else { // ����
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
		
			// �� �߰� �ϱ�
			sql = "insert into board(num, writer, subject, content, passwd, reg_date, ip, ref, re_step, re_level) values(board_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getReg_date());
			pstmt.setString(6, article.getIp());
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_step);
			pstmt.setInt(9, re_level);
			pstmt.executeUpdate();
			System.out.println("11111111111111");
			x = 1; // ���ڵ� �߰� ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqe) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqe) {
				}
			}
		}
		return x;
	}

	// board Table�� ����� ��ü���� ���� �� <---- list.jsp���� ���
	public int getArticleCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqe) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException sqe) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException sqe) {
			}
		}

		return x;
	}

	// ���� ����� ������ <--- list.jsp
	public List<BoardDataBean> getArticle(int start, int end) {
		List<BoardDataBean> articleList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from(select rownum rnum,writer,subject,passwd,reg_date,readcount,ref,re_level,content,ip from(select * from board order by ref desc, re_step asc)) where rnum>=? and rnum<=?");/*select * from board where rownum>=? and rownum<=? order by ref desc, re_step asc*/
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("db ");
				articleList = new ArrayList<BoardDataBean>(end);
				do {
					BoardDataBean article = new BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				} while (rs.next());

			}
		} catch (Exception e) {

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqe) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqe) {
				}
			}
		}
	

		return articleList;
	}

}
