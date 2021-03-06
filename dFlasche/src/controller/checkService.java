package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class checkService
 */
@WebServlet("/checkService")
public class checkService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 파라미터 수집
		String id = request.getParameter("id");

		// 2. DAO 사용
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.idCheck(id);
		
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		// vo가 비어있으면 out.print(true); --> 사용가능한 아이디
		// vo가 비어있지 않으면 out.print(false); --> 중복된 아이디
		out.print( vo == null );
	
	}

}
