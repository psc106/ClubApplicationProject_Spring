<%@page import="com.teamproject.club_application.data.Member"%>
<%@page import="com.teamproject.club_application.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.teamproject.club_application.data.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Category> category_items = (ArrayList<Category>)request.getAttribute("items");
Member login_member = (Member)session.getAttribute("login_member");
%>

<%if(session.getAttribute("login_member") == null) {%>
<script>
alert("먼저 로그인하세요");
document.location.href="login.do";
</script>
<%}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 만들기</title>
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
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
function create_club() {
	var club_name = document.getElementById("club_name");
	var category = document.getElementById("category");
	var max_people = document.getElementById("max_people");
	var local = document.getElementById("local");
	var intro = document.getElementById("intro");
	
	if (club_name.value == "") {
		var err_club_name = document.getElementById("err_club_name");
		err_club_name.style.display = "block";
		err_club_name.innerHTML = "동호회 이름을 입력하세요.";
	} else {
		var err_club_name = document.getElementById("err_club_name");
		err_club_name.style.display = "none";
	}
	
	if (category.options[category.selectedIndex].value == "") {
		var err_category = document.getElementById("err_category");
		err_category.style.display = "block";
		err_category.innerHTML = "카테고리를 선택하세요.";
	} else {
		var err_category = document.getElementById("err_category");
		err_category.style.display = "none";
	}
	
	if (max_people.value == "") {
		var err_max_people = document.getElementById("err_max_people");
		err_max_people.style.display = "block";
		err_max_people.innerHTML = "최대인원을 입력하세요.";
	} else {
		var err_max_people = document.getElementById("err_max_people");
		err_max_people.style.display = "none";
	}
	
	if (local.options[local.selectedIndex].value == "") {
		var err_local = document.getElementById("err_local");
		err_local.style.display = "block";
		err_local.innerHTML = "지역을 선택하세요.";
	} else {
		var err_local = document.getElementById("err_local");
		err_local.style.display = "none";
	}
	
	if (intro.value == "") {
		var err_intro = document.getElementById("err_intro");
		err_intro.style.display = "block";
		err_intro.innerHTML = "소개를 입력하세요.";
	} else {
		var err_intro = document.getElementById("err_intro");
		err_intro.style.display = "none";
	}
	
	//alert("club_name:"+club_name.value+"///category:"+category.options[category.selectedIndex].value+"///max_people:"+max_people.value+"///local:"+local.options[local.selectedIndex].value+"///intro:"+intro.value);
	
	// 파일확장자 검사 다시
	var input = document.getElementById("att_image");
	pathpoint = input.value.lastIndexOf('.');
	filepoint = input.value.substring(pathpoint+1, input.length);
	filetype = filepoint.toLowerCase();
	//alert("input.value:"+input.value+", pathpoint:"+pathpoint+", filepoint:"+filepoint+", filetype:"+filetype);
	if(filetype!="" && !(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg' || filetype=='bmp')) {	
		alert("프로필은 이미지만 가능합니다.");
		return;
	} 
	
	if (club_name.value != "" && category.options[category.selectedIndex].value != "" && 
			max_people.value != "" && local.options[local.selectedIndex].value != "" && intro.value != "") {
	
		var form = document.getElementById("create_club_form");
		form.submit();
		alert("동아리 생성 완료");
	}	
}

function fileCheck(input) {
	pathpoint = input.value.lastIndexOf('.');
	filepoint = input.value.substring(pathpoint+1, input.length);
	filetype = filepoint.toLowerCase();
	if(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg' || filetype=='bmp') {
		// 정상적인 이미지 확장자 파일일 경우
		if(input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function (e) {
			$('#pre_img').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
		}
	} else {
		alert('이미지 파일만 선택할 수 있습니다.');
		return;
	}
	
}
</script>
</head>
<body>
	<div id="wrap">
	<h3>동호회 가입</h3>

	<form id="create_club_form" action="create_club_ok.do" id="create_club_form" method="post" enctype="multipart/form-data">
	<input type="text" name="club_name" id="club_name" placeholder="동호회 이름" />	</br>
	<div id="err_club_name" class="err_msg"></div>
	
	주제<select id="category" name="category">
		<option value="" selected="selected">선택</option>
<%for(int i=1; i<=category_items.size(); i++) { %>
		<option value="<%= i%>"><%=category_items.get(i-1).getName() %></option>
<%} %>		
	</select></br>
	<div id="err_category" class="err_msg"></div>
	
	<input type="text" id="max_people" name="max_people" placeholder="인원수"/>
	<div id="err_max_people" class="err_msg"></div>	
	
	지역 <select id="local" name="local">
		<option value="" selected="selected">선택</option>
		<option value="서울">서울</option>
		<option value="경기">경기</option>
		<option value="충청">충청</option>
		<option value="전라">전라</option>
	</select></br>
	<div id="err_local" class="err_msg"></div>
	
	대표 이미지</br>
	<img id="pre_img" src="resources/default_club.png" alt="pre_img" width="80px" height="80px" /></br>

	첨부파일 :	<input type="file" id="att_image" name="image" onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png" />

	</br>
	소개</br>
	<textarea id="intro" name="intro" cols="30" rows="3"></textarea></br>
	<div id="err_intro" class="err_msg"></div>
	
<button type="button" onclick="create_club();">가입</button>	
	
	
</form>
</div>
</body>
</html>