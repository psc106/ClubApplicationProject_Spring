<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<link rel="stylesheet" href="resources/css/my_page.css" type="text/css">
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
<div id="nav">
<jsp:include page="my_page_nav.jsp"></jsp:include>
</div>

<div id="right_content">
<img src="" width="100px" height="100px" /><input type="text" placeholder="이름"/></br>

생년월일<input type="text" placeholder="년" /> <input type="text" placeholder="월" /> <input type="text" placeholder="일" /></br>
성별 <input type="radio" name="info_gender" value="man">남 <input type="radio" name="info_gender" value="woman">여
<input type="text" placeholder="이메일" />
<input type="text" placeholder="전화번호" /></br></br>

<button>변경</button>
</div>


</div>
</body>
</html>