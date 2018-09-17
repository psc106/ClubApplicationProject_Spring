<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
String attach_path = "resources/upload/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>앨범 : 밴드제목</title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
#album_content {
	border:1px solid black;
}
.album_picture {
	display: grid;
	grid-template-columns: 255px 255px 255px;
	grid-auto-rows: 250px;
	border: solid 1px black;
}
.album_picture_content{
	width:250px;
	height:250px;
	margin-right:5px;
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
<h3>앨범</h3>

<div id="album_content">
 



</div>
</div>



</div>

</body>
</html>