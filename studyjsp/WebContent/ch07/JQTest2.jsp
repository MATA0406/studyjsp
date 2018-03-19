<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery와 메소드를 사용한 엘리먼트의 내용변경</title>
<script src="../js/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#b1").click(function(){ // <button id="b1>" 엘리먼트를 클릭하면 자동실행
				$("#b2").text($("p").text());// 두 번째 버튼의 레이블 변경 
			});
			
			$("#b2").click(function(){ // 엘리먼트를 클릭하면 자동실행
				$("#display").html("<img src='myFace.png' border='1'/>"); // 여기서 border는 테두리 선의 두께
			});
		});
	</script>
</head>
<body>
	<p>이미지표시</p>
	<button id="b1">버튼레이블 변경</button>
	<div id="display"></div>
	<button id="b2">버튼2</button>

</body>
</html>