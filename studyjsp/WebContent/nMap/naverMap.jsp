<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <title>네이버 지도 API - 주소로 지도 표시하기</title>
      <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=i9Uv85vXi3DIl0wfRiD5&submodules=geocoder"></script>
      <script type="text/javascript" src="naverAPI.js"></script>
  </head>
  <body>
 	<form method="post">
  	<input type="text" name="myaddress">
  	<input type="button" value="검색" onclick="search(this.form.myaddress.value)">
  </form>
  <br>
    <div style="width:30%;height:30%;" align="center">
   <div id="map" style="width:100%;height:300px;"></div></div>
  </body>
</html>