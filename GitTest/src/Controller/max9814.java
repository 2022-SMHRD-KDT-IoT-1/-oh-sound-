package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;
import Model.MemberVO;
import Model.NoiseDAO;
import Model.NoiseVO;

@WebServlet("/max9814")
public class max9814 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 0. 인코딩
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 1. 파라미터 수집
		String noise_db = request.getParameter("sound");
		
		// 2. DAO 사용
		
		// 3. 응답
		System.out.println(noise_db+"dB");

			
		NoiseVO vo = new NoiseVO(noise_db);  
		NoiseDAO dao = new NoiseDAO();
	
		int cnt = dao.sound(vo);
		if(cnt > 0) {
			// 성공
			response.sendRedirect("Main.jsp");
		}else {
			// 실패
			response.sendRedirect("login.html");
		}

		
		
	}

}
