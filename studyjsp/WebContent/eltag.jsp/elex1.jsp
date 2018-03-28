<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="actiontag.Customer, java.util.HashMap" %>
<%
	Customer customer = new Customer();
	customer.setName("정진호");
	customer.setEmail("jinho_46@naver.com");
	customer.setPhone("010-5722-0406");
	request.setAttribute("customer", customer );
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("name", "소나타");
	map.put("maker", "현대자동차");
	request.setAttribute("car", map);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>이름: ${customer.name }</li>
		<li>메일: ${customer.email }</li>
		<li>전화: ${customer.phone }</li>
	</ul>
	<br></br>
	<ul>
		<li>자동차: ${car.name }</li>
		<li>자동차: ${car.maker }</li>
	</ul>

</body>
</html>