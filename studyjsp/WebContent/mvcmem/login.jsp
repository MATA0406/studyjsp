<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginID" value="${sessionScope.loginID }"/>
 
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<title>Insert title here</title>
<link href="style.css" type="test/css" rel="stylesheet"/>
<script>

</script>
</head>
<body>

<c:choose>
	<c:when test="${loginID ne null }">
		<table width="300" border="1">
			<tr><td colspan="3" align="center">
				<c:out value="${loginID }"/>님 환영합니다.</td>
			</tr>
			<tr>
			<td align="center" width="100">
			<a href="member.mdo?cmd=modifyForm">정보수정</a></td>
			<td align="center" width="100">
			<a href="member.mdo?cmd=deleteForm">회원탈퇴</a></td>
			<td align="center" width="100">
			<a href="member.mdo?cmd=logout">로그아웃</a></td>
		</table>
	</c:when>
	<c:otherwise>
		<c:if test="${requestScope.check eq 0 }">
			<script type='text/javascript'>alert('비밀번호가 틀렸습니다.');</script>
		</c:if>
		<c:if test="${requestScope.check eq -1 }">
			<script type='text/javascript'>alert('아이디가 존재하지 않습니다.');</script>
		</c:if>
		
		 <form method="post" action="member.mdo?cmd=loginProc">
			<table width="300" border="1">
				<tr><td colspan="2" align="center">회원 로그인</td></tr>
				<tr>
					<td align="right" width="100">아이디: </td>
					<td width="100">&nbsp;&nbsp;<input type="text" name="id" size="20"/></td>
				</tr>
				<tr>
					<td align="right" width="100">비밀번호: </td>
					<td width="100">&nbsp;&nbsp;<input type="password" name="pass" size="20"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="로그인"/>&nbsp;&nbsp;
					<input type="button" value="회원가입" onclick="javascript:window.location='?cmd=regForm'"/></td>
				</tr>
			</table>
		</form> 
		
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
	</c:otherwise>
</c:choose>


</body>
</html>