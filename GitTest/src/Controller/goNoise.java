package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.NoiseDAO;
import Model.NoiseVO;

@WebServlet("/goNoise")
public class goNoise extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DAO 메서드 사용 -> 모든 게시글 가져오기
		NoiseDAO dao = new NoiseDAO();
		List<NoiseVO> list = dao.selectAllNoise();

		// request scope에 list 담기
		request.setAttribute("list", list);
		
		// forward 방식 페이지 이동
		// response.sendRedirect("viewNoise.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("viewNoise.jsp");
		rd.forward(request, response);
	}

}
