<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</head>
<body>
<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<div id="naverIdLogin"></div>
<!-- //네이버아이디로로그인 버튼 노출 영역 -->

<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript">
var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "7KYC_rPZz0PoBsomjyBW",
			callbackUrl: "http://localhost:8080/studyjsp/nLogin/nLogin.jsp",
			isPopup: false,
			loginButton: {color: "green", type: 3, height: 60}
		}
	);

	naverLogin.init();
	
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var email = naverLogin.user.getEmail();
			var name = naverLogin.user.getNickName();
			var profileImage = naverLogin.user.getProfileImage();
			var birthday = naverLogin.user.getBirthday();			var uniqId = naverLogin.user.getId();
			var age = naverLogin.user.getAge();
			
			naverLogin.getLoginStatus();
			
		} else {
			console.log("AccessToken이 올바르지 않습니다.");
		}
		
	});
	
</script>
<!-- // 네이버아이디로로그인 초기화 Script -->
</body>
</html>