<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Ajax메소드 - $.post()</title>
<style type="text/css">
	#result{
		width: 200px;
		height: 200px;
		border: 5px solid #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#b1").click(function(){ // [결과] 버튼을 클릭하면 자동 실행
			// xhrTest3.txt를 get 방식으로 요청
			$.post("process.jsp",{ // 요청 페이지
				// 요청 페이지에 실어서 보낼 데이터
				name:"kingdora",
				stus:"homebody"
			},
			function(data,status){ // 응답 내용 처리
				if(status = "success") // 요청이 제대로 처리되었으면
				$("#result").html(data);
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