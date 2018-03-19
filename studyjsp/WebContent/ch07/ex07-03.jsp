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
		$("#btn1").click(function(){
			var na = $("#name").val();
			/* var query = {name : "정진호"} */
			var query = { name : na};
			$.ajax({
				type: "POST",
				url: "ex07-03Pro.jsp",
				data: query,
				success: function(data){
					$("#result").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<p>이름<input type="text" id="name"></p>
	<button id="btn1">처리</button>
	<div id="result"></div>

</body>
</html>