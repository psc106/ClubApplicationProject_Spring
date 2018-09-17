<%@page import="com.teamproject.club_application.data.ClubView"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

ArrayList<ClubView> getClubList = (ArrayList<ClubView>)request.getAttribute("getClubList");
ArrayList<Integer> getClubMemberCount = (ArrayList<Integer>)request.getAttribute("getClubMemberCount");

String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
String attach_path = "resources/upload/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<link rel="stylesheet" href="resources/css/home.css" type="text/css">
<style>
table tr, td {
	border:1px solid #e2c3c3;
}
.club_info{
	width:600px;
	margin-bottom:15px;
}
.club_profile{
	width:150px;
	height:150px;
}
#max_member{
	width:150px;
}
</style>

<script>
function search() {
	document.location.href = ".do";
}
</script>
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>

<div id="wrap">
<h3>검색</h3>

<form>
<p>
<input type="text" id="search_parameter" /><button type="button" onclick="search();">검색</button>
</p>
</form>
<%for(int i=0; i<getClubList.size(); i++) { %>
<table class="club_info">
<tr>
	<td rowspan="3" class="club_profile"><img class="club_profile" src="<%=url+"/"+attach_path+getClubList.get(i).getImg_db_name() %>" /></td>
	<td colspan="2" ><%=getClubList.get(i).getName() %></td>
</tr>
<tr>
	<td id="max_member">멤버 수: <%=getClubMemberCount.get(i) %>명</td>
	<td>리더 : <%=getClubList.get(i).getNickname() %></td>
</tr>
<tr>
	<td colspan="2">소개<%=getClubList.get(i).getIntro() %></td>
</tr>
</table>
<%} %>

</div>
</body>
</html>