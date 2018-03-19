<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8");%>
<%
	String name = request.getParameter("name");
	if(name.equals("정진호")){
%>

<%
  		String rs = "관리자님 어서오세요.";
		out.println(rs);
	}else{
		String rs = "회원님 어서오세요.";
		out.println(rs);
	}
%>