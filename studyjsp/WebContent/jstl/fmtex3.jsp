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

number : <fmt:formatNumber value="12345.678" type="number"/><br>
currency: <fmt:formatNumber value="12345.678" type="currency" currencySymbol="￦"/><br>
percent: <fmt:formatNumber value="12345.678" type="percent"/><br>
pattern=".0": <fmt:formatNumber value="12345.678" pattern=".0"/><br>
<c:set var="now" value="<%=new java.util.Date() %>"/>
<c:out value="${now }"/><br>
date: <fmt:formatDate value="${now }" type="date"/><br>
time: <fmt:formatDate value="${now }" type="time"/><br>
both: <fmt:formatDate value="${now }" type="both"/>

</body>
</html>