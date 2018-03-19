<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = "wlsgh46@naver.com";
	String pass = "1234";
	
	session.setAttribute("id", id);
	session.setAttribute("pass", pass);
	
	out.println("세션에 id와 passwd 속성을 설정했습니다.<br>");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form method="post" action="viewSession.jsp">
	<table>
		<tr>
			<td><input type="submit" value="세션 속성 확인">
		</tr>
	</table>

</form>