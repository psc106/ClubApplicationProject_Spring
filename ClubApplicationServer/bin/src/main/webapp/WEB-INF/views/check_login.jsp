<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer msgCheck = (Integer) request.getAttribute("msgCheck");
String msg = (String) request.getAttribute("msg");
String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
var msgCheck = "<%=msgCheck%>";
var message = "<%=msg%>";
var returnUrl = "<%=url%>";
alert(msgCheck+"1");
alert(message+"2");
alert(returnUrl+"3");
if(msgCheck == 1) {
	document.location.href = returnUrl;
}

</script>
</head>
<body>

</body>
</html>