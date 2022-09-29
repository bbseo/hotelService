package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelServiceDAO.LoginDAO;
import hotelServiceDTO.memberDTO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		if(command == null) {
			
		}
		
		if(command.equals("login")) {
			login(response, request);
		} else if(command.equals("join")) {
			signUp(response, request);
		} else if(command.equals("checkId")) {
			checkId(response, request);
		} else if(command.equals("findPw")) {
			findPw(response, request);
		} else if(command.equals("logout")) {
			logOut(response, request);
		}
		
	}
	
	public void login(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		String result = "";
		
		HttpSession memberSession = request.getSession(false);
		HttpSession adminSession = request.getSession(false);
		
		try {
			result = LoginDAO.login(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result == "Admin") {
			adminSession.setAttribute("adminId" , id);
			response.sendRedirect("memberPage.jsp");
		} 
		else if(result == "Member") {
			memberSession.setAttribute("memberId", id);
			response.sendRedirect("member");
		}
		else {
			PrintWriter out = response.getWriter();
			
			out.println("<script language='javascript'>");
			out.println("alert('알림창')");
			out.println("</script>");

			out.flush();
		}
	}
	
	
	public boolean checkId(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String id = request.getParameter("user_id");
		
		boolean result = true;
		
		try {
			result = LoginDAO.checkId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.addHeader("result", String.valueOf(result));
		return result;
	}
	
	public void signUp(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		boolean result = false;
		
		try {
			result = LoginDAO.signUp(new memberDTO(name, id, pw, tel, email));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "회원가입 실패");
		}
		
		if(result) {
			response.sendRedirect("Login.jsp");
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void findPw(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		
		
		String result = "";
		
		try {
			result = LoginDAO.findPw(id, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.addHeader("result", String.valueOf(result));
	}
	
	public void logOut(HttpServletResponse response, HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		response.sendRedirect("index.html");
	}

}
