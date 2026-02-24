package com.kh.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Map<String,Object>> list;
		
		if(session.getAttribute("list") == null) {
			list = new ArrayList<>();
			for(int i = 0 ;i < 5; i++) {
				//게시글 5개 추가
				Map<String, Object> board = new HashMap<>();
				board.put("bno", i+1);
				board.put("title", "kh게시판 " + (i+1) + "번글");
				board.put("writer", "admin");
				board.put("createDate", new Date());
				board.put("content", "zzzzzz");
				
				list.add(board);
			}
			session.setAttribute("list", list);
		}
		
//		list = (List)session.getAttribute("list"); // 필요없음
		
		request.getRequestDispatcher("/board/list.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
