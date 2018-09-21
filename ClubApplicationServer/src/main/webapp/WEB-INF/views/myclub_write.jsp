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
<title>글쓰기 : <%=club_info.getName() %></title>
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
function writeBoard() {
	
	if( $("#board_image").val() != "" ){
		var ext = $('#board_image').val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
			return;
		}
	}

	var content = document.getElementById("content");
	if (content.value == "") {
		window.alert("내용을 입력하세요.");
		content.focus();
		return;
	}
	
	var form = document.getElementById("write_form");
	window.alert("작성 완료");
	form.submit();
}



var sel_files = [];

$(document).ready(function() {
	$("#board_image").on("change", handleImgsFilesSelect);
});

function handleImgsFilesSelect(e) {
	sel_files = [];
	$(".imgs_wrap").empty();
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	var index = 0;
	filesArr.forEach(function(f) {
		if(!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}
		
		sel_files.push(f);
		console.log("sel_files : " + sel_files);
		
		var reader = new FileReader();
		reader.onload = function(e) {
			var html = "<a href=\"javascript:void(0);\" onclick=\"\" id=\"img_id_"+index+"\"><img src=\"" + e.target.result +"\" data-file='"+f.name+"' class='selProductFile' title='Click to remove' width=200px height=200px></a>";
		    /* var img_html = "<img src=\"" + e.target.result + "\" width=200px height=200px />";
		    $(".imgs_wrap").append(img_html); */
		    $(".imgs_wrap").append(html);
		    index++;
		}
		//onclick--> deleteImageAction("+index+")
		
		
		reader.readAsDataURL(f);
		/*reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\" />";
			$(".imgs_wrap").append(img_html);
		}*/		
	});
}

/*
function deleteImageAction(index){
	  console.log("index : "+index);
	  sel_files.splice(index, 1);
	  if(sel_files.length === 0){
	   $('.imgs_wrap').empty();
	  }
	  var img_id = "#img_id_" + index;
	  $(img_id).remove();
	  
	  console.log("sel_files2 : " + sel_files);
}
*/

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


<form id="write_form" action="write_ok.do?id=<%=club_info.getId() %>" method="post" enctype="multipart/form-data">
	<table border="1">
	<tr>
		<td colspan="2">내용</td>
	</tr>
	<tr>
		<td colspan="2"><textarea cols="50" rows="7" class="input_content" name="content" id="content"></textarea></td>
	</tr>
	<tr>
		<td>첨부파일 : </td>
		<td><input type="file" id="board_image" name="board_image" multiple="multiple" accept="image/*" /></td>
	</tr>
	<tr>
		<td><div class="imgs_wrap"></div></td>
	</tr>
	</table>

	<div id="footer">
		<input type="button" id="write_btn_ok" value="작성" onclick="writeBoard();"/>	
	</div>
</form>

</div>



</div>

</body>
</html>