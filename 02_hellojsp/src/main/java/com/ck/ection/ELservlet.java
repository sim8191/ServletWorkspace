package com.ck.ection;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ck.ection.model.vo.Person;

/**
 * Servlet implementation class ELservlet
 */
@WebServlet("/el/el.do")
public class ELservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 데이터를 저장할 수 있는 Servlet의 영역들
		 * 1. ServletContext(application scope)
		 *  - 어플리케이션당 1개만 존재하는 객체
		 *  - 이 영역에 데이터를 추가하면 컨텍스트 전역에서 공유하면서 사용 가능
		 *  - ServletContext는 서버가 멈추기 전까지 계속 데이터가 유지된다.
		 *  
		 * 2. HttpSession(session scope) -알아두기
		 *  - 접속한 사용자 별로 데이터르 저장할 수 있는 객체
		 *  - 개발자가 직접 HttpSession의 유지시간을 설정할 수 있다.
		 *  - 이 영역에 데이터를 추가하면 모든 Context전역에서 공유하면서 사용.가능.
		 * 
		 * 3. HttpServletRequest (request scope) -알아두기
		 *  - 클라이언트의 요청별로 매번 새롭게 생성되는 객체.
		 *  - 이 영역에 데이터를 담으면, 현재 요청을 받은 서블릿과, 포워딩받는
		 *    서블릿/jsp에서 데이터를 사용할 수 있다.
		 *  - 값이 한번 담기면, 재 요청이 이루어지는 순간 이전 request는
		 *    소멸된다.
		 *  
		 * 4. PageContext(page scope)(잘사용안함 해당)
		 *  - JSP에서만 사용가능한 영역으로, 하나의 JSP에서만 공유할
		 *  데이터를 선언하는 영역
		 *  
		 * 
		 * 
		 * */
		
		// 1. requestScope에 데이터 저장
		request.setAttribute("classRoom", "G강의장");
		request.setAttribute("student", new Person("강민서", 27,"남자"));
		
		// 2. session scope에 저장
		HttpSession session = request.getSession();
		session.setAttribute("academy", "KH정보교육원");
		session.setAttribute("teacher", new Person("민경민", 28,"남자"));
		
		// 3. application scope
		ServletContext application = request.getServletContext();
		application.setAttribute("scope", "application");
		
		session.setAttribute("scope", "세션");
		
		request.getRequestDispatcher("/el/01_el.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
