package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MassageProcess implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 원래 여기 VO, DAO를 초기화 해서 필요한 경우 데이터베이스 연동을 수행하고 그 결과를 셋팅
		
		request.setAttribute("message", "요청 파라미터로 명령어를 전달");
		return "/mvc/process.jsp";
	}

}
