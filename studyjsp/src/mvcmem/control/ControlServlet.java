package mvcmem.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcmem.action.Action;


/*@WebServlet("/ControlServlet")*/
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 명령어를 받아서 액션 팩토리로 보낸 뒤 처리후 다시 돌아와 처리
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cmd = request.getParameter("cmd");
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(cmd);
			System.out.println(cmd);
			ActionForward af = action.execute(request, response);
			if(af.isRedirect()) {
				response.sendRedirect(af.getUrl()); //리다이렉트
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response); // 포워딩
			}
		}else {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>올바른 요청이 아닙니다</h4>");
			out.println("<h4>http://localhost:8080/myWeb/mvcmem/member.mdo?cmd=요청키워드</h4>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
