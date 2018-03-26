/**
 * 
 */

var wStatus = true;

$(document).ready(function(){
	
	// 글쓰기 폼의 [등록] 버튼을 클릭하면 자동 실행
	$("#regist").click(function(){
		formCheckIt(); // 글쓰기 폼의 입력 여부 체크
		if(wStatus){ // 입력란에 값을 모두 입력한 경우
			// [등록] 버튼의 값으로 지정된 현재 페이지 번호를 얻어냄
			var pageNum = $("#regist").val();
			// 글쓰기 폼에 입력된 값을 얻어내서 qruey에 저장
			var query = {
					subject : $("#subject").val(),
					content : $("#content").val(),
					passwd : $("#passwd").val(),
					ref : $("#ref").val(),
					re_step : $("#re_step").val(),
					re_level : $("#re_level").val(),
					num : $("#num").val()					
			};
			
			// query 값을 갖고 writePro.jsp 실행
			$.ajax({
				type : "post",
				url : "writePro.jsp",
				data : query,
				success : function(data){
					if(data == 1){
						alert("글이 등록되었습니다.");
						var query = "list.jsp?pageNum="+pageNum;
						$("#main_board").load(query);
					}
				}
			});
		}
	});
	
	// 글쓰기 폼의 [취소] 버튼을 클릭하면 자동 실행
	// 글목록 보기 list.jsp 페이지를 표시
	$("#cancle").click(function(){
		var pageNum = $("#cancle").val();
		var query = "list.jsp?pageNum="+pageNum;
		$("#main_board").load(query);
	});
});

//글쓰기 폼의 [취소] 버튼을 클릭하면 자동실행
$("#cancle").click(function () {
    var pageNum = $("#cancle").val();
    var query = "list.jsp?pageNum="+pageNum;
    $("#main_board").load(query);
});

//게시판에서 쓰기 버튼을 누르면 발동!
$("#insert").click(function () {
    $("#main_board").load("writeForm.jsp");

});


// 글쓰기 폼의 입력값 유무 확인

function formCheckIt() {
wStatus = true;
if (!$.trim($("#subject").val())) {
    alert("제목을 입력하세요.");
    $("#subject").focus();
    wStatus = false;
    return false;
}

if (!$.trim($("#content").val())) {
    alert("내용을 입력 하세요.");
    $("#content").focus();
    wStatus = false;
    return false;
}

if (!$.trim($("#passwd").val())) {
    alert("패스워드를 입력하세요.");
    $("#passwd").focus();
    wStatus = false;
    return false;
}

}