<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>Home</title>
</head>
<style>
*{
	box-sizing:border-box;
}
#wrap {
	margin:0 auto;
	margin-top:70px;
	border:1px solid black;
	width:900px;
	height: 1000px;
	display: block;
}
#top_content {
	border: 1px solid black;
	height: 400px;
}
#main_logo {
	text-align: center;
}
.home_search {
	text-align: center;
}
</style>

<script>
</script>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>

<div id="wrap">
<div id="top_content">
<div id="main_logo" name="main_logo"><img width="500px" height="300px" src="resources/main_logo.png" /></div><br>
<div class="home_search">
<input type="text" id="home_search" name="home_search" />
<input type="button" id="home_search_btn" name="home_search_btn" value="°Ë»ö" />
</div>
</div>

<div id="bot_content">

</div>

</div>

</body>
</html>
