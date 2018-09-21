<%@page import="java.util.ArrayList"%>
<%@page import="com.teamproject.club_application.data.PostProfile"%>
<%@page import="com.teamproject.club_application.data.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club club_info = (Club) request.getAttribute("club_info");
PostProfile postProfileDetail = (PostProfile) request.getAttribute("postProfileDetail");
ArrayList<String> getPostImageList = (ArrayList<String>) request.getAttribute("getPostImageList");

String url = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
String attach_path = "resources/upload/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 : <%=club_info.getName() %></title>
<link rel="stylesheet" href="resources/css/myclub.css" type="text/css">
<style>
.imgs_wrap {
	width: 600px;
	margin-top: 50px;
}

.imgs_wrap img {
	max-width: 200px;
}

</style>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
function modify_ok() {
	var content = document.getElementById("content");

	if (content.value == "") {
		window.alert("내용을 입력하세요.");
		content.focus();
		return;
	}
	
	if (confirm("정말 수정하시겠습니까??") == true){ //확인
		var form = document.getElementById("modify_form");
		form.submit();
		alert("수정되었습니다.");
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


<form id="modify_form" action="modify_ok.do?id=<%=club_info.getId() %>&post_id=<%=postProfileDetail.getPost().getId()%>" method="post" enctype="multipart/form-data">
	<table border="1">
	<tr>
		<td colspan="2">내용</td>
	</tr>
	<tr>
		<td colspan="2"><textarea cols="50" rows="7" class="input_content" name="content" id="content"><%=postProfileDetail.getPost().getContent() %></textarea></td>
	</tr>
	<tr>
		<td>첨부파일 : </td>
	</tr>
	<tr>
		<td>
		<div class="imgs_wrap">
			<%for(int i=0; i<getPostImageList.size(); i++) { %>
				<img src="<%=url+"/"+attach_path+getPostImageList.get(i) %>"/>
			<%} %>
		</div>
		</td>
	</tr>
	</table>

	<div id="footer">
		<input type="button" id="modify" value="수정" onclick="modify_ok();"/>	
	</div>
</form>

</div>



</div>

</body>
</html>