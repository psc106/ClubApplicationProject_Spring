<%@page import="java.util.ArrayList"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@page import="com.teamproject.club_application.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member login_member = (Member)session.getAttribute("login_member");
ArrayList<Club> myclub = (ArrayList<Club>)session.getAttribute("myclub");

%>

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
	border:1px solid #e2c3c3;
	top: 0;
	left: 0;
	width: 100%;
	height: 100px;
	box-sizing: border-box;
	background-color: #FAAC58;
}

#logo {
	margin-top:10px;
	margin-left:10px;
	vertical-align: middle;
}

.header_search {
	display: inline;
}

#header_box {
	display: inline;
	float: right;
	height: 80px;
    line-height: 80px;
    margin-right:20px;
}

#setting_icon {
	vertical-align: middle;
	cursor:pointer;
}

#myclub_sel {
	display: inline;
}

#login_top {
	font-size: 10px;
}

</style>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
function login() {
	document.location.href = "login.do";
}

function logout() {
	document.location.href = "logout_ok.do";
}

function my_setting() {
	document.location.href = "my_club.do";
}

function change_myclub(club_value) {
	//alert(club_value + "!");
	
	var form = document.getElementById("myclub_sel");
	form.submit();
}

function search() {
	var search_input = document.getElementById("header_search");	
	/*
	if (search_input.value == "") {
		window.alert("검색어를 입력하세요.");
		search_input.focus();
		return;
	}
	*/
	
	document.location.href="search.do?search=" + escape(encodeURIComponent(search_input.value)) + "&page=1";
}
</script>
</head>
<body>
<div id="header">
<a href="home.do"><img id="logo" width="80px" height="80px" src="resources/logo.png" /></a>

<div class="header_search">
	<input type="text" id="header_search" name="header_search" placeholder="검색어 입력" />
	<button id="header_search_btn" name="header_search_btn" onclick="search();">검색</button>
</div>

<div id="header_box" name="header_box">
<%
Member login = login_member;
if(login == null) { // 비로그인 %>
	<button id="header_login_btn" name="header_login_btn" onclick="login();">로그인</button>
<%} else { // 로그인 %>
	<font id="login_top"><%=login_member.getName() %>님 환영합니다.
	
	<form id="myclub_sel" action="myclub_sel.do" method="get" >
	<select id="myclub" name="myclub" onchange="change_myclub(this.value)">
    <option value="">내 동호회</option>
<%for(int i=0; i<myclub.size(); i++){%>
	<option value="<%=myclub.get(i).getId() %>"><%=myclub.get(i).getName() %></option>
<%} %>
	</select>
	</form>
	
	<img width="30px" height="30px" onclick="my_setting();" id="setting_icon" src="resources/setting_icon.png" />
	</font>
	<button onclick="logout();">로그아웃</button>
<%}%>

</div>
</div>

</body>
</html>