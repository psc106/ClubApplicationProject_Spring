<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club club_info = (Club)request.getAttribute("club_info");
Integer countClubMember = (Integer)request.getAttribute("countClubMember");
String getClubMaster = (String)request.getAttribute("getClubMaster");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>left_nav</title>
<style>
#club_profile {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>

<script>
function club_join(id) {
	document.location.href = "club_join_confirm.do?id="+id;
}
</script>
</head>
<body>
<img id="club_profile" width="150px" height="150px" src="resources/club_profile.png" />
<h5>리더 : <%=getClubMaster %></h5>
<h5>멤버 : <%=countClubMember %>명</h5>
<h6>소개 : <%=club_info.getIntro() %></h6>
<button onclick="club_join(<%=club_info.getId() %>);">가입</button>

</body>
</html>