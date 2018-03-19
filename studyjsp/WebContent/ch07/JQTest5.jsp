<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery Ajax메소드 -load() 응답처리</title>
<style type="text/css">
	#result{
		width: 200px;
		height: 200px;
		border: 5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){ // [결과] 버튼을 클릭하면 xhrTest3.txt가 <div id="result"> 엘리먼트에 로드
		$("#b1").click(function(){
			$("#result").load("xhrTest3.txt", function(response,stu,xhr){
				if(stu=="success") // 서버 요청이 성공 시
				alert("로드 성공!"); // 메시지 상자 표시
				if(stu=="error") // 서버 요청 실패 시
				alert("에러: " + xhr.status + "+xhr.stu");
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