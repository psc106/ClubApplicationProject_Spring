<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club club_info = (Club)request.getAttribute("club_info");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 설정 메뉴</title>
<style>
.club_tab_menu {
	width: 100%;
	height: 50px;
	border: 1px solid black;
	display: block;
}
#club_tab_menu {
	width: 100%;
	height: 50px;
}
#tab1 {
	width: 222px;
}
#tab2 {
	width: 222px;
}
#tab3 {
	width: 222px;
}
</style>

<script>
function btn_myclub_info() {
	document.location.href="myclub_setting.do?id=" + "<%=club_info.getId()%>";
}
function btn_club_album() {
	document.location.href="myclub_setting_club.do?id=" + "<%=club_info.getId()%>";
}
function btn_myclub_member() {
	document.location.href="myclub_setting_member.do?id=" + "<%=club_info.getId()%>";
}
</script>
</head>
<body>
<div class="club_tab_menu">
<table id="club_tab_menu"  border="1">
<tr>
	<td id="tab1"><button onclick="btn_myclub_info();">내 정보 수정</button></td>
	<td id="tab2"><button onclick="btn_club_album();">동호회 정보 수정</button></td>
	
	<td id="tab3"><button onclick="btn_myclub_member();">멤버 관리</button></td>
	
</tr>
</table>
</div>
</body>
</html>