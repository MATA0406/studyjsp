<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

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