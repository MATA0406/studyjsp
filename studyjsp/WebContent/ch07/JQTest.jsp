<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery 테스트 페이지</title>
<style type="text/css">
	div#displayArea{
		width: 200px;
		height: 200px;
		border: 5px solid #6699FF;
	}
</style>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("button").click(function(){
			$("#displayArea").html("<img src='ansi_main2s.png' border='0'/>");
		})
	})
</script>
</head>
<body>
	<div id="displayArea">이곳의 내용이 변경</div>
	<button>표시</button>

</body>
</html>