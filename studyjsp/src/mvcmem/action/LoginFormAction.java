package mvcmem.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcmem.control.ActionForward;

import mvcmem.model.StudentDAO;

public class LoginFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ActionForward("/mvcmem/login.jsp", false);
	}

}
