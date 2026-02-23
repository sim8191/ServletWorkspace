<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML주석 -->
	<%-- jsp 주석 : 개발자 도구에 노출되지 않는다. --%>
	<h1>스크립팅 원소</h1>
	<%
		// 스크립틀립 : 일반적인 자바 코드 작성
		System.out.println("스크립틀릿");
		int num = 1;
	%>
	<p>
	화면상에 변수를 출력하고자 한다면...<pr>
	1. 스클립틀릿을 활용 : <% out.print(num); %>
	2. 표현식(출력식) 활용 : <%= num %>
	</p>
	<%
		String[] names = {"서우성", "전부진", "강민서"};
	%>
	<h4>jsp에서 반복문 사용하기</h4>
	<ul>
		<% for(String name : names) { %>
			<li><%=name %>></li>
		<% } %>
	</ul>
	
</body>
</html>