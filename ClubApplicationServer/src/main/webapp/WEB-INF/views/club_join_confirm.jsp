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
<title>동호회 가입 신청 완료</title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
</style>

<script>
function go_home() {
	location.href="myclub_board.do?id=" + "<%=club_info.getId()%>";
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

동호회 가입신청이 완료되었습니다. 승인 받은 후에 사용할 수 있습니다.</br>
<button onclick="go_home();">확인</button>

</div>

<div id="right_nav">
<jsp:include page="club_right_nav.jsp"></jsp:include>
</div>

</div>

</body>
</html>