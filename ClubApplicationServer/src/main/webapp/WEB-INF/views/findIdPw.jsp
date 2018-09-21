<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
#wrap {
	width: 800px;
	height: 900px;
	margin-top: 200px;
	border: 1px solid #e2c3c3;
	margin: 0px auto;
}
</style>

<script>
function send_pw() {
	var login_id = document.getElementById("login_id");
	
	if(login_id.value == "") {
		alert("id를 입력하세요.");
	}
	
	if(login_id.value != ""){
		var form = document.getElementById("find_pw_form");
		form.submit();
	}
}
</script>
</head>
<body>
<div id="wrap">
	<h3>비밀번호 찾기</h3>

	<form action="findIdPw_ok.do" id="find_pw_form" method="post">
		<input style="margin-left:10px;" type="text" id="login_id" name="login_id" placeholder="이메일 입력" />
		
		<button type="button" onclick="send_pw();">보내기</button>
	</form>

</div>


</body>
</html>