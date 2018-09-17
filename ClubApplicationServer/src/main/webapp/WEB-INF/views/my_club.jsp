<%@page import="java.util.ArrayList"%>
<%@page import="com.teamproject.club_application.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> getMyclubList = (ArrayList<String>)request.getAttribute("getMyclubList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 동호회</title>
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
<h3>내 동호회 목록</h3>
<ul>
<%for(int i=0; i<getMyclubList.size(); i++) { %>
	<li><%=getMyclubList.get(i) %></li>
<%} %>
</ul>
</div>


</div>
</body>
</html>