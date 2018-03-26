<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="write.js"></script>

<% request.setCharacterEncoding("utf-8"); %>

<%
	// 제목 글의 경우 갖는 값
	int num = 0, ref = 1, re_step = 0, re_level = 0;
	int pageNum = 1;
	
	try{ // 댓글의 경우 갖는 값
		if(request.getParameter("num") != null){ // 댓글 제목 글의 글번호, 그룹화 번호, 그룹화 내의 순서, 들여쓰기 정도가 list.jsp페이지에서 넘어옴
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
%>
	<input type="hidden" id="num" value="<%= num %>">
	<input type="hidden" id="ref" value="<%= ref %>">
	<input type="hidden" id="re_step" value="<%= re_step %>">
	<input type="hidden" id="re_level" value="<%= re_level %>">
	
	<div id="writeForm" class="box">
		<ul>
			<li><label for="subject">제목</label>
				<%if(num != 0){ // 댓글%>
				<img src="../images/re.gif">
				<%} %>
				<input id="subject" name="subject" type="text" size="50" placeholder="제목" maxlength="50">
			<li><label for="content">내용</label>
				<textarea id="content" rows="13" cols="50"></textarea>
			<li><label for="passwd">비밀번호</label>
			<input id="passwd" name="passwd" type="password" size="20" placeholder="6~16자 숫자/문자" maxlength="16"></label>
			<li class="label2">
				<button id="regist" value="<%=pageNum %>">등록</button>
				<button id="cancle" value="<%=pageNum %>">취소</button>
		</ul>
	</div>
<%}catch(Exception e){} %>