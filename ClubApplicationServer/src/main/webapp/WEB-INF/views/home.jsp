<%@page import="com.teamproject.club_application.data.Club"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.teamproject.club_application.data.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
Member login_member = (Member)session.getAttribute("login_member");
ArrayList<Club> myclub = (ArrayList<Club>)session.getAttribute("myclub");
%>
<html>
<head>
	<title>Home</title>
</head>
<link rel="stylesheet" href="resources/css/home.css" type="text/css">
<style>
#wrap {
	width:400px;
	height:auto;
	margin:0px auto;
	margin-top:150px;
	
}

#login {
	width:100%;
}

#home {
	width:400px;
	height:180px;
	border:1px solid #e2c3c3;
	padding:10px;
}

.btn {
	width:120px;
	height:40px;
	border:0;
	background:#fc9255;
	color:#ffffff;
	text-shadow:0 1px rgba(0,0,0,.2);
	font-size:18px;
	cursor:pointer;
}

#setting_icon {
	vertical-align: bottom;
	cursor:pointer;
}

#header_login_btn {
	
}

</style>

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

function create_club() {
	document.location.href = "create_club.do";
}

function go_search() {
	document.location.href = "search.do";
}
</script>
<body>

<div id="wrap">
<div id="login_logo" name="login_logo"><img width="400px" height="400px" src="resources/main_logo.png" /></div><br>

	<div id="home">
	<%
	Member login = login_member;
	if(login == null) { // 비로그인 %>
		<center><button style="margin-top:50px;" id="header_login_btn" class="btn" id="header_login_btn" onclick="login();">로그인</button></center>	
	<%} else { // 로그인 %>
	<p><%=login_member.getName() %>님 환영합니다.
	<img width="30px" height="30px" id="setting_icon" onclick="my_setting();" src="resources/setting_icon.png" /> 
	<button onclick="logout();">로그아웃</button></p>
	<form id="myclub_sel" action="myclub_sel.do" method="get" >
	<select id="myclub" name="myclub" onchange="change_myclub(this.value)">
    <option value="">내 동호회</option>
	<%for(int i=0; i<myclub.size(); i++){%>
		<option value="<%=myclub.get(i).getId() %>"><%=myclub.get(i).getName() %></option>
	<%} %>
	</select>
	<button onclick="create_club();" type="button">동호회 생성</button>
	</form>
	
	<button onclick="go_search();" type="button">검색</button>
	
	<%} %>
	

	</div>

</div>
</body>
</html>
