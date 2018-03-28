<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="now" value="<%= new java.util.Date() %>"/>
KOREA KST: <fmt:timeZone value="GMT">
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>
<br></br>
<%
	// 사용가능한 timeZone 목록 구하기
	String[] ids = java.util.TimeZone.getAvailableIDs();
	for(int i=0; i < ids.length; i++){
		out.println(ids[i] + "<br>");
	}
%>

</body>
</html>