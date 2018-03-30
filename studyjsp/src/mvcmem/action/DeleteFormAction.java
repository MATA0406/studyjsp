package mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcmem.control.ActionForward;

public class DeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		return new ActionForward("/mvcmem/deleteForm.jsp",false);
	}

}
