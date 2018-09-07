<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 글 목록</title>
<link rel="stylesheet" href="resources/css/my_page.css" type="text/css">
<style>
/* 탭 css */
.tabs { 
  display: flex; 
  flex-wrap: wrap;     
} 
.tabs label { 
  width:50%; 
  order: 1; 
  display: block; 
  padding:10px 0px; 
  text-align:center; 
  cursor: pointer; 
  background: #838487; 
  font-weight: bold; 
  transition: background ease 0.2s; 
} 
/*박스배경*/ 
.tabs .tab { 
  order: 99; 
  flex-grow: 1; 
  width: 100%; 
  display: none; 
  padding: 1rem; 
  background: #92B6D5; 
} 
.tabs input[type="radio"] { 
  display: none; 
} 
/*탭 눌렀을때 컬러*/ 
.tabs input[type="radio"]:checked + label { 
  background: #92B6D5; 
} 
.tabs input[type="radio"]:checked + label + .tab { 
  display: block; 
}
/* 탭 css 끝 */
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
<div class="tabs"> 
    <input type="radio" name="tabs" id="tabone" checked="checked">     
    <label for="tabone">내가 쓴 글</label> 
    <div class="tab"> 
		<h1>내가 쓴 글</h1> 
		<p>hello1</p> 
	</div>        
    <input type="radio" name="tabs" id="tabtwo">     
    <label for="tabtwo">댓글</label> 
	<div class="tab"> 
		<h1>댓글</h1> 
		<p>hello2</p> 
	</div>        
</div>
</div>


</div>
</body>
</html>