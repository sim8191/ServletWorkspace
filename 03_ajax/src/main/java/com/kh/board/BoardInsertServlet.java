package com.kh.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/board/insert.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 값을 vo클래스로 변환(HashMap) > vo클래스를 안쓸려면 모두 map으로 해야함
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		// 리스트에서 가장 큰값 가져오기
		HttpSession session = request.getSession();
		List<Map<String,Object>> list = (List)session.getAttribute("list");
		
		int bno = list.stream()
				.mapToInt( b -> ((int)b.get("bno")))
				.max()
				.orElse(0);
		// 리스트에서 가장 큰값 가져오기 끝
		
		Map<String, Object> board = new HashMap<>();
		board.put("title", title);
		board.put("writer", writer);
		board.put("content", content);
		board.put("createDate", new Date());
		board.put("bno", bno+1);
		
		list.add(board); // 세션에 다시 담아주는 행위는 불필요
		
		
		
	}

}
