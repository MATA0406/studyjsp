<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-3.3.1.min.js"></script>

<%
	String id = "";
	try{
		id = (String)session.getAttribute("id");
%>

<%if(id == null || id.equals("")){%>
<div id="display_board" class="box2">로그인하세요! 게시판은 회원만 볼 수 있습니다.</div>
<%}else{%>
<div id="display_board" class="box2"><jsp:include page="list.jsp"/></div>
<%}}catch(Exception e){e.printStackTrace();}%>