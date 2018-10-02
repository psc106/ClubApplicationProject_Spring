<%@page import="com.teamproject.club_application.data.ClubView"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ClubView> getClubList = (ArrayList<ClubView>) request.getAttribute("getClubList");
	ArrayList<Integer> getClubMemberCount = (ArrayList<Integer>) request.getAttribute("getClubMemberCount");

	Integer totalCount = (Integer) request.getAttribute("totalCount");
	Integer pageCount = (Integer) request.getAttribute("pageCount");
	Integer mpage = (Integer) request.getAttribute("page");
	String search = (String) request.getAttribute("search");

	String url = request.getRequestURL().toString().replace(request.getRequestURI(), "")
			+ request.getContextPath();
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
	border: 1px solid #e2c3c3;
}

.club_info {
	width: 600px;
	margin-bottom: 15px;
}

.club_profile {
	width: 150px;
	height: 150px;
}

#max_member {
	width: 150px;
}
</style>

<script>
function search() {
	var search_input = document.getElementById("search");	
	/*
	if (search_input.value == "") {
		window.alert("검색어를 입력하세요.");
		search_input.focus();
		return;
	}
	*/
	
	document.location.href="search.do?search=" + escape(encodeURIComponent(search_input.value)) + "&page=" + <%=mpage%>;
}

function movePage(page) {
	document.location.href="search.do?search=" + escape(encodeURIComponent("<%=search%>")) + "&page=" + page;
}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<div id="wrap">
		<br>
		<h3>검색</h3>


		<p>
			<input type="text" id="search" placeholder="검색어 입력" />
			<button type="button" onclick="search();">검색</button>
		</p>

		<%
			for (int i = 0; i < getClubList.size(); i++) {
		%>
		<table class="club_info">
			<tr>
				<td rowspan="3" class="club_profile"><img class="club_profile"
					src="<%=url + "/" + attach_path + getClubList.get(i).getImgUrl()%>" /></td>
				<td colspan="2"><a
					href="myclub_board.do?id=<%=getClubList.get(i).getId()%>"><%=getClubList.get(i).getName()%></a></td>
			</tr>
			<tr>
				<td id="max_member">멤버 수: <%=getClubMemberCount.get(i)%>명
				</td>
				<td>리더 : <%=getClubList.get(i).getNickname()%></td>
			</tr>
			<tr>
				<td colspan="2">소개<%=getClubList.get(i).getIntro()%></td>
			</tr>
		</table>
		<%
			}
		%>

		<div id="page">
			<%
				for (int i = 0; i < Math.ceil((float) totalCount / (float) pageCount); i++) {
			%>
			<a href="#" onclick="movePage(<%=i+1 %>);">[<%=i+1 %>]
			</a>
			<%} %>
		</div>

	</div>
</body>
</html>