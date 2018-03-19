<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery 이벤트처리</title>
<script src="../js/jquery-3.3.1.min.js"></script>
	<script>
		$("document").ready(function(){
			$("p").mouseenter(function(){ // 엘리먼트에 마우스 포인터를 위치시키면 자동 실행
				$(this).text("왔구려, 마우스포인터!!");
			});
			
			$("p").mouseleave(function(){ // 엘리먼트에서 마우스 포인터가 나가면 자동 실행
				$(this).text("돌아오시오 마우스포인터!!");
			});
			
			$("button").dblclick(function(){ // 엘리먼트를 더블클릭하면 자동 실행
				$(this).css("background-color", "#cccccc");
			});
		});
	</script>
</head>
<body>
	<p>마우스 포인터를 내놓으시오!!</p>
	<button>더블클릭 하시구려.</button>

</body>
</html>