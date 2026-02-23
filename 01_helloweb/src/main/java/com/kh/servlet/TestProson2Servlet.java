package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProson2Servlet
 */
@WebServlet("/testPerson2.do")
public class TestProson2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProson2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post방식 요청시 클라이언트가 전달하는 데이터는
		// url의 body안에 담겨지는데, 이곳이 인코딩 환경은
		// ISO-8859-1이기 때문에 인코딩방식을 UTF-8로 변경해줘야한다.
		request.setCharacterEncoding("UTF-8");
		
		// 사용자가 입력한값 변수에 저장
		String recommendation = "";
		String color = request.getParameter("color");
		
		switch (color) {
		case "빨강" -> recommendation = "짬뽕";
		case "노랑" -> recommendation = "카레";
		case "초록" -> recommendation = "샐러드";
		case "파랑" -> recommendation = "파워";
		}
		
		// was상에서 업무로직에 의해 생성한 데이터를 
		// request에 저장하는 방법
		request.setAttribute("recommendation", recommendation);
		
		
		// 응답데이터 생성을 jsp에게 위임(froward)
		// getRequestDispatcher(요청처리를 위임할 jsp나 servlet의 매핑경로를 제시)
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/servlet/TestPersonResponse.jsp");
		
		dispatcher.forward(request, response);
		
		
//		doGet(request, response);
	}

}
