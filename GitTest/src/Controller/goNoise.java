package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberVO;
import Model.NoiseDAO;
import Model.NoiseVO;

@WebServlet("/goNoise")
public class goNoise extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		String mb_id = vo.getMb_id();
		
		// DAO �޼��� ��� -> ��� �Խñ� ��������
		NoiseDAO dao = new NoiseDAO();
		List<NoiseVO> list = dao.selectAllNoise(); // ��ü ����
		List<NoiseVO> glist = dao.selectNoise(mb_id); // ���� ����
		
		// request scope�� list ���
		request.setAttribute("list", list);
		request.setAttribute("glist", glist);
		
		// forward ��� ������ �̵�
		// response.sendRedirect("viewNoise.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("viewNoise.jsp");
		rd.forward(request, response);
	}

}
