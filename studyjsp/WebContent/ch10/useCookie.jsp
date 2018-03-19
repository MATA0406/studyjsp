<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i = 0; i<cookies.length; i++){
			if(cookies[i].getName().equals("id")){
				out.println("쿠키 이름: " + cookies[i].getName());
				out.println(" , 쿠키 값: " + cookies[i].getValue());
			}
		}
	}
%>