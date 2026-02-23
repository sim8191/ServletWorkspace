<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>include</h3>
	<p>현재 페이지에 또다른 jsp를 포함하고자 할때 사용하는 태그</p>
	
	<h4>1. include 지시어를 활용한 페이지를 포함(정적 포함방식)</h4>
	<%@ include file="/jsp/footer.jsp" %>
	
	<br> <br>
	특징 : include하고 있는 페이지상에 선언된 변수를 현제 페이지에서도
	사용 가능 <br>
	
	<h4>2.JSP표준 액션태그 include를 활용한 방식(동적 포함 방식)</h4>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	
	<br> <br>
	
	특징 1. include하고 있는 페이지에 선언한 변수들을 공유하지 않는다. <br>
	<%-- <%= name %> --%>
	특징 2. include시 include되는 jsp로 파라미터를 전달할 수 있다. <br>
	<jsp:include page="/jsp/footer.jsp">
		<jsp:param value="hello" name="test"/>
	</jsp:include>
	
</body>
</html>