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

	ArrayList<PostProfile> postProfile = (ArrayList<PostProfile>) request.getAttribute("postProfile");
	Integer totalCount = (Integer)request.getAttribute("totalCount");
	Integer pageCount = (Integer)request.getAttribute("pageCount");
	Integer mpage = (Integer)request.getAttribute("page");
	String search  = (String)request.getAttribute("search");
	
	System.out.println("postProfile size : " + postProfile.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=club_info.getName() %></title>
<link rel="stylesheet" href="resources/css/myclub.css?ver=1" type="text/css">
<style>
#board_content {
	
}
#board {
	width:100%;
}
#board_1 {
	width:100px;
}
#board_2 {
	width:500px;
}
#board_3 {
	width:150px;
}
#board_4 {
	width:150px;
}
#boardContent {
 	display: block; 
	overflow: hidden; 
	text-overflow: ellipsis;
	white-space: nowrap; 
	width: 150px;
	height: 30px;
}
</style>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
function write_board() {	
	document.location.href = "myclub_write.do?id=" + "<%=club_info.getId()%>";
}

function board_search() {
	alert("검색실행됨");
	var search_input = document.getElementById("search");	
	/*
	if (search_input.value == "") {
		window.alert("검색어를 입력하세요.");
		search_input.focus();
		return;
	}
	*/
	alert("검색실행됨2");
	document.location.href="myclub_board.do?id=" + "<%=club_info.getId()%>" + "&search=" + escape(encodeURIComponent(search_input.value)) + "&page=" + <%=mpage%>;
}

function movePage(page) {
	document.location.href="myclub_board.do?id=" + "<%=club_info.getId()%>" + "&search=" + escape(encodeURIComponent("<%=search%>")) + "&page=" + page;
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
		<!-- <jsp:include page="club_tab_menu.jsp"></jsp:include> -->
		
		<div id="board_content">
		<h3>게시판</h3>
		
		<table id="board" border="1">
		<tr>
			<th id="board_1">번호</th>
			<th id="board_2">내용</th>
			<th id="board_3">날짜</th>
			<th id="board_4">글쓴이</th>
		</tr>
<%if(postProfile.size() == 0) { %>
	<tr>
		<td class="no_data" colspan="4">게시물이 없습니다.</td>
	</tr>
<%}else { %>
		<% for (int i = 0; i < postProfile.size(); i++) { %>
		<tr>
			<td class="number"><%=postProfile.get(i).getPost().getId()%></td>
			<td><a href="myclub_detail.do?id=<%=club_info.getId()%>&post_id=<%=postProfile.get(i).getPost().getId()%>">
				<font id="boardContent" name="boardContent">
					<%=postProfile.get(i).getPost().getContent()%>
				</font></a></td>
			<td class="date"><%=postProfile.get(i).getPost().getCreate_date()%></td>
			<td><%=postProfile.get(i).getProfile().getNickname()%></td>
		</tr>
		
		<%} %>
<%}	%>
		</table>
		<div id="page">
			<%for(int i=0; i<Math.ceil((float)totalCount/(float)pageCount); i++) { %>
			<a href="#" onclick="movePage(<%=i+1 %>);">[<%=i+1 %>]</a>
			<%} %>
		</div>
		
		<input type="text" id="search" />
		<!-- <select name="searchOption" id="searchOption">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">글쓴이</option>
		</select> -->
		<input type="button" name="searchBtn" id="searchBtn" value="검색!"
				onclick="board_search();" />

		<div style="float: right">
		<input type="button" id="writeBtn" value="글작성"	onclick="write_board();" />
		</div>
	</div>
			
	</div>



	

</div>

</body>
</html>