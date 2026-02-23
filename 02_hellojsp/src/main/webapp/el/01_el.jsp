<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ck.ection.model.vo.Person" %>
<%  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. 스클립틀릿과 표현식을 이용하여 각 영역에 담긴 값을 추출</h3>
	<%-- <%
		// request scope
		String classRoom = (String)request.getAttribute("classRoom");//꺼내쓸때는 다운케스팅필수(오브젝트로 되어있어서)
		Person student = (Person)request.getAttribute("student");
		
		// session scope
		String academy = (String)session.getAttribute("academy");
		Person teacher = (Person)session.getAttribute("teacher");
	%>
	<p>
		학원명 : <%=academy %> <br>
		강의명 : <%=classRoom %> <br>
		강사 정보 : <%=teacher %> <br>
		수강생 정보 : <%=student %> <br>
	</p> --%>
	
	<h3>2. EL을 활용한 데이터 추출</h3>
	<p>
		학원명 : ${ academy } <br>
		강의명 : ${classRoom} <br>
		강사 정보 : ${teacher} <br>
		강사 정보 : 이름 ${teacher.name}, 나이 ${teacher.age}, 성별 ${teacher.gender} <br>
		수강생 정보 : ${student} <br>
	<!-- 
		El로 teacher에 접근시 teacher의 자료형은 Person.
		Person과 같이 참조자료형의 각 필드에 담긴 값을 출력하고자 한다면,
		객체명.필드명으로 접근하면 된다.
		
		필드명 작성시 각 클래스의 getter메서드를 호출하여 데이터를 바인딩해준다.
	 -->
	 </p>
	 
	 <hr>
	 
	 <h3>3. EL사용시 내장 객체들에 저장된 키값이 동일한 경우</h3>
	<!-- 
		EL은 공유범위가 가장 적은 Scope에서부터 키값을 탐색해 나간다.
		page -> request -> session -> application
		각 스코프를 탐색하며, 내가 지정한 키값이 존재하는 경우 해당 키값을
		화면상에 바인딩한다.
	 -->
	 scope값 : ${scope} <br>
	 <hr>
	 <h3>4. 직접 scope영역에 접근하여 데이터 가져오기</h3>
	 <% 
	 	pageContext.setAttribute("scope","page");
	 %>
	 pageScope에 담긴 값 : ${scope } 또는 ${pageScope.scope } <br>
	 requestScope에 담긴 값 : ${requestScope.scope } <br>
	 sessionScope에 담긴 값 : ${sessionScope.scope } <br>
	 applicationScope에 담긴 값 : ${applicationScope.scope } <br>
	 
	
	
</body>
</html>