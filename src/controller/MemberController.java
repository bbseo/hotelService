package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotelServiceDAO.memberDAO;
import hotelServiceDTO.memberDTO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");

		if (command == null) {
			command = "memberList";
		}
		if (command.equals("memberList")) {
			memberList(request, response);
		} else if(command.equals("addAdmin")) {
			addAdmin(request, response);
		} else if(command.equals("memberchange")) {
			memberChange(request, response);
		} else if(command.equals("memberupdate")) {
			memberUpdate(request, response);
		} 
//		else if(command.equals("memberdelete")) {
//			memberDelete(request, response);
//		}
	}

	private void memberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		try {
			request.setAttribute("memberList", memberDAO.getAllContents());
			request.getParameter("memberList");
			url = "memberList.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "모두 보기 실패 재 실행 해 주세요");
		}
		request.getRequestDispatcher(url).forward(request, response);

	}
	
	private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name=request.getParameter("name");
		String id=request.getParameter("id");				
		String pw=request.getParameter("pw");				
		String tel=request.getParameter("tel");				
		String email=request.getParameter("email");
		
		//데이터값 입력 유무만 유효성 검증
		if(name == null || name.trim().length() == 0 ||
			id == null || id.trim().length() == 0 ||
			pw == null || pw.trim().length() == 0 ||
			tel == null || tel.trim().length() == 0 ||
			email == null || email.trim().length() == 0 ){
			response.sendRedirect("addAdmin.jsp");
			return;//write() 메소드 종료
		}
		
		boolean result = false;
		
		try {
			result = memberDAO.addAdmin(new memberDTO(name,id,pw,tel,email));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
		}
		
		if(result){
			response.sendRedirect("member"); 
		}else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	private void memberChange(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String memberNum=request.getParameter("num");
		
		if(memberNum==null || memberNum.length() == 0){
			response.sendRedirect("member");
			return;
		}
		String url = "error.jsp";
		memberDTO gContent = null;
		try {
			gContent = memberDAO.getContent(Integer.parseInt(memberNum));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 읽기 실패");
		}
		if(gContent == null){
			request.setAttribute("error", "해당 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "memberchange.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum=request.getParameter("num");
		String name=request.getParameter("name");
		String id=request.getParameter("id");				
		String pw=request.getParameter("pw");				
		String tel=request.getParameter("tel");				
		String email=request.getParameter("email");
		String grade=request.getParameter("grade");
		String position=request.getParameter("position");
		
		if(strNum == null || strNum.trim().length() == 0 ||
			name == null || name.trim().length() == 0 ||
			id == null || id.trim().length() == 0 ||
			pw == null || tel.trim().length() == 0 ||
			email == null || pw.trim().length() == 0 ||
			tel == null || email.trim().length() == 0 ||
			grade == null || grade.trim().length() == 0 ||
			position == null || position.trim().length() == 0 ){
				response.sendRedirect("member");
				return;
		}
		
		boolean result = false;
		
		try {
			result = memberDAO.updateContent(new memberDTO(Integer.parseInt(strNum),name,id,pw,tel,email,grade,position));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 수정 실패");
		}
		if(result){
			response.sendRedirect("member");
			return;
		}
		request.setAttribute("error", "게시글 수정 실패");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	private void memberDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("num");
		String pw = request.getParameter("pw");
		
		if(strNum == null || strNum.trim().length() == 0 ||
			pw == null || pw.trim().length() == 0){
			response.sendRedirect("member");
			return;				
		}
		boolean result = false;
		try {
			result = memberDAO.deleteContent(Integer.parseInt(strNum),pw);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "해당 게시글 삭제 실패했습니다. 재 시도 하셔요");
		}
		if(result){
			response.sendRedirect("member");			
			return;
		}else{
			request.setAttribute("error", "삭제하려는 게시글이 존재하지 않습니다");
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
}
