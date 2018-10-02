<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club club_info = (Club)request.getAttribute("club_info");

String getClubImage = (String)request.getAttribute("getClubImage");
Integer countClubMember = (Integer)request.getAttribute("countClubMember");

String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
String attach_path = "resources/upload/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 설정 : <%=club_info.getName() %></title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>

</style>

<script>
function update_club() {
	var input = document.getElementById("att_image");
	var intro = document.getElementById("intro");
	var club_max_people = document.getElementById("club_max_people");
	
	if(<%=countClubMember%> > club_max_people.value) {
		alert("현재 인원보다 커야 합니다.");
		return;
	}
	
	if (club_max_people.value == "") {
		alert("최대인원 을입력하세요.");
		return;
	}
	
	pathpoint = input.value.lastIndexOf('.');
	filepoint = input.value.substring(pathpoint+1, input.length);
	filetype = filepoint.toLowerCase();
	alert("input.value:"+input.value+", pathpoint:"+pathpoint+", filepoint:"+filepoint+", filetype:"+filetype);
	if(filetype!="" && !(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg' || filetype=='bmp')) {	
		alert("프로필은 이미지만 가능합니다.");
		return;
	}
	
	if (club_max_people.value != "") {
		var form = document.getElementById("update_club_info_form");
		form.submit();
		alert("수정  완료.");
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
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>

<div id="wrap">
<div id="left_nav">
<jsp:include page="club_left_nav.jsp"></jsp:include>
</div>

<div id="club_content">
<jsp:include page="myclub_setting_menu.jsp"></jsp:include>

<h3>동호회 정보 수정</h3>

<form id="update_club_info_form" action="update_club_info.do?id=<%=club_info.getId() %>" method="post" enctype="multipart/form-data">
<div>
<img id="pre_img" src="<%=url+"/"+attach_path+getClubImage %>" alt="pre_img" width="80px" height="80px" /></br>
<input type="file" id="att_image" name="image" onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png" />
</div>
<br>

<p>동호회 소개<br></p>
<textarea id="intro" name="intro" cols="30" rows="3" placeholder="소개글"><%=club_info.getIntro() %></textarea>

<p>동호회 최대 인원 : <input type="text" name="club_max_people" id="club_max_people" value="<%=club_info.getMax_people()%>"/>명</p>

<button type="button" onclick="update_club();">변경</button>
</form>

</div>



</div>

</body>
</html>