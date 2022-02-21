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

		//인코딩
		request.setCharacterEncoding("euc-kr");
		
		//파라미터 수집
		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		String mb_dongho = request.getParameter("mb_dongho");
		String admin_yesno = request.getParameter("admin_yesno");
		//VO로 묶어서 저장
		MemberVO vo = new MemberVO(mb_id, mb_pw, mb_dongho, admin_yesno);
		//DAO에 파라미터 수집 결과를 넘겨줘서 DB에 저장
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);
		//insert into msg_member values(?, ?, ?, ?)
		//insert -> psmt.executeUpdate(); -->int 즉 몇 행 변화가 일어났는지
		//성공여부를 판단
		//성공 시 join_success.jsp로 이동
		//실패 시 main.jsp로 이동
		if (cnt > 0) {
			response.sendRedirect("join_success.jsp");
		} else {
			response.sendRedirect("goMain");
		}
	
	}

}
