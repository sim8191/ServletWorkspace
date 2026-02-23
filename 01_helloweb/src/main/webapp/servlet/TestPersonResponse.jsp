<%@page import="java.util.Arrays"%>
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
<title>검사결과페이지</title>
</head>
<body>
	<h1>개인취향 검사 결과 jsp</h1>
	<p><% out.print(name); %>님의 개인취향 검사 결과는</p>
	<p><%= color %>색을 좋아합니다.</p>
	<p>좋아하는 동물은 <%= animal %>입니다.</p>
	<% if(foodArr != null){%>
		좋아하는 음식은 <%= Arrays.toString(foodArr) %>입니다.	
	<%}	%>
	<p>오늘의 추천음식 !! <%= recommendation %></p>
	<hr>
</body>
</html>