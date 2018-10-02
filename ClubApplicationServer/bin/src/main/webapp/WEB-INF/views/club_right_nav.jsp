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
<title>club_right_nav</title>
<style>
#notice {
	width:100%;
	height: 200px;
	border: 1px solid black;
	margin-bottom: 20px;
}
</style>

<script>
function myclub_setting() {
	document.location.href = "myclub_setting.do?id=" + "<%=club_info.getId()%>";
}
</script>
</head>
<body>
<div id="notice">
공지사항
</div>

<a onclick="myclub_setting();" style="cursor:pointer"><img width="20px" height="20px" src="resources/setting_icon.png"/>동호회 설정</a>
</body>
</html>