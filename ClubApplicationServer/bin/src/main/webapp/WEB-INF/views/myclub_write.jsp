<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Club club_info = (Club) request.getAttribute("club_info");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 : 밴드제목</title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
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

<form id="write_form" action="write_ok.do" method="post">
	<table>
	<tr>
		<td colspan="2">내용</td>
	</tr>
	<tr>
		<td colspan="2"><textarea cols="50" rows="7" class="input_content" name="content" id="content"></textarea></td>
	</tr>
	<tr>
		<td>첨부파일 : </td>
		<td><input type="file" /></td>
	</tr>
	</table>

	<div id="footer">
		<input type="button" id="write_btn_ok" value="작성" onclick="writeBoard();"/>	
	</div>
</form>

</div>

<div id="right_nav">
<jsp:include page="club_right_nav.jsp"></jsp:include>
</div>

</div>

</body>
</html>