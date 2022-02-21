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

		//���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		//�Ķ���� ����
		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		String mb_dongho = request.getParameter("mb_dongho");
		String admin_yesno = request.getParameter("admin_yesno");
		//VO�� ��� ����
		MemberVO vo = new MemberVO(mb_id, mb_pw, mb_dongho, admin_yesno);
		//DAO�� �Ķ���� ���� ����� �Ѱ��༭ DB�� ����
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);
		//insert into msg_member values(?, ?, ?, ?)
		//insert -> psmt.executeUpdate(); -->int �� �� �� ��ȭ�� �Ͼ����
		//�������θ� �Ǵ�
		//���� �� join_success.jsp�� �̵�
		//���� �� main.jsp�� �̵�
		if (cnt > 0) {
			response.sendRedirect("join_success.jsp");
		} else {
			response.sendRedirect("goMain");
		}
	
	}

}
