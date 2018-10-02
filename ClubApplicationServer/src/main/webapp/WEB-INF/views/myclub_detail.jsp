<%@page import="com.teamproject.club_application.data.CommentView"%>
<%@page import="com.teamproject.club_application.data.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.teamproject.club_application.data.PostProfile"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member login_member = (Member) session.getAttribute("login_member");

	Club club_info = (Club) request.getAttribute("club_info");
	PostProfile postProfileDetail = (PostProfile) request.getAttribute("postProfileDetail");
	String getProfileImage = (String) request.getAttribute("getProfileImage");
	ArrayList<String> getPostImage = (ArrayList<String>) request.getAttribute("getPostImage");

	String getMyProfileImage = (String) request.getAttribute("getMyProfileImage");
	String getMynickname = (String) request.getAttribute("getMynickname");
	ArrayList<CommentView> getCommentList = (ArrayList<CommentView>) request.getAttribute("getCommentList");

	String url = request.getRequestURL().toString().replace(request.getRequestURI(), "")
			+ request.getContextPath();
	String attach_path = "resources/upload/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
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
	grid-template-columns: 255px 255px 255px;
	grid-auto-rows: 250px;
}

.board_picture_content {
	width: 250px;
	height: 250px;
	margin-right: 5px;
}

.club_board_comment {
	width: 100%;
	margin-top: 20px;
	display: block;
}

.user_comment_profile {
	float: left;
	font-size: 12px;
	margin-right: 10px;
}

#comment_list {
	display: block;
}

.btn {
	margin: 10px;
}
</style>

<script>
function back_board() {
	document.location.href = "myclub_board.do?id=" + "<%=club_info.getId()%>";
}

function delete_comment(comment_id) {
	document.location.href = "delete_comment.do?id=" + "<%=club_info.getId()%>" + "&post_id=" + "<%=postProfileDetail.getPost().getId()%>" + "&comment_id=" + comment_id;
}

function insert_comment() {
	var comment_content = document.getElementById("comment_content");
	
	//alert(comment_content.value);
	if(comment_content.value == "") {
		alert("댓글내용을 입력하세요.");
		return;
	}
	//alert("실행...");
	var form = document.getElementById("insert_comment_form");
	form.submit();
	alert("댓글 입력 완료");
}

function modify_board() {
	document.location.href = "myclub_modify.do?id=" + "<%=club_info.getId()%>" + "&post_id=" + "<%=postProfileDetail.getPost().getId()%>";
}

function delete_board() {
	if (confirm("정말 삭제하시겠습니까??") == true){ //확인
		alert("삭제되었습니다.");
		document.location.href = "myclub_delete_ok.do?id=" + "<%=club_info.getId()%>" + "&post_id=" + "<%=postProfileDetail.getPost().getId()%>";
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
			<!--<jsp:include page="club_tab_menu.jsp"></jsp:include>-->


			<div id="club_board_write_profile">
				<span class="user_profile"> <img width="40px" height="40px"
					src="<%=url + "/" + attach_path + getProfileImage%>" />
				</span> <span class="user_profile">
					<div id="board_user_name"><%=postProfileDetail.getProfile().getNickname()%></div>
					<time id="board_time" datetime="2018-08-21"></time>
				</span>
			</div>

			<p>
				<%=postProfileDetail.getPost().getContent()%>
			</p>

			<%
				if (getPostImage != null) { // 이미지가 있을 때
			%>
			<div class="board_picture">
				<%
					for (int i = 0; i < getPostImage.size(); i++) {
				%>
				<div>
					<img class="board_picture_content"
						src="<%=url + "/" + attach_path + getPostImage.get(i)%>" />
				</div>
				<%
					}
				%>
			</div>
			<%
				}
			%>

			<button class="btn" type="button" onclick="back_board();">목록</button>
			<%
				Member login = login_member;
				if (login != null) { // 로그인
					if (postProfileDetail.getProfile().getMember_id() == login_member.getId()) {
			%>
			<button class="btn" type="button" onclick="modify_board();">수정</button>
			<button class="btn" type="button" onclick="delete_board();">삭제</button>
			<%
				}
				}
			%>

			<div class="club_board_comment">
				<p>댓글</p>
				<%
					login = login_member;
					if (login != null) { // 로그인
				%>
				<div id="club_board_comment">
					<span class="user_comment_profile"> <img width="40px"
						height="40px" src="<%=url + "/" + attach_path + getMyProfileImage%>" />
					</span> <span class="user_profile">
						<div id="board_user_name"><%=getMynickname%></div> <time
							id="board_time" datetime="2018-08-21">5시간 전</time>
					</span>

					<form
						action="insert_comment.do?id=<%=club_info.getId()%>&post_id=<%=postProfileDetail.getPost().getId()%>"
						id="insert_comment_form" method="post">
						<textarea name="comment_content" id="comment_content" cols="80"
							rows="6"></textarea>
						<button onclick="insert_comment();">입력</button>
					</form>
				</div>
				<%
					}
				%>


				<div id="comment_list">
					<%
						for (int i = 0; i < getCommentList.size(); i++) {
					%>

					<span class="user_comment_profile"> <img width="40px"
						height="40px"
						src="<%=url + "/" + attach_path + getCommentList.get(i).getImgUrl() %>" />
					</span> <span class="user_profile">
						<div id="board_user_name"><%=getCommentList.get(i).getNickname()%></div>
						<time id="board_time" datetime=""></time>
					</span>
					<p><%=getCommentList.get(i).getContent()%>

						<%
							login = login_member;
								if (login != null) { // 로그인
									if (getCommentList.get(i).getMember_id() == login_member.getId()) {
						%>
						<button type="button"
							onclick="delete_comment(<%=getCommentList.get(i).getId()%>);">삭제</button>
						<%
							}
						%>
						<%
							}
						%>
					</p>

					<%
						}
					%>
				</div>


			</div>

		</div>
	</div>
</body>
</html>