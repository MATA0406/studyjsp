<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="ch11.logon.LogonDataBean" %>
<%@ page import ="ch11.logon.LogonDBBean" %>

<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="modify.js"></script>

<% request.setCharacterEncoding("utf-8"); %>

<%
   String id = (String)session.getAttribute("id");
   String passwd = request.getParameter("passwd");
   
   LogonDBBean manager = LogonDBBean.getInstance();
   //아이디와 비밀번호에 해당하는 사용자의 정보를 얻어냄
   LogonDataBean m = manager.getMember(id, passwd);
   
   try{ //얻어낸 사용자 정보를 화면에 표시
%>

<div id="regForm" class="box">
   <ul>
      <li><p class="center">회원 정보 수정
      <li><label for="id">아이디</label>
         <input type="email" id="id" name="id" size="20" maxlength="50" value="<%=id %>" readonly disabled>
      <li><label for="passwd">비밀번호</label>
         <input type="password" id="passwd" name="passwd" size="20" maxlength="16" placeholder="6~16자 숫자/문자">
      <li><label for="name">이름</label>
         <input type="text" id="name" name="name" size="20" maxlength="10" value="<%=m.getName() %>">
      <li><label for="address">주소</label>
         <input type="text" id="address" name="address" size="30" maxlength="50" value="<%=m.getAddress() %>">
      <li><label for="tel">전화번호</label>
         <input type="tel" id="tel" name="tel" size="30" maxlength="20" value="<%=m.getTel() %>">
      <li class="label2"><button id="modifyProcess">수정</button>
         <button id="cancle">취소</button>
   </ul>
</div>
<% } catch(Exception e){} %>