<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입폼</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/style.css" type="test/css" rel="stylesheet"/>
<script type="text/javascript" src="script.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>

</nav>

<div class="container">
	<div class="form-group">
		<div class="row" style="margin-left:0px">
			<label for="idd">아이디</label>
			<input id="idd" class="form-control col-2" type="text" name="idd" size="20"/>&nbsp;
			<input class="btn btn-primary col-3" type="button" value="중복확인" onclick="idCheck(this.form.id.value)"/>
		</div>
	</div>
</div>

<form method="post" action="member.mdo?cmd=regProc" name="regForm">
	<table class="table-striped" >
		<tr><td colspan="2" align="center">회원 가입 정보 입력</td>
		</tr>
		<tr>
			<td align="right">아이디: </td>
			<td><input class="form-control" type="text" name="id" size="20"/>&nbsp;
			<input class="btn btn-primary" type="button" value="중복확인" onclick="idCheck(this.form.id.value)"/></td>
		</tr>
		<tr>
			<td align="right">패스워드: </td>
			<td><input type="password" name="pass" />
		</tr>
		<tr>
			<td align="right">패스워드 확인: </td>
			<td><input type="password" name="repass" />
		</tr>
		<tr>
			<td align="right">이름: </td>
			<td><input type="text" name="name" />
		</tr>
		<tr>
			<td align="right">전화번호: </td>
			<td><select name="phone1"/>
			<option value="02">02</option>
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">018</option>
			<option value="019">019</option>
			</select>&nbsp;-&nbsp;
			<input type="text" name="phone2" size="5"/>
			&nbsp;&nbsp;
			<input type="text" name="phone3" size="5"/></td>
		</tr>
		<tr>
			<td align="right">이메일: </td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td align="right">우편번호: </td>
			<td><input type="text" name="zipcode" size="20"/>&nbsp;
			<input type="button" value="찾기" onclick="zipCheck()"/></td>
		</tr>
		<tr>
			<td align="right">주소1: </td>
			<td><input type="text" name="address1" size="50"/></td>
		</tr>
		<tr>
			<td align="right">주소2: </td>
			<td><input type="text" name="address2" size="50"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="회원가입" onclick="inputCheck()"/>&nbsp;&nbsp;
			<input type="reset" value="다시입력"/></td>
		</tr>
	</table>
</form>

</body>
</html>