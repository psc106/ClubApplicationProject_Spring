<%@page import="com.teamproject.club_application.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member login_member = (Member)session.getAttribute("login_member");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<link rel="stylesheet" href="resources/css/my_page.css?ver=1" type="text/css">
<style>
#right_content{
	margin-top:30px;
}
#right_content {
	height: 970px;
	
}
.err_msg {
	width: 100%;
	height: 15px;
	color: #ff0000;
	font-size: 15px;
	margin-top: 3px;
	display: none;
}
.word {
	width:100px;
}
</style>

<script>
function updateInfo() {
	var pw_1 = document.getElementById("login_pw");
	var pw_2 = document.getElementById("login_pw2");
	var name = document.getElementById("name");
	var birthday = document.getElementById("birthday");
	var gender = document.getElementsByName("gender");
	var phone = document.getElementById("phone");
	var local = document.getElementById("local");

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

	if (pw_1.value != "" && pw_2.value != "" && (pw_1.value == pw_2.value)
		&& name != "" && birthday != "" && gender_count > 0 && phone.value != "" && local.options[local.selectedIndex].value != "") {
		var form = document.getElementById("update_form");
		form.submit();
		alert("수정 완료");
	}
}

</script>
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>

<div id="wrap">
<div id="nav">
<jsp:include page="my_page_nav.jsp"></jsp:include>
</div>

<div id="right_content">
<form action="my_info_update.do" id="update_form" method="post">
<span class="word">비밀번호</span><input type="password" name="login_pw" id="login_pw" value="<%=login_member.getLogin_pw() %>" placeholder="비밀번호" /><br><br>
<div id="err_pw_1" class="err_msg"></div>
<span class="word">비밀번호 확인</span><input type="password" name="login_pw2" id="login_pw2" value="<%=login_member.getLogin_pw() %>" placeholder="비밀번호 확인" /><br><br>
<div id="err_pw_2" class="err_msg"></div>

<span class="word">이름</span><input type="text" name="name" id="name" value="<%=login_member.getName() %>" placeholder="이름"/><br><br>
<div id="err_name" class="err_msg"></div>
<span class="word">생일</span><input type="text" name="birthday" id="birthday" value="<%=login_member.getBirthday() %>" placeholder="생년월일(숫자8자)" /><br><br>
<div id="err_birth" class="err_msg"></div>


<span class="word">성별</span><input type="radio" name="gender" value="0"
<%if(login_member.getGender() == 0) {%>checked="checked" <%}%> />남
<input type="radio" name="gender" value="1"
<%if(login_member.getGender() == 1) {%>checked="checked" <%}%> />여</br><br>
<div id="err_gender" class="err_msg"></div>


<span class="word">지역</span><select id="local" name="local">
				<option value="" selected="selected">지역</option>
				<option value="서울" <%if(login_member.getLocal().equals("서울")) {%>selected="selected" <%}%>>서울</option>
				<option value="경기" <%if(login_member.getLocal().equals("경기")) {%>selected="selected" <%}%>>경기</option>
				<option value="충청" <%if(login_member.getLocal().equals("충청")) {%>selected="selected" <%}%>>충청</option>
				<option value="전라" <%if(login_member.getLocal().equals("전라")) {%>selected="selected" <%}%>>전라</option>
			</select><br>
<div id="err_local" class="err_msg"></div>

<span class="word">전화번호</span><input type="text" name="phone" id="phone" value="<%=login_member.getPhone()%>" placeholder="전화번호" /></br><br>
<div id="err_phone" class="err_msg"></div></br>

<button type="button" onclick="updateInfo();">변경</button>
</form>
</div>


</div>
</body>
</html>