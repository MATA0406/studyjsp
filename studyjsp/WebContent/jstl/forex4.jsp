<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	java.util.HashMap<String, Object> mapData = new java.util.HashMap<String, Object>();
	mapData.put("name", "정진호");
	mapData.put("today", new java.util.Date());
%>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>"/>
<c:set var="map" value="<%= mapData %>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>1부터 100까지 홀수의 합</h4>
<c:set var="sum" value="0"/>
<c:forEach var="1" begin="1" end="10" step="2">
<c:set var="sum" value="${sum+i }"/>
</c:forEach>
결과 = ${sum }

<h4>구구단: 4단</h4>
<ul>
<c:forEach var="i" begin="1" end="9">
	<li> 4 * ${i } = ${4 * i }</li>
</c:forEach>
</ul>

<h4>int형 배열</h4>
<c:forEach var="i" items="${intArray }" begin="2" end="4">
	[${i }]
</c:forEach>

<h4>Map</h4>
<c:forEach var="i" items="${map }">
	${i.key } = ${i.value }<br></br>
</c:forEach>
</body>
</html>