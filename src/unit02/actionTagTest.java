package unit02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/actionTagTest")
public class actionTagTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public actionTagTest() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ID = request.getParameter("userID");
		String Pwd = request.getParameter("userPwd");
		String Check = request.getParameter("loginCheck");
		
		request.setCharacterEncoding("UTF-8");
		
		if(Check.equals("user")) {
			request.setAttribute("userID", ID);
			request.setAttribute("userPwd", Pwd);
			String userName = "전고객";
			RequestDispatcher dispatcher = request.getRequestDispatcher("09_userMain.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("userID", ID);
			request.setAttribute("userPwd", Pwd);
			String userName = "성관리";
			RequestDispatcher dispatcher = request.getRequestDispatcher("09_managerMain.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
