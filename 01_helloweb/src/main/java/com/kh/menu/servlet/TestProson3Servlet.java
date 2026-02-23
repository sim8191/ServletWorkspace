package com.kh.menu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProson3Servlet
 */
@WebServlet("/menuOrder.do")
public class TestProson3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProson3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String main = request.getParameter("main_menu");
		String side = request.getParameter("side_menu");
		String drink = request.getParameter("drink_menu");
		
		int price = 0;
		
		switch (main) {
		case "한우버거" -> price += 5000;
		case "밥버거" -> price += 4500;
		case "치츠버거" -> price += 4000;
		}
		
		switch (side) {
		case "감자튀김" -> price += 1500;
		case "어니언링" -> price += 1700;
		}
		
		switch (drink) {
		case "콜라" -> price += 1000;
		case "사이다" -> price += 1000;
		case "커피" -> price += 1500;
		case "밀크쉐이크" -> price += 2500;
		}
		
		request.setAttribute("price", price);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/menu/menuOrder.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		doGet(request, response);
	}

}
