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
<title>글제목</title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
#club_board_write_profile {
	width: 100%;
	height: 50px;
	margin-top: 20px;
	display: block;
}
.user_profile {
	float: left;
	font-size: 12px;
	margin-right: 10px;
}
#board_time {
	font-size: 10px;
}
.board_picture {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-auto-rows: 200px;
  border: solid 1px black;
}


#club_board_comment {
	width: 100%;
	height: 50px;
	margin-top: 20px;
	display: block;
}
.user_comment_profile {
	float: left;
	font-size: 12px;
	margin-right: 10px;
}

</style>

<script>
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

<input type="text" id="club_search" placeholder="검색" /> <button>검색</button></br>

<div id="club_board_write_profile">
<span class="user_profile">
<img width="40px" height="40px" src="resources/user_profile.png" />
</span>
<span class="user_profile">
<div id="board_user_name">유저 닉네임</div>
<time id="board_time" datetime="2018-08-21">3시간 전</time>
</span>
</div>

<p>
게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!
게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!게시글 내용!
</p>

<div class="board_picture">
  <div>One</div>
  <div>Two</div>
  <div>Three</div>
</div>

댓글</br>
<div id="club_board_comment">
<span class="user_comment_profile">
<img width="40px" height="40px" src="resources/user_profile.png" />
</span>
<span class="user_profile">
<div id="board_user_name">유저 닉네임</div>
<time id="board_time" datetime="2018-08-21">5시간 전</time>
</span>
</div>

<textarea cols="80" rows="6"></textarea><button>입력</button>

</div>

<div id="right_nav">
<jsp:include page="club_right_nav.jsp"></jsp:include>
</div>

</div>
</body>
</html>