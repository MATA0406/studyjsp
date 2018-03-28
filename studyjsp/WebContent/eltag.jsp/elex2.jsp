<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="actiontag.Customer, java.util.ArrayList" %>
<%
	ArrayList<String> singer = new ArrayList<String>();
	singer.add("소녀시대");
	singer.add("원더걸수");
	request.setAttribute("singer", singer );
	
	Customer[] customer = new Customer[2];
	customer[0] = new Customer();
	customer[0].setName("정진호");
	customer[0].setEmail("jinho_46@naver.com");
	customer[0].setPhone("01057220406");
	
	customer[1] = new Customer();
	customer[1].setName("옴팡");
	customer[1].setEmail("옴팡@naver.com");
	customer[1].setPhone("01011111111");
	
	request.setAttribute("customer", customer);
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<li>${singer[0]},${singer[1] }</li>
	</ul>
	<ul>
		<li>이름: ${customer[0].name }</li>
		<li>메일: ${customer[0].email }</li>
		<li>번호: ${customer[0].phone }</li>
	</ul>
	<ul>
		<li>이름: ${customer[1].name }</li>
		<li>메일: ${customer[1].email }</li>
		<li>번호: ${customer[1].phone }</li>
	</ul>

</body>
</html>