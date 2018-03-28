<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList, jstl.MemberVo" %>
<%
	MemberVo vo1 = new MemberVo("손", "jin@sdf.com", 500);
	MemberVo vo2 = new MemberVo("오", "오@com", 70);
	MemberVo vo3 = new MemberVo("공", "공@com", 0);
	
	ArrayList<MemberVo> memberList = new ArrayList<MemberVo>();
	memberList.add(vo1);
	memberList.add(vo2);
	memberList.add(vo3);
	request.setAttribute("memberList", memberList);
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="450">
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="200">메일</th>
		<th width="100">나이</th>
	</tr>
	<c:forEach var="member" items="${memberList }" varStatus="num">
	<tr>
		<td align="center">${num.count }</td>
		<td align="center">${member.name }</td>
		<td align="center">${member.email }</td>
		<td align="center">${member.age }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>