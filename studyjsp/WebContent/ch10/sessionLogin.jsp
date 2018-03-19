sessionLogin.jsp


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = "";
	try {
		id = (String) session.getAttribute("id");
		if (id == null || id.equals("")) {
%>

<form method="post" action="sessionLoginPro.jsp">
	<table>
		<tr>
			<td class="label"><label for="id">아이디</label></td>
			<td class="content"><input type="text" id="id" name="id"
				size="20" maxlength="50" placeholder="example@kings.com" autofocus
				required></td>
		</tr>
		<tr>
			<td class="label"><label for="passwd">비밀번호</label></td>
			<td class="content"><input type="password" id="passwd"
				name="passwd" size="20" placeholder="6~16자 숫자/문자" maxlength="16"
				required></td>
		</tr>
		<tr>
			<td class="label2" colspan="2"><input type="submit" value="로그인">
				<input type="reset" value="다시작성"></td>
		</tr>
	</table>
</form>

<%
	} else {
%>

<b><%=id%></b>
님이 로그인 하셨습니다
<form method="post" action="sessionLogout.jsp">
	<input type="submit" value="로그아웃">
</form>

<%
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
