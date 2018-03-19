<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#result{
		width: 200px;
		height: 200px;
		border: 5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
			$("#bt1").click(function(){
				var pass = $("#pass");
				var id = $("#id");
				var rs = "아이디:" + $("#id").val();
				rs += "비밀번호:" + $("#pass").val();
				$("#result").html(rs);
		});
	});
</script>

</head>
<body>
	<p>아이디: <input type="text" id="id"></p>
	<p>비밀번호: <input type="password" id="pass"></p>
	<button id="bt1">확인</button><br>
	<div id="result"></div>
</body>
</html>