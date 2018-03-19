<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="modify.js"></script>

<div id="status">
	<ul>
		<li><label for="passwd">비밀번호</label>
		<input id="passwd" name="passwd" type="password" size="20" placeholder="6~16자 숫자/문자" maxlength="16">
		<li class="label2">
		<button id="modify">정보수정</button>
		<button id="delete">탈퇴</button>
	</ul>
</div>