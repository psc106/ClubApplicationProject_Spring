<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
#wrap {
	width: 800px;
	height: 900px;
	margin-top: 200px;
	border: 1px solid black;
	margin: 0px auto;
}
</style>

<script>
</script>
</head>
<body>
<div id="wrap">
<h3>회원가입</h3>

<input type="text" placeholder="이메일" /> <button>중복 확인</button></br>
<input type="password" placeholder="비밀번호" /></br>
<input type="password" placeholder="비밀번호 확인" /></br>
<input type="text" placeholder="이름" /></br>
생년월일 </br>
성별 </br>
<input type="radio" name="chk_gender" value="man">남</br>
<input type="radio" name="chk_gender" value="woman">여</br>
전화번호 <input type="text" placeholder="년" /><input type="text" placeholder="월" /><input type="text" placeholder="일" /></br>
</br>
<button>가입</button>
</div>
</body>
</html>