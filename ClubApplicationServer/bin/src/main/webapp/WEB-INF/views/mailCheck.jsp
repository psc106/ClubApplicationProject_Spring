<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String use_mail = (String)request.getAttribute("use_mail");
String mail = (String)request.getAttribute("mail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 체크</title>
<style>
</style>

<script>
function checkMail() {
	var mail = document.getElementById("mail");
	if(mail.value == "") {
		alert("메일을 입력하세요");
		return;
	}
	
	var form = document.getElementById("form_mail_check");
	form.submit();
}

function useMail() {
	var use_mail = <%=use_mail %>;
	alert(use_mail);
	if(use_mail == null || use_mail.value == "0") {
		alert("중복 체크를 하세요");
		return;
	}
	
	opener.document.getElementById("check_mail").value = "<%= use_mail %>";
	opener.document.getElementById("login_mail").value =
		document.getElementById("mail").value;
	window.close();
}
</script>
</head>
<body>
<form id="form_mail_check" action="mailCheck_ok.do" method="post">
아이디 : <input type="text" value="<%=mail %>" name="mail" id="mail" /> <button type="button" onclick="checkMail();">중복 확인</button>
<button type="button" onclick="useMail();" >사용하기</button>
<%if (use_mail == null) { %>
아이디 중복 체크를 하세요.
<%} else if(use_mail.equals("0")) { %>
사용할 수 없는 아이디 입니다.
<%} else { %>
사용 가능한 아이디 입니다.
<%} %>
</form>
</body>
</html>