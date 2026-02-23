package com.kh.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleserver
 */
@WebServlet("/life")
public class LifeCycleserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleserver() {
        super();
        System.out.println("서블릿 객체 최초 생성");
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init 메서드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		// 사용자의 요청정보중 "요청방식"의 정보를 가져와서
		// 요청방식이 Get이라면 doGet메서드를,
		// 요청방식이 POST라면 doPost메서드를 실행하는 메서드
		String method = req.getMethod();
		System.out.println("service() : " + method);
		if(method.equals("GET")) {
			doGet(req, resp);
		}else {
			doPost(req, resp);
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
