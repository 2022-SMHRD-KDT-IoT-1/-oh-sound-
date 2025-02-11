package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;
import Model.MemberVO;

@WebServlet("/joinService")
public class joinService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("mb_id");
		String pw = request.getParameter("mb_pw");
		String dongho = request.getParameter("mb_dongho");
		
		MemberVO vo = new MemberVO(id,pw,dongho);
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.join(vo);
		
		if(cnt > 0) {
			// ����
			response.sendRedirect("Main.jsp");
		}else {
			// ����
			response.sendRedirect("login.html");
		}
	}

}
