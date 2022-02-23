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
			// ����
			// ���������� session�� DB���� ������ ���� ������ ����
			HttpSession session = request.getSession();
			session.setAttribute("vo", uvo);
		}else {
			// ����
			// �����ϸ� ���� X
		}
		
		// �������� �̵�
		response.sendRedirect("Main.jsp");
		
	}

}
