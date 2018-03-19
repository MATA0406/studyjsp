<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Ajax메소드 - $.ajax()</title>
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
		$("#b1").click(function(){ // [결과] 버튼을 클릭하면 자동 실행
			// 요청 페이지에 전송할 데이터
			var query = {
				name : "kingdora", stus : "homebody"
			};
		// porscess.jsp 페이지에 요청 데이터를 보낸 후 결과를 반환받음
		
		$.ajax({
			type : "POST", // 전송 방식
			url : "process.jsp", // 요청 페이지
			data : query, // 전송 데이터
			success : function(data){ // 요청 페이지를 실행한 결과
				$("#result").html(data);
			}
		});
		});
	});
</script>
</head>
<body>
	<button id="b1">결과</button>
	<div id="result"></div>
</body>
</html>