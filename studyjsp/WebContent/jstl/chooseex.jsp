<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int score = 90;
	request.setAttribute("score", score);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${score ge 90 }">
		당신의 성적은 A입니다.
	</c:when>
	<c:when test="${score ge 80 }">
		당신의 성적은 B입니다.
	</c:when>
	<c:otherwise>
		당신의 성적은 C입니다.
	</c:otherwise>
</c:choose>

</body>
</html>