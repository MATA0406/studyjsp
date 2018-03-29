package mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcmem.control.ActionForward;
import mvcmem.model.StudentDAO;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentDAO dao = StudentDAO.getInstance();
		String id = request.getParameter("id");
		boolean check = dao.idCheck(id);
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		return new ActionForward("/mvcmem/idCheck.jsp", false);
	}

}
