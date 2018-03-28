<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
	request.setAttribute("name", "정진호");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

요청 URI: ${pageContext.request.requestURI }<br></br>
request의 name 속성: ${requestScope.name }<br></br>
code 파라미터: ${param.code }<br></br>

</body>
</html>