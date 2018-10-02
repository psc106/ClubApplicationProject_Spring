<%@page import="com.teamproject.club_application.data.Member"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club club_info = (Club)request.getAttribute("club_info");
Integer countClubMember = (Integer)request.getAttribute("countClubMember");
String getClubMaster = (String)request.getAttribute("getClubMaster");
String getClubImage = (String)request.getAttribute("getClubImage");

Member login_member = (Member)session.getAttribute("login_member");

String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
String attach_path = "resources/upload/";
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

function myclub_setting() {
	document.location.href = "myclub_setting.do?id=" + "<%=club_info.getId()%>";
}
</script>
</head>
<body>
<a href="myclub_board.do?id=<%=club_info.getId()%>">

<img id="club_profile" width="150px" height="150px" src="<%=url+"/"+attach_path+getClubImage %>" />

</a>
<h5>리더 : <%=getClubMaster %></h5>
<h5>멤버 : <%=countClubMember %>명</h5>
<h6>소개 : <%=club_info.getIntro() %></h6>

<button onclick="club_join(<%=club_info.getId() %>);">가입</button>

</br></br>
<a onclick="myclub_setting();" style="cursor:pointer"><img width="20px" height="20px" src="resources/setting_icon.png"/>동호회 설정</a>

</body>
</html>