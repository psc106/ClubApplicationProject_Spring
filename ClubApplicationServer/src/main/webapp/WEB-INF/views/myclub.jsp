<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>밴드제목</title>
<style>
#wrap {
	width: 1200px;
	height: 1100px;
    margin: 0px auto;
    margin-top: 120px;
    border: 1px solid #828282;
	border: 1px solid black;	
}

#left_nav {
	margin-right: 30px;
    width: 18%;
    height:1100px;
    float: left;
    border: 1px solid #828282;
}

#club_content {
    width: 58%;
    height:1100px;
    float:left;
    border: 1px solid #828282;
	display: inline;
	border: 1px solid black;
}

#right_nav {
	margin-left: 30px;
    width: 18%;
    height:1100px;
    float: right;
    border: 1px solid #828282;
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
클럽 콘텐츠
</div>

<div id="right_nav">
<jsp:include page="club_right_nav.jsp"></jsp:include>
</div>

</div>

</body>
</html>