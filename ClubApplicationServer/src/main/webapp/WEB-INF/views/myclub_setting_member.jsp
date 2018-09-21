<%@page import="com.teamproject.club_application.data.Club"%>
<%@page import="com.teamproject.club_application.data.ClubMemberView"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club club_info = (Club)request.getAttribute("club_info");

ArrayList<ClubMemberView> getClubApplyList = (ArrayList<ClubMemberView>)request.getAttribute("getClubApplyList");
ArrayList<ClubMemberView> getClubMemberList = (ArrayList<ClubMemberView>)request.getAttribute("getClubMemberList");
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
table tr, td {
	border:1px solid #e2c3c3;
}
.club_info {
	width:700px;
	margin-bottom:15px;
}
.club_1 {
	width:80px;
}
.club_2 {
	width:200px;
}
.club_3 {
	width:300px;
}
.club_4 {
	width:120px;
}
</style>

<script>
function apply_confirm(member_id) {
<%if(club_info.getMax_people() < countClubMember) {%>
	alert("인원수가 꽉차 추가 불가");
<%} else {%>
	if (confirm("정말 수락하시겠습니까??") == true){ //확인
		alert("수락되었습니다." + member_id);
		document.location.href="myclub_member_confirm.do?id=" + "<%=club_info.getId()%>" +"&member_id="+member_id;
	}else{   //취소
	    return;
	}
<%}%>
}

function apply_cancel(member_id) {
	if (confirm("정말 거절하시겠습니까??") == true){ //확인
		alert("거절되었습니다."+member_id);
		document.location.href="myclub_member_del.do?id=" + "<%=club_info.getId()%>" +"&member_id="+member_id;
	}else{   //취소
	    return;
	}
}

function member_del(member_id) {
	if (confirm("정말 강퇴하시겠습니까??") == true){ //확인
		alert("삭제되었습니다.");
		document.location.href="myclub_member_del.do?id=" + "<%=club_info.getId()%>" +"&member_id="+member_id;
	}else{   //취소
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

<h3>멤버 관리</h3>
<h5>가입신청자</h5>
<table class="club_info">
	<tr>
		<td class="club_1">프로필</td>
		<td class="club_2">닉네임</td>
		<td class="club_3">아이디</td>
		<td class="club_4">승인</td>
	</tr>
	<%if(getClubApplyList.size() <= 0) { %>
	<tr>
		<td colspan="4">내용이 없습니다.</td>
	</tr>
	<%} else {
	for(int i=0; i<getClubApplyList.size(); i++) { %>
	<tr>
		<td>
		<%if(getClubApplyList.get(i).getImg_db_name().equals("default")) { %>
		
		<%} else { %>
			<img width="40px" height="40px" src="<%=url+"/"+attach_path+getClubApplyList.get(i).getImg_db_name()%>" />
		<%} %>
		</td>
		<td><%=getClubApplyList.get(i).getNickname() %></td>
		<td><%=getClubApplyList.get(i).getLogin_id() %></td>
		<td><button type="button" onclick="apply_confirm(<%=getClubApplyList.get(i).getMember_id()%>);">승인</button><button type="button" onclick="apply_cancel(<%=getClubApplyList.get(i).getMember_id()%>);">거부</button></td>
	</tr>

	<%}} %>
</table>



<h5>멤버 목록</h5>
<table class="club_info">
	<tr>
		<td class="club_1">프로필</td>
		<td class="club_2">닉네임</td>
		<td class="club_3">아이디</td>
		<td class="club_4">강퇴</td>
	</tr>
	<%if(getClubMemberList.size() <= 0) { %>
	<tr>
		<td colspan="4">내용이 없습니다.</td>
	</tr>
	<%} else {
		for(int i=0; i<getClubMemberList.size(); i++) { %>
	<tr>
		<td><img width="40px" height="40px" src="<%=url+"/"+attach_path+getClubMemberList.get(i).getImg_db_name()%>" /></td>
		<td><%=getClubMemberList.get(i).getNickname() %></td>
		<td><%=getClubMemberList.get(i).getLogin_id() %></td>
		<td><button type="button" onclick="member_del(<%=getClubMemberList.get(i).getMember_id()%>);">강퇴</button></td>
	</tr>
	<%} } %>
</table>
</div>



</div>
</body>
</html>