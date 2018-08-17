<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/home.css" type="text/css">
<style>
#wrap {
	width:400px;
	height:auto;
	margin:0px auto;
	margin-top:150px;
	border:1px solid black;
}

input[type=text],input[type=password] {
	width:150px;
	margin-left:10px;
}


#login {
	width:100%;
}

table, th, td {
	border:1px solid #e2c3c3;
}

#table_login {
	width:400px;
	height:150px;
}

.loginBtn {
	width:100%;
	height:100%;
	border:0;
	background:#fc9255;
	color:#ffffff;
	text-shadow:0 1px rgba(0,0,0,.2);
	font-size:18px;
	cursor:pointer;
}

#footer {
	margin-top:10px;
	color:#cacaca;
}

#findIdPwBtn {
	width:120px;
	height:40px;
	border:0;
	border-radius:5px;
	background:#fc9255;
	color:#ffffff;
	text-shadow:0 1px rgba(0,0,0,.2);
	font-size:13px;
	cursor:pointer;
}

#joinBtn {
	float:right;
	width:70px;
	height:40px;
	border:0;
	border-radius:5px;
	background:#fc9255;
	color:#ffffff;
	text-shadow:0 1px rgba(0,0,0,.2);
	font-size:13px;
	cursor:pointer;
}

</style>

<script>
function login() {
	var login_id = document.getElementById("login_id");
	var login_pw = document.getElementById("login_pw");
	
	if(login_id.value == ""){
		window.alert("아이디를 입력하세요.");
		login_id.focus();
		return;
	}
	
	if(login_pw.value == ""){
		window.alert("비밀번호를 입력하세요.");
		login_pw.focus();
		return;
	}
	
	var form = document.getElementById("login_form");
	form.submit();
	
}
</script>
</head>
<body>
<div id="wrap">
<div id="main_logo" name="main_logo"><img width="400px" height="250px" src="resources/main_logo.png" /></div><br>
<form action="login_ok.do" id="login_form" method="post">
	<table id="table_login">
	<tr>
		<td><input type="text" tabindex="1" placeholder="아이디" name="login_id" id="login_id" /></td>
		<td rowspan="2"><input type="button" tabindex="3" value="login" class="loginBtn" onclick="login();" /></td>
	</tr>
	<tr>
		<td><input type="password" tabindex="2" placeholder="비밀번호" name="login_pw" id="login_pw" value="" /></td>
	</tr>
	</table>
	</form>
	<div id="footer">
	<button type="button" tabindex="-1" id="findIdPwBtn" onclick="location.href='findIdPw.do'">id / 비밀번호 찾기</button>
	<button type="button" tabindex="-1" id="joinBtn" onclick="location.href='join.do'">회원가입</button>
	</div>
</div>


</body>
</html>