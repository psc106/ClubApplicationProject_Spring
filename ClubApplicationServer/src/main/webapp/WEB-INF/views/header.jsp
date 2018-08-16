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

#header_search {
	
}

#header_box {
	display: inline;
	float: right;
	margin-top: 20px;
	margin-right: 50px;
}
</style>

<script>
</script>
</head>
<body>
<div id="header">
<img id="logo" width="50px" height="50px" src="resources/logo.png" />

<input type="text" id="header_search" name="header_search" />
<input type="button" id="header_search_btn" name="header_search_btn" value="검색" />

<div id="header_box" name="header_box">
<input type="button" id="header_login_btn" name="header_login_btn" value="로그인" />
</div>
</div>

</body>
</html>