<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>밴드제목</title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
</style>

<script>
function club_join_ok() {
	document.location.href = "club_join_confirm.do";
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
<h3>동호회 회원가입</h3>

별명 : <input type="text" /></br>
</br>
신청 메시지</br>
<textarea cols="30" rows="4"></textarea></br>
<button onclick="club_join_ok();">신청</button>

</div>

<div id="right_nav">
<jsp:include page="club_right_nav.jsp"></jsp:include>
</div>

</div>

</body>
</html>