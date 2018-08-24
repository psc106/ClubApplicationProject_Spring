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

.err_msg {
	width: 100%;
	height: 15px;
	color: #ff0000;
	font-size: 15px;
	margin-top: 3px;
	display: none;
}
</style>

<script>
	function checkInfo() {
		var id = document.getElementById("login_mail");
		var pw_1 = document.getElementById("login_pw");
		var pw_2 = document.getElementById("login_pw2");
		var name = document.getElementById("name");
		var birthday = document.getElementById("birthday");
		var gender = document.getElementsByName("gender");
		var phone = document.getElementById("phone");
		var local = document.getElementById("local");

		var checkMail = document.getElementById("check_mail");


		if (id.value == "") {
			var err_id = document.getElementById("err_mail");
			err_id.style.display = "block";
			err_id.innerHTML = "이메일을 입력하세요.";
		} else {
			var err_id = document.getElementById("err_mail");
			err_id.style.display = "none";
		}

		if (pw_1.value == "") {
			var err_pw_1 = document.getElementById("err_pw_1");
			err_pw_1.style.display = "block";
			err_pw_1.innerHTML = "비밀번호를 입력하세요.";
		} else {
			var err_pw_1 = document.getElementById("err_pw_1");
			err_pw_1.style.display = "none";
		}

		if (pw_2.value == "") {
			var err_pw_2 = document.getElementById("err_pw_2");
			err_pw_2.style.display = "block";
			err_pw_2.innerHTML = "비밀번호를 입력하세요.";
		} else {
			var err_pw_2 = document.getElementById("err_pw_2");
			err_pw_2.style.display = "none";
		}

		if (pw_1.value != "" && pw_2.value != "" && (pw_1.value != pw_2.value)) {
			var err_pw_2 = document.getElementById("err_pw_2");
			err_pw_2.style.display = "block";
			err_pw_2.innerHTML = "비밀번호가 맞지 않습니다.";
		}

		if (name.value == "") {
			var err_name = document.getElementById("err_name");
			err_name.style.display = "block";
			err_name.innerHTML = "이름을 입력하세요.";
		} else {
			var err_name = document.getElementById("err_name");
			err_name.style.display = "none";
		}

		if (birthday.value == "") {
			var err_birth = document.getElementById("err_birth");
			err_birth.style.display = "block";
			err_birth.innerHTML = "생일을 입력하세요.";
		} else {
			var err_birth = document.getElementById("err_birth");
			err_birth.style.display = "none";
		}

		var gender_count = 0;
		for (var i = 0; i < gender.length; i++) {
			if (gender[i].checked) {
				gender_count++;
			}
		}
		if (gender_count == 0) {
			var err_gender = document.getElementById("err_gender");
			err_gender.style.display = "block";
			err_gender.innerHTML = "성별을 선택하세요.";
		} else {
			var err_gender = document.getElementById("err_gender");
			err_gender.style.display = "none";
		}

		if (phone.value == "") {
			var err_phone = document.getElementById("err_phone");
			err_phone.style.display = "block";
			err_phone.innerHTML = "전화번호를 입력하세요.";
		} else {
			var err_phone = document.getElementById("err_phone");
			err_phone.style.display = "none";
		}

		if (local.options[local.selectedIndex].value == "") {
			var err_local = document.getElementById("err_local");
			err_local.style.display = "block";
			err_local.innerHTML = "지역을 선택하세요.";
		} else {
			var err_local = document.getElementById("err_local");
			err_local.style.display = "none";
		}
		alert('선택된 local value 값=' + local.options[local.selectedIndex].value);


		if (checkMail.value == "0") {
			var err_id = document.getElementById("err_mail");
			err_id.style.display = "block";
			err_id.innerHTML = "중복 체크를 하세요.";
		}

		if (id.value != "" && pw_1.value != "" && pw_2.value != "" && (pw_1.value == pw_2.value)
			&& name != "" && birthday != "" && gender_count > 0 && phone.value != "" && local.options[local.selectedIndex].value != "" && checkMail.value != "0") {
			var form = document.getElementById("join_form");
			form.submit();
			alert("완료");
		}

	}

	function checkIdPopup() {
		window.open("mailCheck.do", "_blank", "");
	}
</script>
</head>
<body>
	<div id="wrap">
		<h3>회원가입</h3>

		<form action="join_ok.do" id="join_form">
			<input type="hidden" name="check_mail" id="check_mail" value="0" />

			<input type="text" name="login_mail" id="login_mail"
				placeholder="이메일" />
			<button type="button" onclick="checkIdPopup();">중복 확인</button>
			</br>
			<div id="err_mail" class="err_msg"></div>

			<input type="password" name="login_pw" id="login_pw"
				placeholder="비밀번호" /></br>
			<div id="err_pw_1" class="err_msg"></div>

			<input type="password" name="login_pw2" id="login_pw2"
				placeholder="비밀번호 확인" /></br>
			<div id="err_pw_2" class="err_msg"></div>

			<input type="text" name="name" id="name" placeholder="이름" /></br>
			<div id="err_name" class="err_msg"></div>

			생년월일 <input type="text" name="birthday" id="birthday"
				placeholder="생년월일 8자리" />

			<%-- <select name="birth_year">
  <option value="" selected="selected">선택</option>
  <%for(int i=1950; i<=2000; i++) { %>
	<option value="<%=i %>"><%=i %></option>
  <%} %>
</select> --%>

			</br>
			<div id="err_birth" class="err_msg"></div>

			성별 <input type="radio" name="gender" value="0" />남 <input
				type="radio" name="gender" value="1" />여</br>
			<div id="err_gender" class="err_msg"></div>

			전화번호 <input type="text" name="phone" id="phone" placeholder="전화번호" /></br>
			<div id="err_phone" class="err_msg"></div>

			지역 <select id="local" name="local">
				<option value="" selected="selected">선택</option>
				<option value="서울">서울</option>
				<option value="경기">경기</option>
				<option value="충청">충청</option>
				<option value="전라">전라</option>
			</select></br>
			<div id="err_local" class="err_msg"></div>

			</br>
			<button type="button" onclick="checkInfo();">가입</button>
		</form>

	</div>
</body>
</html>