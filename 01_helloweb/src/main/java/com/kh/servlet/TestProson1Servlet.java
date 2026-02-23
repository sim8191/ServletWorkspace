package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProson1Servlet
 */
// testPerson1.html에서 action="/hello/testPerson1.do" 와 같아야 함
@WebServlet("/testPerson1.do")
public class TestProson1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProson1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Servlet
	 *  - 자바를 사용해서 동적인 웹페이지를 만들기 위해 필요한 기술
	 *  - 사용자의 요청을 받아 처리하고, 그에 해당하는 응답페이지를
	 *   만들어서 다시 사용자에게 응답하는 역활을 하는 자바 클래스.(Controller)
	 *  - 웹에서 동적인 페이지를 자바를 통해 구현할 수 있게 도와주는 서버측
	 *   프로그램(와스에서 구동가능)
	 *  
	 * Servlet 생명주기
	 *  - 서버구동 내내 딱 하나의 객체만 만들엇져서 처리된다.(싱글톤 패턴)
	 * 1. Servlet 객체 생성
	 * 2. init메서드 호출
	 * 3. HttpServlet의 service메서드 호출(매 클라이언트 요청마다)
	 * 4. 전송방식에 따라 doGet | doPost호출
	 * 5. destory호출
	 * 
	 * GET / POST -- 여기는 꼭 외우기
	 *  - 서비스 호출 전후로 DB의 상태가 바뀌지 않는 서비스는 GET(SELECT)
	 *  - 서비스 호출의 결과로 DB의 상태가 바뀌는 서비스는 POST(DML)
	 *  - login과 같이 id/bwd의 url노출을 막아야 한다면 POST
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * HttpServletRequest
		 *  - 서비스 요청시 사용자가 전송한 입력값, 요청전송방식, URL등,
		 *    요청정보와 관련된 데이터가 담겨있는 객체
		 * HttpServletResponse
		 *  - 응답정보를 담아줄 객체.
		 * 
		 * */
		
		// 1. HttpServletRequest의 메서드들
		//  - 사용자가 입력한 값 가져오기
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		// 동일한 key값으로 여러개의 값이 전달된 경우, getParameterValues
		String[] foodArr = request.getParameterValues("food");
		System.out.println("이름"+name);
		System.out.println("색상"+color);
		System.out.println("동물"+animal);
		System.out.println("음식"+Arrays.toString(foodArr));
		
		// 2. 응답메세지 작성(Response)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>검사 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인 취향 검사 결과 </h1>");
		out.println("<p>"+name+"님의 검사결과</p>");
		out.println("<p>"+color+"색을 좋아합니다.</p>");
		out.println("<p>좋아하는 동물은 "+animal+"입니다.</p>");
		out.println("<p>좋아하는 음식은 "+Arrays.toString(foodArr)+"입니다.</p>");
		out.println("</body>");
		out.println("</html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
