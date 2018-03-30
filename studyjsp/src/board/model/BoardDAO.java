package board.model;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized(BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		
		return instance;
	}
	
	// 게시판 작업의 기능 하나하나를 메소드로 추가
}
