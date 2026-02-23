<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. formatNumber</h1>
	<p>
		숫자데이터의 포멧 지정
		 - 표현하고자 하는 숫자데이터 형식을 원하는 쓰임에 맞게 지정하는 태그<br>
		 
		 fmt:formetNumber value='출력할 값'
		 groupingUased = 'true/false'
		 type='percent/currency'
		 currencySymbol='통화기호'
		 
	</p>
	
	<c:set var="num1" value="123456789"/>
	<c:set var="num2" value="1.123"/>
	<c:set var="num3" value="50000"/>
	
	단순출력 : ${num1 }<br>
	세자리단위로 구분하여 출력 : <fmt:formatNumber value="${num1 }" /> <br>
	세자리단위로 구분X 출력 : <fmt:formatNumber value="${num1 }" groupingUsed="false"/> <br>
	
	percent : <fmt:formatNumber value="${num2 }" type="percent"/> <br>
	currency : <fmt:formatNumber value="${num3 }" type="currency"/> <br>
	currencySymbol바꿈 : <fmt:formatNumber value="${num3 }" type="currency" currencySymbol="$"/> <br>
	
	<h3>2. formatDate</h3>
	<p>
		java.util.Date객체의 출력형식을 지정하는 태그
	</p>
	<c:set var="current" value="<%= new java.util.Date() %>"/>
	
	<ul>
		<li>
			현재 날짜 : <fmt:formatDate value="${current }"
				type="date"
			/>
		</li>
		<li>
			현재 시간 : <fmt:formatDate value="${current }"
				type="time"/>
		</li>
		<li>
			커스터 마이징 : <fmt:formatDate value="${current }"
				pattern="yyyy-MM-dd HH:mm:ss"/>
			
		</li>	
	</ul>
	
	
	
	
</body>
</html>