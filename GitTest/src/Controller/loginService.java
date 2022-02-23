package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberVO;

@WebServlet("/loginService")
public class loginService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("mb_id");
		String pw = request.getParameter("mb_pw");
		
		MemberVO vo = new MemberVO(id, pw);
		
		MemberDAO dao = new MemberDAO();
		MemberVO uvo = dao.login(vo);
		
		if(uvo != null) {
			// 성공
			// 성공했으면 session에 DB에서 꺼내온 유저 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("vo", uvo);
		}else {
			// 실패
			// 실패하면 저장 X
		}
		
		// 메인으로 이동
		response.sendRedirect("Main.jsp");
		
	}

}
