<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<% 
	// 자바 소스코드 기술하는 영역
	System.out.println("자바");
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String animal = request.getParameter("animal");
	String[] foodArr = request.getParameterValues("food");
	
	// Servlet에서 저장한데이터
	String recommendation = (String)request.getAttribute("recommendation");//다운케스팅 필요
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인취향 검사 결과 jsp</h1>
	<hr>
</body>
</html>