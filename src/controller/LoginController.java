package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotelServiceDAO.LoginDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");
		
		if(command.equals("login")) {
			login(response, request);
		}
	}
	
	public void login(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id == null || pwd == null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		boolean result = true;
		
		try {
			result = LoginDAO.login(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "ID나 PASSWORD가 틀립니다");
		}
		
		if(result) {
			response.sendRedirect("Login.jsp");
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
