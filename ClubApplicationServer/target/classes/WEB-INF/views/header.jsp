<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style>
*{
	box-sizing:border-box;
}

#header {
	position:fixed;
	border:1px solid black;
	top: 0;
	left: 0;
	width: 100%;
	height: 70px;
	box-sizing: border-box;
	background-color: #9FF781;
}

#logo {
	margin-top: 10px;
	margin-left: 10px;
}

.header_search {
	display: inline;
}

#header_box {
	display: inline;
	float: right;
	margin-top: 20px;
	margin-right: 50px;
}

#login_top {
	font-size: 10px;
}

</style>

<script>
</script>
</head>
<body>
<div id="header">
<a href="home.do"><img id="logo" width="50px" height="50px" src="resources/logo.png" /></a>

<div class="header_search">
	<input type="text" id="header_search" name="header_search" placeholder="검색어 입력" />
	<button id="header_search_btn" name="header_search_btn">검색</button>
</div>

<div id="header_box" name="header_box">
<%
int login = 1;
if(login == 0) { // 비로그인 %>
	<button id="header_login_btn" name="header_login_btn">로그인</button>
<%} else if(login == 1) { // 로그인 %>
	<font id="login_top">~~님 환영합니다.
	<select name="myclub">
    <option value="">내 동호회</option>
	</select>
	<img width="30px" height="30px" src="resources/setting_icon.png" />
	</font>
<%}%>

</div>
</div>

</body>
</html>