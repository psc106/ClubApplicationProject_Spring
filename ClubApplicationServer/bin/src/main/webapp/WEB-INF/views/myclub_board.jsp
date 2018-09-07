<%@page import="com.teamproject.club_application.data.ClubMember"%>
<%@page import="com.teamproject.club_application.data.Member"%>
<%@page import="com.teamproject.club_application.data.PostProfile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Club club_info = (Club) request.getAttribute("club_info");
	//ArrayList<ClubMember> club_member = (ArrayList<ClubMember>) request.getAttribute("club_member");
	//Member login_member = (Member)session.getAttribute("login_member");

	
	ArrayList<PostProfile> PostProfile = (ArrayList<PostProfile>) request.getAttribute("PostProfile");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=club_info.getName() %></title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
#board_content {
	margin-top:40px;
	border:1px solid black;
}
#board {
	width:100%;
}
#board_1 {
	width:60px;
}
#board_2 {
	width:300px;
}
#board_3 {
	
}
</style>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
function write_board() {	
	document.location.href = "myclub_write.do?id=" + "<%=club_info.getId()%>";
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
		<jsp:include page="club_tab_menu.jsp"></jsp:include>
		
		<div id="board_content">
		<table id="board" border="1">
		<tr>
			<th id="board_1">번호</th>
			<th id="board_2">내용</th>
			<th id="board_3">날짜</th>
			<th id="board_4">글쓴이</th>
		</tr>
		<%
			for (int i = 0; i < PostProfile.size(); i++) {
		%>
		<tr>
			<td class="number"><%=PostProfile.get(i).getPost().getId()%></td>
			<td><a href="detail.do?id=<%=PostProfile.get(i).getPost().getId()%>"><font id="boardContent" name="boardContent"><%=PostProfile.get(i).getPost().getContent()%></font></a></td>
			<td class="date"><%=sdf.format(PostProfile.get(i).getPost().getCreate_date())%></td>
			<td><%=PostProfile.get(i).getProfile().getNickname()%></td>
		</tr>
		<%
			}
		%>
		</table>
		
		<input type="text" id="search" />
		<select name="searchOption" id="searchOption">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">글쓴이</option>
		</select> <input type="button" name="searchBtn" id="searchBtn" value="검색"
				onclick="search();" />

		<div style="float: right">
		<input type="button" id="writeBtn" value="글작성"	onclick="write_board();" />
		</div>
	</div>
			
	</div>



	


	


	<div id="right_nav">
		<jsp:include page="club_right_nav.jsp"></jsp:include>
	</div>

</div>

</body>
</html>