<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr><td><b>표현식</b></td><td><b>값</b></td></tr>
		<tr><td><b>\${2+5 }</b></td><td><b>${2+5 }</b></td></tr>
		<tr><td><b>\${4/5 }</b></td><td><b>${4/5 }</b></td></tr>
		<tr><td><b>\${5 div 6 }</b></td><td><b>${5 div 6 }</b></td></tr>
		<tr><td><b>\${5 mod 7 }</b></td><td><b>${5 mod 7 }</b></td></tr>
		<tr><td><b>\${2<3 }</b></td><td><b>${2<3 }</b></td></tr>
		<tr><td><b>\${2 gt 3 }</b></td><td><b>${2 gt 3 }</b></td></tr>
		<tr><td><b>\${3.1 le 3.2 }</b></td><td><b>${3.1 le 3.2 }</b></td></tr>
		<tr><td><b>\${(5>3)?5:3 }</b></td><td><b>/${(5>3)?5:3 }</b></td></tr>
		<tr><td><b>\${header["host"] }</b></td><td><b>${header["host"] }</b></td></tr>
		<tr>
			<td>/${header["user-agent"] }</td>
			<td>${header["user-agent"] }</td>
		</tr>
	</table>

</body>
</html>