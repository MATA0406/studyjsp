/**
 * 
 */

// 아이디 체크 스크립트
function idCheck(id){
	if(id == ""){
		alert("아이디를 입력해주세요.");
		document.regForm.id.focus();	
	}else{
		url="member.mdo?cmd=idCheck&id="+id;
		window.open(url,"post","width=300,height=150");
	}	
}

// zipcode 체크
function zipCheck(){
	url="zipCheck.jsp?check=y";
	window.open(url,"post","toolbar=no, width=500, height=300," +
			"directories=no,status=yes,scrollbars=yes,menubar=no");
}

// 정보 미입력 체크
function inputCheck(){
	var theForm = document.regForm;
	
	/*if(!theForm.id.value){
		alert("아이디를 입력해 주세요.");
		theForm.id.focus();
		return;
	}*/
	if(!theForm.pass.value){
		alert("비밀번호를 입력해 주세요.");
		theForm.pass.focus();
		return;
	}
	if(!theForm.repass.value){
		alert("비밀번호를 확인해 주세요.");
		theForm.repass.focus();
		return;
	}
	if(theForm.pass.value != theForm.repass.value){
		alert("비밀번호가 일치하지 않습니다.");
		theForm.repass.focus();
		return;
	}
	if(!theForm.name.value){
		alert("이름을 입력해 주세요.");
		theForm.name.focus();
		return;
	}
	if(!theForm.phone1.value){
		alert("통신사를 입력해 주세요.");
		theForm.phone1.focus();
		return;
	}
	if(!theForm.phone2.value){
		alert("전화번호 앞자리를 입력해 주세요.");
		theForm.phone2.focus();
		return;
	}
	if(!theForm.phone3.value){
		alert("전화번호 뒷자리를 입력해 주세요.");
		theForm.phone3.focus();
		return;
	}
	if(!theForm.email.value){
		alert("이메일을 입력해 주세요.");
		theForm.email.focus();
		return;
	}
	
	var str=theForm.email.value;
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(str.match(regExp) != null);
	else{
		alert('E-mail주소 형식이 잘못되었습니다. 다시 입력해 주세요!');
		theForm.email.focus();
		return;
	}
	
	if(!theForm.zipcode.value){
		alert("우편번호를 입력해 주세요.");
		theForm.zipcode.focus();
		return;
	}
	if(!theForm.address1.value){
		alert("주소를 입력해 주세요.");
		theForm.address1.focus();
		return;
	}
	if(!theForm.address2.value){
		alert("세부 주소를 입력해 주세요.");
		theForm.address2.focus();
		return;
	}
	
	theForm.submit();
}
