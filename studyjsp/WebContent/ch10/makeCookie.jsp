<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("id", "wlsgh46");
	cookie.setMaxAge(60);
	response.addCookie(cookie);
	
	out.println("쿠키가 생성되었습니다.");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form method="post" action="useCookie.jsp">
	<table>
		<tr>
			<td><input type="submit" value="생성된 쿠키 확인">
		</tr>
	</table>
</form>
