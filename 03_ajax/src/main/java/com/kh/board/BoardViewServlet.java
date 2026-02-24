package com.kh.board;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 게시클 번호를 뽑아서, session에 저장된
		// list에서 bno값과 일치하는 게시글을 선택.
		int bno = Integer.parseInt(request.getParameter("bno"));
		HttpSession session = request.getSession();
		List<Map<String,Object>> list = (List<Map<String,Object>>)
				session.getAttribute("list");
		Map<String,Object> b=
				list.stream()
				.filter((board) -> {
					int no = (int) board.get("bno");
					if(bno == no) {
						return true;
					}
					return false;
				})			
				.findAny()
				.orElse(null);
		
		// 선택한 게시클을 포워딩하는 view.jsp에 request 스코프에 저장
		request.setAttribute("b", b);
		request.getRequestDispatcher("/board/view.jsp")
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
